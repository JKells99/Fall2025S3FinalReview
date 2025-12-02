package com.keyin.course;

import java.sql.SQLException;

public class CourseService {

    CourseDAO courseDao = new CourseDAO();
    public void saveNewCourse(Course course) {
        System.out.println("Saving new course: " + course.getCourseName());
        courseDao.saveNewCourseToDb(course);
    }

    public void getStudentInCourseByCourseName(String courseName) throws SQLException {
        System.out.println("Getting student in course by course name");
        courseDao.getListOfStudentsForCourseByName(courseName);
    }

    public void printAllCourses() throws SQLException {
        courseDao.printAllCourses();
    }
}
