package org.szpinc.study.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.szpinc.study.security.entity.User;
import org.szpinc.study.security.repository.UserRepository;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2019年04月17日 22:23:00
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        if (user.getId() == null) {
            return;
        }
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}