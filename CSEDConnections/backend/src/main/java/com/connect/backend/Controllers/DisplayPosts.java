package com.connect.backend.Controllers;
import java.util.List;

public class DisplayPosts {
    public List<post> Display(String search) {
        Data data = new Data('G');
        List<post> posts = data.getPosts();
        if (search != null && !search.isBlank()) {
            Search sh = new Search();
            posts = sh.searchPosts(posts, search);
        }
        System.out.println("postes :: "+ posts.toString());
        return posts;
    }

}
