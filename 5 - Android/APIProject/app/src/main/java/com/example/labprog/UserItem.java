package com.example.labprog;

public class UserItem {

    protected String name, email;
    protected String imgUrl;

    public UserItem(String name, String email, String imgUrl) {
        this.name = name;
        this.email = email;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImgUrl() { return imgUrl; }
}
