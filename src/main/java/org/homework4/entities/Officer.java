package org.homework4.entities;

public class Officer {

    private int id;
    private String username;

    private String password1;

    private int password2;

    public Officer() {
    }

    public Officer(int id, String username, String password1, int password2) {
        this.id = id;
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public int getPassword2() {
        return password2;
    }

    public void setPassword2(int password2) {
        this.password2 = password2;
    }
}
