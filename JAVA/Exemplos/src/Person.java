import java.time.LocalDate;
import java.util.Objects;

class Person implements Cloneable {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    // Construtor
    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Método toString para retornar uma representação em string do objeto
    @Override
    public String toString() {
        return "Person{firstName='" + firstName + "', lastName='" + lastName + "', birthDate=" + birthDate + '}';
    }

    // Método hashCode para gerar um código hash para o objeto
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthDate);
    }

    // Método equals para verificar a igualdade entre dois objetos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

        return Objects.equals(firstName, person.firstName) &&
               Objects.equals(lastName, person.lastName) &&
               Objects.equals(birthDate, person.birthDate);
    }

    // Método clone para criar uma cópia do objeto
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Criando um novo objeto Person com atributos copiados
        Person cloned = new Person(this.firstName, this.lastName, this.birthDate);
        return cloned;
    }
}

class ExemploClasseMetodos {
    // Método main para demonstrar o uso
    public static void main(String[] args) {
        try {
            LocalDate birthDate1 = LocalDate.of(1990, 2, 1); // 1 de fevereiro de 1990
            Person person1 = new Person("Alice", "Smith", birthDate1);
            LocalDate birthDate2 = LocalDate.of(1995, 6, 15); // 15 de junho de 1995
            Person person2 = new Person("Bob", "Johnson", birthDate2);

            // Demonstração do toString
            System.out.println(person1); // Saída: Person{firstName='Alice', lastName='Smith', birthDate=1990-02-01}
            System.out.println(person2); // Saída: Person{firstName='Bob', lastName='Johnson', birthDate=1995-06-15}

            // Demonstração do equals
            System.out.println(person1.equals(person2)); // Saída: false

            Person person3 = new Person("Alice", "Smith", LocalDate.of(1990, 2, 1));
            System.out.println(person1.equals(person3)); // Saída: true

            // Demonstração do hashCode
            System.out.println(person1.hashCode()); // Saída exemplo: -123456789
            System.out.println(person3.hashCode()); // Mesma saída que o hashCode de person1

            // Demonstração do clone
            Person person4 = (Person) person1.clone();
            System.out.println(person4); // Saída: Person{firstName='Alice', lastName='Smith', birthDate=1990-02-01}
            System.out.println(person1.equals(person4)); // Saída: true
            System.out.println(person1 == person4); // Saída: false (referências de objetos diferentes)

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
