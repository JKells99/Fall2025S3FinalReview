package com.keyin.enrollment;

//CREATE TABLE enrollment (
//        enrollmentId serial PRIMARY KEY,
//        student_id int NOT NULL,
//        course_id int NOT NULL,
//        enrolled_at timestamptz DEFAULT NOW(),
//status varchar(50) DEFAULT 'enrolled',
//CONSTRAINT fk_enrollment_student FOREIGN KEY (student_id) REFERENCES users(user_id),
//CONSTRAINT fk_enrollment_course FOREIGN KEY (course_id) REFERENCES course(courseId)
//        );

import com.keyin.course.Course;
import com.keyin.database.DBConnection;
import com.keyin.logger.Logger;

public class EnrollmentDAO {

    public void enrollStudentInCourse(Enrollment enrollment) {
        String sql = "INSERT INTO enrollment(student_id,course_id,statuss) VALUES (?,?,?)";
        try (var connection = DBConnection.getConnection();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, enrollment.getStudentId());
            preparedStatement.setInt(2, enrollment.getCourseId());
            preparedStatement.setString(3, enrollment.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error saving Enrollment to database In DAO");
            Logger.errorLog(e.getMessage());
        }
    }


}
