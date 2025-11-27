package com.keyin.user;

import com.keyin.database.DBConnection;

import java.sql.SQLException;

public class UserDao {

    public void saveNewUserToDb(User user) {
        String sql = "INSERT INTO users(username, password, email, phone, role,campus_id) VALUES (?,?,?,?,?,?)";

        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setInt(6, user.getCampusId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public User getByUserName(String userName) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, userName);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole(resultSet.getString("role"));
                return user;
            }
        }
        return null;
    }


// Admin Report Method
    public void getNumberOfStudentsForCampusByCampusId(int campusId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE campus_id = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, campusId);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Number of students in campus: " + resultSet.getInt(1));
            }
        }
    }

    // Admin Report Method
    public void getNumberOfStudentsForEachCampus() throws SQLException {
        String sql = "SELECT campus_id, COUNT(*) FROM users GROUP BY campus_id";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Campus ID: " + resultSet.getInt(1) + " Number of students: " + resultSet.getInt(2));
            }
        }
    }


}

