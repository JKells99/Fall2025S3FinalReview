package com.keyin.campus;

import com.keyin.logger.Logger;

public class CampusService {

    CampusDAO campusDao = new CampusDAO();

    public void saveNewCampus(Campus campus) {
        Logger.infoLog("Saving new campus: " + campus.getCampusName());
        campusDao.saveNewCampusToDb(campus);
    }

    public void getAllCampuses() throws Exception {
        campusDao.getAllCampuses();
    }

    public void deleteCampus(int campusId) throws Exception {
        campusDao.deleteCampusById(campusId);
    }

    public void updateCampus(int id, String campusName, String address, String phone) {
        campusDao.updateCampus(id, campusName, address, phone);
    }

}
