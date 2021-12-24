package com.connect.backend;

import java.util.ArrayList;

public class Graduate extends Person {
    String graduationYear;
    ArrayList<Experience> experience;

    public Graduate(String name, String gender, String phone, String about, String birhtDate, String mail, String password, String img ,String graduationYear ) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.about = about;
        this.birhtDate = birhtDate;
        this.mail = mail;
        this.password = password;
        this.img = img;
        this.graduationYear = graduationYear;
        experience = new ArrayList<Experience>();

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
