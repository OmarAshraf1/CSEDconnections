package com.connect.backend.Controllers;

import java.util.List;

import com.connect.backend.DatabaseLayer.Database;

public class Data {
    private Database database;
    private char type;

    public Data(char t) {
        database = new Database(t);
    }

    public boolean checkSignIn(String email, String password) {
        return database.signIn(email, password);
    }

    public boolean existsBefore(String email) {
        return database.existsBefore(email);
    }

    public boolean createnewGrad(Graduate newGrad) {
        return database.signUp(newGrad);
    }

    public boolean createnewStudent(Student newStudent) {
        return database.signUp(newStudent);
    }

    public List<Graduate> startdisplay() {
        return database.getGraduates();
    }

    public Graduate opengraduate(String email) {
        System.out.println(email);
        return database.opengraduateDB(email);
    }

    public void createPost(String email, String name, String post){
        Database db = new Database();
        db.createPost(email,name,post);
    }

    public List<post> getPosts(){
        Database db = new Database();
        return db.getPosts();
    }
}
