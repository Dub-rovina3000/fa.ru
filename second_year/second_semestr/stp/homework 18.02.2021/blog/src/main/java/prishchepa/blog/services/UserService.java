package prishchepa.blog.services;

import prishchepa.blog.entity.User;
import prishchepa.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void createUser(User user) {
        userRepo.save(user);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public boolean updateUser(User user, Long id) {
        if (getUserById(id) != null) {
            user.setId(id);
            userRepo.save(user);
            return true;
        }

        return false;
    }

    public boolean deleteUser(Long id) {
        if (getUserById(id) != null) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}