package com.example.labprog.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Arrays;

@Component
public class CrudRunner implements ApplicationRunner  {

    final String ADMIN_USERNAME = "matheusvanzan";
    final String ADMIN_EMAIL = "vanzan@gmail.com";

    @Autowired
    private UserRepository userRepository;

    public void createUsers() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        List<User> users = Arrays.asList(
            new User(ADMIN_USERNAME, ADMIN_EMAIL, "Matheus", "Vanzan", LocalDateTime.parse("2024-01-09 07:06:51", formatter), true, false),

            new User("richardsonamy", "racheltaylor@hotmail.com", "Valerie", "Mercer", LocalDateTime.parse("2024-01-09 07:06:51", formatter), true, false),
            new User("qwilkins", "huffjorge@gmail.com", "Christopher", "Phillips", LocalDateTime.parse("2024-03-15 20:28:06", formatter), false, true),
            new User("edward10", "michelleramos@smith-ingram.net", "Joy", "Patel", LocalDateTime.parse("2024-06-16 16:37:14", formatter), false, true),
            new User("jeffreyrios", "heather04@stone.com", "Jacob", "Reed", LocalDateTime.parse("2024-05-13 19:08:57", formatter), true, false),
            new User("michaelconway", "theresa09@gmail.com", "Patricia", "Mcdonald", LocalDateTime.parse("2024-02-19 07:37:15", formatter), true, false),
            new User("amycoleman", "thomas36@henderson.org", "Jamie", "Chang", LocalDateTime.parse("2024-01-27 17:18:13", formatter), true, true),
            new User("don58", "angelacampbell@hotmail.com", "Amanda", "Williams", LocalDateTime.parse("2024-08-12 11:52:36", formatter), false, false),
            new User("greentheodore", "ejacobson@yahoo.com", "Lisa", "Miller", LocalDateTime.parse("2024-08-09 13:11:38", formatter), false, true),
            new User("robyn92", "shannon61@nelson.org", "Derek", "Carrillo", LocalDateTime.parse("2024-07-18 08:43:07", formatter), false, true),
            new User("berrymelissa", "cindydodson@davidson-wallace.com", "James", "Mitchell", LocalDateTime.parse("2024-01-25 05:32:32", formatter), true, true)
        );

        for (User user : users) {
            userRepository.save(user);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       System.out.println("CrudRunner");
       System.out.println(args); // [--server.port=8090, --createdb=true]

       Iterable<User> users = userRepository.findAll();
       Boolean usersCreated = users.iterator().hasNext();

       System.out.println("usersCreated? " + usersCreated);

       if (!usersCreated) {
        System.out.println("Creating users");
        createUsers();
       }       

        if (args.containsOption("createdb")) {

            String createdbValue = args.getOptionValues("createdb").get(0);
            if ("true".equals(createdbValue)) {
                System.out.println("CreateDB = true");
                
                // createDB() ...

            } else {
                System.out.println("CreateDB != true.");
            }
        }
    }
}