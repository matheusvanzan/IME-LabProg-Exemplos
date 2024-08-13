import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};

        System.out.println(cars[0]); // Volvo        
        System.out.println(cars.length); // 4

        System.out.println(cars); // [Ljava.lang.String;@6504e3b2
        System.out.println(Arrays.toString(cars)); // [Volvo, BMW, Ford, Mazda]

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        for (String i : cars) {
            System.out.println(i);
        }

        String[] cars2;



        System.out.println(Arrays.toString(cars));
        
    }


}
