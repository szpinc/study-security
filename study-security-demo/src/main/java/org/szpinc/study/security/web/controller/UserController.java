package org.szpinc.study.security.web.controller;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.szpinc.study.security.dto.User;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class UserController {

    @JsonView(User.UserSimpleView.class)
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers () {
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @JsonView(User.UserDetailView.class)
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser (@PathVariable("id")Integer id) {
        User user = new User();
        user.setId(1);
        user.setUsername("szpinc");
        user.setPassword("123456");

        return user;
    }

}
