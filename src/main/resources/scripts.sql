CREATE TABLE users (
                       user_id         serial PRIMARY KEY,
                       userName       varchar(100) NOT NULL,
                       password        varchar(60) NOT NULL, -- bcrypt hashes are 60 chars
                       email           varchar(100) NOT NULL,
                       phone           varchar(15) NOT NULL,
                       role            varchar(50) NOT NULL DEFAULT 'student'
);

CREATE TABLE campus (
                        campusId         serial PRIMARY KEY,
                        campusName       varchar(100) NOT NULL,
                        address         text NOT NULL,
                        phone           varchar(15) NOT NULL
);

-- create a update script for users that adds a campus_id column
ALTER TABLE users ADD COLUMN campus_id INT;
ALTER TABLE users ADD CONSTRAINT fk_campus FOREIGN KEY (campus_id) REFERENCES campus(campusId);


-- Courses table
CREATE TABLE course (
    courseId serial PRIMARY KEY,
    courseName varchar(150) NOT NULL,
    description text,
    credits int NOT NULL DEFAULT 3
);

-- Enrollment table: links a student (a row in users) to a course
CREATE TABLE enrollment (
    enrollmentId serial PRIMARY KEY,
    student_id int NOT NULL,
    course_id int NOT NULL,
    enrolled_at timestamptz DEFAULT NOW(),
    status varchar(50) DEFAULT 'enrolled',
    CONSTRAINT fk_enrollment_student FOREIGN KEY (student_id) REFERENCES users(user_id),
    CONSTRAINT fk_enrollment_course FOREIGN KEY (course_id) REFERENCES course(courseId)
);

SELECT
    u.user_id AS student_id,
    u.username,
    u.email,
    e.enrolled_at,
    c.coursename AS coursename
FROM enrollment e
         JOIN users u ON e.student_id = u.user_id
         JOIN course c ON e.course_id = c.courseid
WHERE c.coursename = 'CS101'
  AND u.role = 'STUDENT';

