import java.util.ArrayList;
import java.util.List;

interface User {
    void login();
    void logout();
    String getRole();
    String getUsername();
}

class AdminUser implements User {
    private String username;

    public AdminUser(String username) { this.username = username; }

    @Override
    public void login() { System.out.println(username + " (Admin) logged in."); }

    @Override
    public void logout() { System.out.println(username + " (Admin) logged out."); }

    @Override
    public String getRole() { return "Admin"; }

    @Override
    public String getUsername() { return username; }

    public void manageSystem() { System.out.println(username + " is managing the system."); }
}

class RegularUser implements User {
    private String username;

    public RegularUser(String username) { this.username = username; }

    @Override
    public void login() { System.out.println(username + " (User) logged in."); }

    @Override
    public void logout() { System.out.println(username + " (User) logged out."); }

    @Override
    public String getRole() { return "Regular User"; }

    @Override
    public String getUsername() { return username; }

    public void browseContent() { System.out.println(username + " is browsing content."); }
}

class ExemploInterface2 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new AdminUser("admin1"));
        users.add(new RegularUser("user1"));
        users.add(new AdminUser("admin2"));
        users.add(new RegularUser("user2"));

        for (User user : users) {
            user.login();
            
            if (user.getRole().equals("Admin")) { 
                ((AdminUser) user).manageSystem(); 
            
            } else if (user.getRole().equals("Regular User")) {
                ((RegularUser) user).browseContent(); 
            }

            user.logout();
        }
    }
}
