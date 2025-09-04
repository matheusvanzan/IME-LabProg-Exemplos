import java.time.LocalDate;
import java.util.Objects;

public class Person {
    
    // primeiro nome, sobrenome, data nasc

    private String firstName;
    private String lastName;
    private LocalDate birthDate;

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

    public String getFullName() {
        return this.firstName + " " + lastName;
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

    @Override
    public String toString() {
        return "Person {firstName=" + this.firstName + "}";
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        // return super.hashCode();
        return Objects.hash(this.firstName, this.lastName);
    }

    @Override
    public boolean equals(Object other) {
        // TODO Auto-generated method stub

        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;

        Person pOther = (Person) other;

        return this.firstName.equals(pOther.firstName) &&
                this.lastName.equals(pOther.lastName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person cloned = new Person(this.firstName, this.lastName, this.birthDate);
        return cloned;
    }

}

class PersonUsage {
    public static void main(String[] args) {
        

        LocalDate birthDate1 = LocalDate.of(1990, 2, 1); // 1 de fevereiro de 1990
        Person p1 = new Person("Alice", "Smith", birthDate1);
        LocalDate birthDate2 = LocalDate.of(1995, 6, 15); // 15 de junho de 1995
        Person p2 = new Person("Bob", "Johnson", birthDate2);

        Person p3 = new Person("Bob", "Johnson", birthDate2);

        System.out.println(p1);
        System.out.println(p1.hashCode());

        System.out.println(p2);
        System.out.println(p2.hashCode());

        System.out.println(p2.equals(p3));

    }
}
