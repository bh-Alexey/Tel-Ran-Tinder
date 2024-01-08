package com.telran.tinder.service.impl;

import com.telran.tinder.entity.Photo;
import com.telran.tinder.entity.User;
import com.telran.tinder.repository.PhotoRepository;
import com.telran.tinder.repository.UserRepository;
import com.telran.tinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TopRatingUserService implements UserService {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;

    @Override
    public User getNewUser() {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException();
        }

        int maxRating = 0;
        User bestUser = null;
        for (User user: users) {
            if (user.getRating() > maxRating) {
                maxRating = user.getRating();
                bestUser = user;
            }
        }
         return bestUser;
    }

    @Override
    public List<User> getByName(String name) {
        List<Photo> photos = photoRepository.findAll();
        System.out.println(photos);
        return userRepository.findAutocompleteNext(name);
    }

    @Override
    public List<User> getByRating(int min, int max) {
        return userRepository.findByRatingRange(min, max);
    }

    @Override
    public int getByDescContent(String content) {
        return userRepository.countAllByWordInDescription(content);
    }

    @Override
    public boolean isExistById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers(int pageSize, int pageNum) {
        int paging = 0;
        if (pageNum > 1) {
            paging = pageSize * (pageNum - 1);
        }
        return userRepository.getAllUsers(pageSize, paging);
    }

}
