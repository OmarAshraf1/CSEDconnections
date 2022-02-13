package com.connect.backend.Controllers;

import java.util.ArrayList;

public class Graduate extends Person {
    public String graduationYear;
    public ArrayList<Experience> experience;

    public Graduate() {
        experience = new ArrayList<>();
    }

    public String toString(){
        System.out.println("experience : "+experience.toString());
        return super.toString()+" "+graduationYear+" "+experience.toString();
    }
    public Graduate(String name, String gender, String phone, String about, String age, String mail,
            String password, String img, String graduationYear) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.about = about;
        this.age = age;
        this.mail = mail;
        this.password = password;
        this.img = img;
        this.graduationYear = graduationYear;
        experience = new ArrayList<>();
    }

    public String getGraduationYear() {
        return this.graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public ArrayList<Experience> getExperience() {
        return this.experience;
    }

    public void addExperience(Experience experienceEntity) {
        this.experience.add(experienceEntity);
    }

}
