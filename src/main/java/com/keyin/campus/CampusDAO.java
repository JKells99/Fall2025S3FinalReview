package com.keyin.campus;

import com.keyin.database.DBConnection;
import com.keyin.logger.Logger;
import com.keyin.user.User;

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

    public void getAllCampuses() throws SQLException {
        String sql = "SELECT * FROM campus";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Campus campus = new Campus();
               campus.setCampusId(resultSet.getInt("campusid"));
               campus.setCampusName(resultSet.getString("campusname"));
               campus.setAddress(resultSet.getString("address"));
               campus.setPhone(resultSet.getString("phone"));
                System.out.println("========================");
                System.out.println("Campus Name: " + campus.getCampusName());
                System.out.println("Campus Address: " + campus.getAddress());
                System.out.println("Campus Phone: " + campus.getPhone());
                System.out.println("========================");

            }
        }

    }

    public void deleteCampusById(int id){
        String sql = "DELETE FROM campus WHERE campusid = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Campus deleted successfully" + " with id: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.errorLog(e.getMessage());
        }
    }

    public void updateCampus(int id, String campusName, String address, String phone) {
        String sql = "UPDATE campus SET campusname = ?, address = ?, phone = ? WHERE campusid = ?";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, campusName);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, phone);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
            System.out.println("Campus updated successfully" + " with id: " + id);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.errorLog(e.getMessage());
        }
    }
}
