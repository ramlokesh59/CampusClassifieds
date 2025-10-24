package model;

public class User {
    private String name;
    private String username;
    private String password;

    public User(String name) {
        this.name = name;
    }

    // Constructor used by RegisterFrame
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }
}
