import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        User u1 = new User("user1", "pass1");
        User u2 = new User("user2", "pass2");

        HashMap<String, User> map1 = new HashMap<>();
        map1.put("u1", u1);
        map1.put("u2", u2);
        System.out.println(map1);

        HashMap<User, String> map2 = new HashMap<>();
        map2.put(u1, "tag1");
        map2.put(u2, "tag2");
        System.out.println(map2);

        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());

    }
}
