package com.telran.tinder.controller;

import com.telran.tinder.ShareRatingDto;
import com.telran.tinder.entity.User;
import com.telran.tinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        return userService.getNewUser();
    }

    @GetMapping(value = "/autocomplete/{name}")
    public List<User> getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }

    @PostMapping(value = "/share")
    public void shareRating(@RequestBody ShareRatingDto shareRatingDto) {
        System.out.println(shareRatingDto);
    }
}

