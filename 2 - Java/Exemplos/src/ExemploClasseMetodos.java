import java.time.LocalDate;

class ExemploClasseMetodos {

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

