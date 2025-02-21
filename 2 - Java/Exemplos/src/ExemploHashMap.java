import java.util.HashMap;

public class ExemploHashMap {

    public static void main(String[] args) {

        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        String city = capitalCities.get("England"); // London
        System.out.println(city);

        System.out.println(capitalCities); // {USA=Washington DC, Norway=Oslo, England=London, Germany=Berlin}
        System.out.println(capitalCities.keySet()); // [USA, Norway, England, Germany]
        System.out.println(capitalCities.values()); // [Washington DC, Oslo, London, Berlin]        
    }
}
