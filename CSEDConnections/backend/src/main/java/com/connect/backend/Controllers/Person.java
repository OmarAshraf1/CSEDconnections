package com.connect.backend.Controllers;

public class Person {
    public String name, gender, phone, about, age;
    public String mail, password;
    public String img;
    public String toString(){
        return name+" "+about;
    }
}
