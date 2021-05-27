package prishchepa.blog.controller;

import prishchepa.blog.entity.Tag;
import prishchepa.blog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> getTags() {
        List<Tag> body = tagService.getTags();

        if (body != null && !body.isEmpty()) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tags/{id}")
    public ResponseEntity<Tag> getById(@PathVariable(name = "id") Long id) {
        Tag body = tagService.getTagById(id);

        if (body != null) {
            return new ResponseEntity<>(body, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/tags")
    public void create(@RequestBody Tag tag) {
        tagService.createTag(tag);
    }

    @PutMapping("/tags/{id}")
    public ResponseEntity<?> update(@RequestBody Tag tag, @PathVariable(name = "id") Long id) {
        if (tagService.updateTag(tag, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tags/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        if (tagService.deleteTag(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
