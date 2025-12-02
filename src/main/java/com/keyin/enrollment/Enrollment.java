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

public class Enrollment {

    private int enrollmentId;
    private int studentId;
    private int courseId;
    private String status;


    public Enrollment(int enrollmentId, int studentId, int courseId, String status) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public Enrollment(int studentId, int courseId, String status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = status;
    }

    public Enrollment() {
    }


    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
