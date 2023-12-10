package com.telran.tinder.service;

import com.telran.tinder.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class TopRatingUserService implements UserService {

    @Override
    public User getNewUser() {
        List<User> users = new ArrayList<>();

        User firstUser = new User(1, "Petr", 100, "Just Petr");
        User secondUser = new User(2, "Anna", 150, "I like puppies");
        User thirdUser = new User(3, "Pavel", 200, "I hate puppies");

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

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
}
