package prishchepa.blog.services;

import prishchepa.blog.entity.Post;
import prishchepa.blog.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public void createPost(Post post) {
        postRepo.save(post);
    }

    public Post getPostById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    public boolean updatePost(Post post, Long id) {
        if (getPostById(id) != null) {
            post.setId(id);
            postRepo.save(post);
            return true;
        }

        return false;
    }

    public boolean deletePost(Long id) {
        if (getPostById(id) != null) {
            postRepo.deleteById(id);
            return true;
        }
        return false;
    }
}