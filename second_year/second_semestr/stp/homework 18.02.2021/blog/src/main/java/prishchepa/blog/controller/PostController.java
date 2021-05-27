package prishchepa.blog.controller;

import prishchepa.blog.entity.Post;
import prishchepa.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> body = postService.getPosts();

        if (body != null && !body.isEmpty()) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(name = "id") Long id) {
        Post body = postService.getPostById(id);

        if (body != null) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/posts")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<?> updatePost(@RequestBody Post post, @PathVariable(name = "id") Long id) {
        if (postService.updatePost(post, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id) {
        if (postService.deletePost(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}