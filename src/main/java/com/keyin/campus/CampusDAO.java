package com.keyin.campus;

import com.keyin.database.DBConnection;
import com.keyin.user.User;

import java.sql.Connection;
import java.sql.SQLException;

public class CampusDAO {

    public void saveNewCampusToDb(Campus campus) {
        String sql = "INSERT INTO campus(campusname,address,phone) VALUES (?,?,?)";

        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, campus.getCampusName());
            preparedStatement.setString(2, campus.getAddress());
            preparedStatement.setString(3, campus.getPhone());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Campus getCampusById(int campusId) throws SQLException {
        String sql = "SELECT * FROM campus WHERE campus_id = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, campusId);
            var resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Campus campus = new Campus();
                campus.setCampusId(resultSet.getInt("campus_id"));
                campus.setCampusName(resultSet.getString("campusName"));
                campus.setAddress(resultSet.getString("address"));
                campus.setPhone(resultSet.getString("phone"));
                return campus;
            }
        }
        return null;
    }

    public void deleteCampusById(int campusId) throws SQLException {
        String sql = "DELETE FROM campus WHERE campus_id = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, campusId);
            preparedStatement.executeUpdate();
        }
    }

    public void getAllCampus() throws SQLException {
        String sql = "SELECT * FROM campus";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("---------------------------");
                System.out.println(resultSet.getString("campusName"));
                System.out.println(resultSet.getString("address"));
                System.out.println(resultSet.getString("phone"));
                System.out.println("---------------------------");

            }
        }

    }

    public void getNumberOfStudentsInCampus(int campusId) throws SQLException {
     String sql = "SELECT COUNT(*) FROM users WHERE campus_id = ?";
     Connection connection = DBConnection.getConnection();
     var preparedStatement = connection.prepareStatement(sql);
     preparedStatement.setInt(1, campusId);
     var resultSet = preparedStatement.executeQuery();
     resultSet.next();
     System.out.println("There are " + resultSet.getInt(1) + " Students At Campus ID: " + campusId);
     connection.close();
    }

    public void getNumberOfCampuses() throws SQLException {
        String sql = "SELECT COUNT(*) FROM campus";
        Connection connection = DBConnection.getConnection();
        var preparedStatement = connection.prepareStatement(sql);
        var resultSet = preparedStatement.executeQuery();
        resultSet.next();
        System.out.println("There are " + resultSet.getInt(1) + " Campuses");
        connection.close();
    }

}
