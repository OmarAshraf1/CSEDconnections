package com.connect.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.List;

import com.connect.backend.Controllers.Data;
import com.connect.backend.Controllers.PostController;
import com.connect.backend.Controllers.Search;
import com.connect.backend.Controllers.post;

import org.junit.jupiter.api.Test;

public class Posts {
    @Test
    void testCreatePost() {
        PostController controller = new PostController();
        int prevSize = controller.getPosts().size();
        controller.createPost("elmeniawy@gmail.com", "Abdelrahman Elmeniawy", "Hey I am writing a post");
        int currentSize = controller.getPosts().size();
        assertEquals(prevSize + 1, currentSize);
    }

    @Test
    void testgetPosts() {
        PostController controller = new PostController();
        List<post> expected = controller.getPosts();
        Data data = new Data('G');
        List<post> actual = data.getPosts();
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void testSearchNameFound() {
        PostController controller = new PostController();
        List<post> posts = controller.getPosts();
        Search search = new Search();
        int size = search.searchPosts(posts, "Abdelrahman").size();
        assertTrue(size > 0);
    }

    @Test
    void testSearchContentFound() {
        PostController controller = new PostController();
        List<post> posts = controller.getPosts();
        Search search = new Search();
        int size = search.searchPosts(posts, "Hey").size();
        assertTrue(size > 0);
    }

    @Test
    void testShearchNotFound() {
        PostController controller = new PostController();
        List<post> posts = controller.getPosts();
        Search search = new Search();
        int size = search.searchPosts(posts, "NotFOUND").size();
        assertTrue(size == 0);
    }

}
