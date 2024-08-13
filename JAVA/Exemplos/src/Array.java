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

        for (String c : cars) {
            System.out.println(c);
        }

        // Cópia
        String[] cars2 = copyArray(cars);
        System.out.println("cars  = " + Arrays.toString(cars));
        System.out.println("cars2 = " + Arrays.toString(cars2));
        
    }


    public static String[] copyArray(String[] arrayOriginal) {

        String[] arrayCopy = new String[arrayOriginal.length];

        for (int i = 0; i < arrayOriginal.length; i++) {
            arrayCopy[i] = arrayOriginal[i];
        }
        
        return arrayCopy;
    }


}
