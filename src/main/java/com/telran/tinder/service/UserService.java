package com.telran.tinder.service;

import com.telran.tinder.entity.User;

import java.util.List;

public interface UserService {
    User getNewUser();

    List<User> getByName(String name);

    List<User> getByRating(int min, int max);

    int getByDescContent(String content);

    boolean isExistById(int id);

    List<User> getAllUsers(int pageSize, int pageNum);
}
