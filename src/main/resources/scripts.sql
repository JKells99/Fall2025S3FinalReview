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
