package com.driver.repository;

import com.driver.model.User;
import org.springframework.stereotype.Repository;
import java.util.Map;
import java.util.HashMap;

@Repository
public class UserRepository {

    Map<Integer, User> userDB;

    public UserRepository() {
        this.userDB = new HashMap<>();
    }

    public void addUserById(User u) {
        userDB.put(u.getaadharCardNo(), u);
    }
}
