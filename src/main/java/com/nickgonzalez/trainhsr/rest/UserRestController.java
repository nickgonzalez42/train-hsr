package com.nickgonzalez.trainhsr.rest;

import com.nickgonzalez.trainhsr.entity.User;
import com.nickgonzalez.trainhsr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    private UserService userService;
    @Autowired
    public UserRestController(UserService theUserService) {
        userService = theUserService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User newUser = userService.save(user);
        return newUser;
//        return "WORKED";
    }
}
