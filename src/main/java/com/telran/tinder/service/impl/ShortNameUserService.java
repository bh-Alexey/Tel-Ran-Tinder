package com.telran.tinder.service.impl;

import com.telran.tinder.entity.User;
import com.telran.tinder.repository.UserRepository;
import com.telran.tinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShortNameUserService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getNewUser() {
        List<User> users = userRepository.findAll();


        if (users.isEmpty()) {
            throw new RuntimeException();
        }

        int shortName = Byte.MAX_VALUE;
        User bestUser = null;
        for (User user: users) {
            if (user.getName().length() < shortName) {
                shortName = user.getName().length();
                bestUser = user;
            }
        }
        return bestUser;
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public List<User> getByRating(int min, int max) {
        return null;
    }

    @Override
    public int getByDescContent(String content) {
        return 0;
    }

    @Override
    public boolean isExistById(int id) {
        return false;
    }

    @Override
    public List<User> getAllUsers(int pageSize, int pageNum) {
        return null;
    }

}
