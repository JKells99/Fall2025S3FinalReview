package com.keyin.campus;

import java.sql.SQLException;

public class CampusService {

    CampusDAO campusDao = new CampusDAO();

    public void saveNewCampus(Campus campus) {
        System.out.println("Saving new campus to system!" + campus.getCampusName());
        campusDao.saveNewCampusToDb(campus);
    }

    public void getAllCampuses() throws SQLException {
        campusDao.getAllCampus();
    }
    public void deleteCampusById(int campusId) throws SQLException {
        System.out.println("Deleting campus with id: " + campusId);
        campusDao.deleteCampusById(campusId);
    }
    public Campus getCampusById(int campusId) throws SQLException {
        return campusDao.getCampusById(campusId);
    }

    public void getNumberOfStudentsInCampus(int campusId) throws SQLException {
        campusDao.getNumberOfStudentsInCampus(campusId);
    }

    public void getNumberOfSchoolCampusesInSystem() throws SQLException {
        campusDao.getNumberOfCampuses();

    }
}
