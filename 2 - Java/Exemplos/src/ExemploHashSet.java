import java.util.HashSet;

public class ExemploHashSet {

    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW"); // adicionado novamente
        cars.add("Mazda");

        System.out.println(cars.size()); // 4
        System.out.println(cars); // [Volvo, Mazda, Ford, BMW]

        System.out.println(cars.contains("Mazda")); // true
        System.out.println(cars.contains("Ferrari")); // false
    }
}
