package com.telran.tinder.service;

import com.telran.tinder.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ShortNameUserService implements UserService {

    @Override
    public User getNewUser() {
        List<User> users = new ArrayList<>();

        User firstUser = new User(1, "Tim", 100, "My friends call me Timon))");
        User secondUser = new User(2, "Vera", 150, "I like mango");
        User thirdUser = new User(3, "Pavel", 200, "I hate winter season");

        users.add(firstUser);
        users.add(secondUser);
        users.add(thirdUser);

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
}
