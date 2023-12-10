package com.telran.tinder;

import com.telran.tinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private int count;
    private final UserService userService;

    public UserController(@Autowired @Qualifier(value = "shortNameUserService") UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        System.out.println("Service was run " + count++ + " times");
        return userService.getNewUser();
    }
}
