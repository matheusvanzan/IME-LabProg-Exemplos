# App CRUD 

Nessa aplicação, utilizamos um serviço (UserService) para as operações de lógica de negócio da aplicação.

Este passo a passo assume o seguinte:

- Um servidor MySQL (ou outro SQL) instalado e configurado
- Spring Boot instalado e configurado

## Criação do app Spring

Crie uma aplicação Spring, com as seguintes dependências

- Spring Web
- Spring Data JPA
- MySQL Driver

## Configuração do Banco

- Criação do banco de dados (Para o MySQL, utilizar o phpMyAdmin do XAMPP)
- Criação de um novo usuário (caso não exista)
- Editar o arquivo src/main/resources/application.properties

```jsx
spring.application.name=crud

spring.datasource.url=jdbc:mysql://localhost:3306/NOME_DB
spring.datasource.username=USERNAME
spring.datasource.password=SENHA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

```

## Entity

- Crie uma entidade User (no pacote entities)
- O User poderia criar o próprio token, porém isso insere uma dependência se no futuro quiser mudar o modo como o Token é gerado precisamos mudar o User

```java
package com.example.labprog.tokenauth.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime createdAt;
    private String authToken;
    private LocalDateTime authTokenExpiration;
    private LocalDateTime lastLogin;
    private boolean isAdmin;
    private boolean isActive;

    public User() {
    }

    public User(String username, String email, String firstName, String lastName, String password,
                LocalDateTime createdAt, String authToken, LocalDateTime authTokenExpiration, LocalDateTime lastLogin, boolean isAdmin, boolean isActive) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.createdAt = createdAt;
        this.authToken = authToken;
        this.authTokenExpiration = authTokenExpiration;
        this.lastLogin = lastLogin;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }

    // Getters and Setters for all fields

```

## Repository

- Crie um repositório e os métodos necessários
- Ex: para obter um User pelo atributo “username”, o método será findUserByUsername()

```java
package com.example.labprog.tokenauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labprog.tokenauth.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}

```

## Service

- Preciso de acesso ao Repository, mas ele so pode ser inicializado (Autowired) no contexto da aplicação (Controller)
- Passo o UserRepository como argumento do contrutor
    - Chamamos isso de injeção de dependência

```jsx
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
```

## Controller

- Aqui podemos conectar o repositório (automático do Hibernate)
- Mas o Service realiza as operações de lógica de negócio

```jsx
@RestController
public class UserController {

		@Autowired // repositório criado automaticamente pelo Spring
    private UserRepository userRepository;

    private UserService userService;

    // public UserController() {
    //     Aqui o userRepository ainda não está disponível
    //     pois o userController ainda não foi instanciado.
    // }

    @PostConstruct
    public void initialize() { 
		    // Aqui o nome do método poderia ser qualquer um. 
			  // O importante é o @PostConstruct, que faz ele ser 
			  // chamado após a criação do objeto de UserController. 
        userService = new UserService(userRepository);
    }

    @GetMapping("/")
    public List<User> home() {
        return userService.findAll();
    }
}
```

## Operações de CRUD

### Read

```java
// R - READ - GET
@GetMapping(path="/all")
public Iterable<User> getAllUsers() {
    return userService.findAll();
}

@GetMapping(path="/search/{username}")
public User searchUserByUsername(@PathVariable("username") String username) {        
    return userService.findByUsername(username);
}
```

### Create

- o Repository apenas salva um novo objeto User
- o Service cria o novo usuário a partir dos dados
- o Controller recebe as info e chama o Service
    - validação de dados
    - operações com o BD ele redireciona

```java
// C - CREATE - POST
@PostMapping("/create")
public HashMap<String, Object> create(
    @RequestParam(defaultValue = "") String username, 
    @RequestParam(defaultValue = "") String password ) {

    String returnStatus = "";
    User newUser = null;
    
    if (username.equals("") || password.equals("")) {
        returnStatus = "Erro!";
    }

    newUser = userService.createUser(username, password);
    returnStatus = "User created";

    HashMap<String, Object> response = new HashMap<>();
    response.put("status", returnStatus);
    response.put("user", newUser);
    return response;
}
```

```java
public User createUser(String username, String password) {
    // aqui eu poderia:
    // - fazer um hash da senha
    // - conferir username duplicado

    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    user.setCreatedAt(LocalDateTime.now());

    return userRepository.save(user);
}
```

### Update

```java
// U - UPDATE - PUT
  @PutMapping(path="/update/{id}")
  public HashMap<String, Object> updateUserById(
      @PathVariable("id") Integer id, 
      @RequestParam String username) {  

      String returnStatus = "";
      User newUser = null;
          
      if (username.equals("")) {
          returnStatus = "Erro!";
      }

      newUser = userService.updateUsername(id, username);
      returnStatus = "User created";

      HashMap<String, Object> response = new HashMap<>();
      response.put("status", returnStatus);
      response.put("user", newUser);
      return response;     
  }
```

```java
public User updateUsername(Integer id, String username) {
    Optional<User> userOptional = userRepository.findById(id);
    if (userOptional.isPresent()) {

        User user = userOptional.get();
        user.setUsername(username);
        userRepository.save(user);
        return user;
    }

    return new User();
}
```

### Delete

```java
// D - DELETE - DELETE
@DeleteMapping(path="delete/{id}")
public Boolean deleteUserById(@PathVariable("id") Integer id) {
    return userService.deleteUser(id);
}
```

```java
public boolean deleteUser(Integer id) {
    Optional<User> userOptional = userRepository.findById(id);

    if (userOptional.isPresent()) {
        User user = userOptional.get();
        userRepository.delete(user);
        return true;
    }

    return false;
}
```