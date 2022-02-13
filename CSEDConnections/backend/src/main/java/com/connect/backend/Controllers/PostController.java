package com.connect.backend.Controllers;

import java.util.List;

import com.connect.backend.DatabaseLayer.Database;

public class PostController {
    public void createPost(String email, String name, String post){
        Database db = new Database();
        db.createPost(email,name,post);
    }

    public List<post> getPosts(){
        Database db = new Database();
        return db.getPosts();
    }

}
