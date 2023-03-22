package com.example.blog.test;

public class Member {

    // private 으로 만드는 이유 : 객체 변수에 곧바로 접근하는 것을 막기 위해 --> 그래서 setter, getter 사용(메서드를 통한 접근)
    private int id;
    private String username;
    private String password;
    private String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
