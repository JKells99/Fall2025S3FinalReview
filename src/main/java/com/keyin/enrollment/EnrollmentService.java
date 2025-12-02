package com.keyin.enrollment;

import com.keyin.logger.Logger;

public class EnrollmentService {

    // Dependency injection
    EnrollmentDAO enrollmentDao = new EnrollmentDAO();

    public void addNewEnrollment(Enrollment enrollment) {
        System.out.println("Enrolling student ID " + enrollment.getStudentId() + " in course ID " + enrollment.getCourseId());
        Logger.infoLog("Enrolling student ID " + enrollment.getStudentId() + " in course ID " + enrollment.getCourseId());
        enrollmentDao.enrollStudentInCourse(enrollment);
    }

}
