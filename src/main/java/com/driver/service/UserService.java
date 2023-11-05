package com.driver.service;

import com.driver.model.User;
import com.driver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepo = new UserRepository();

    public void addUserById(User u) {
        userRepo.addUserById(u);
    }
}
