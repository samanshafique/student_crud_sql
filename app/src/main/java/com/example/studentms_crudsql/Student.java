package com.example.studentms_crudsql;

public class Student {
    private String name;
    private String email;
    private String username;
    private String password;

    public Student(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
//
//
//package com.example.crud_app;
//
//public class Student {
//    private int id;
//    private String studentName;
//    Student() {
//    }
//    Student(int id, String studentName) {
//        this.id = id;
//        this.studentName = studentName;
//    }
//    void setID(int id) {
//        this.id = id;
//    }
//    int getID() {
//        return this.id;
//    }
//    void setStudentName(String studentname) {
//        this.studentName = studentname;
//    }
//    String getStudentName() {
//        return this.studentName;
//    }
//}