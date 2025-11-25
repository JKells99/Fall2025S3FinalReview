package com.keyin.user;

import com.keyin.database.DBConnection;

import java.sql.SQLException;

public class UserDao {

    public void saveNewUserToDb(User user) {
        String sql = "INSERT INTO users(username, password, email, phone, role) VALUES (?,?,?,?,?)";

        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getRole());
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


}

