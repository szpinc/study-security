package org.szpinc.study.security.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.szpinc.study.security.annotation.Json;
import org.szpinc.study.security.entity.User;
import org.szpinc.study.security.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;


@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @Json(type = User.class, filter = "password")
    public List<User> getUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/user/add")
    public void addUser(@RequestParam("username") @NotNull String username, @NotNull @RequestParam("password") String password) {
        userService.addUser(new User(username, password));
    }
}
