package com.keyin.user;

import java.sql.SQLException;

public class UserService {
    // Dependency
    UserDao userDao = new UserDao();

    public void saveNewUser(User user) {
        System.out.println("Saved new user to system");
        userDao.saveNewUserToDb(user);
    }

    public User getUserByUserName(String userName) throws SQLException {
        System.out.println("Getting user by username");
        return userDao.getByUserName(userName);
    }



}
