package prishchepa.blog.controller;

import prishchepa.blog.entity.Comment;
import prishchepa.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        List<Comment> body = commentService.getComments();

        if (body != null && !body.isEmpty()) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(name = "id") Long id) {
        Comment body = commentService.getCommentById(id);

        if (body != null) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/comments")
    public void createComment(@RequestBody Comment comment) {
        commentService.createComment(comment);
    }

    @PutMapping("/comments/{id}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment, @PathVariable(name = "id") Long id) {
        if (commentService.updateComment(comment, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable(name = "id") Long id) {
        if (commentService.deleteComment(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}