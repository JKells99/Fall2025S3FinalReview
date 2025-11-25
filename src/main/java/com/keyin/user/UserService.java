package com.keyin.user;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {
    // Dependency
    UserDao userDao = new UserDao();

    public void saveNewUser(User user) {
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(8));
        user.setPassword(hashedPassword);
        System.out.println("Saved new user to system");
        userDao.saveNewUserToDb(user);
    }

    public User getUserByUserName(String userName) throws SQLException {
        System.out.println("Getting user by username");
        return userDao.getByUserName(userName);
    }



}
