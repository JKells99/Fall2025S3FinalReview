CREATE TABLE users (
   user_id         serial PRIMARY KEY,
   userName       varchar(100) NOT NULL,
   password        varchar(60) NOT NULL, -- bcrypt hashes are 60 chars
    email           varchar(100) NOT NULL,
   phone           varchar(15) NOT NULL,
   role            varchar(50) NOT NULL DEFAULT 'student',

);
