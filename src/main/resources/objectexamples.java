        Admin admin = new Admin("admin3", "admin", "admin2@admin.com",1,"0123456789", 10000, true);
        userService.saveNewUser(admin);

        Admin admin2 = new Admin("admin4", "admin2", "Admin4@admin.com",2,"0123456789", 10000, true);
        userService.saveNewUser(admin2);

        Student student = new Student("student3", "student", "student@school.com","123-123123","Comp Sci",1,2);
        userService.saveNewUser(student);