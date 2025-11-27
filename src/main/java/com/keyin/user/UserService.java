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

    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
    public User logInToSystem(String userName, String password) throws SQLException {
        User user = getUserByUserName(userName);
        if(verifyPassword(password, user.getPassword())){
            System.out.println("Login Successful");
            return user;

        }else{
            System.out.println("Login Failed");
            return null;
        }
    }

    public void getNumberOfStudentsForCampusByCampusId(int campusId) throws SQLException {
        userDao.getNumberOfStudentsForCampusByCampusId(campusId);
    }

    public void getNumberOfStudentsForEachCampus() throws SQLException {
        userDao.getNumberOfStudentsForEachCampus();
    }



}
