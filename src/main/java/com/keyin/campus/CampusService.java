package com.keyin.campus;

public class CampusService {

    CampusDAO campusDao = new CampusDAO();

    public void saveNewCampus(Campus campus) {
        System.out.println("Saving new campus to database..." + campus.getCampusName());
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
