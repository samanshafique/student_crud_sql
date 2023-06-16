package com.example.studentms_crudsql;

public class Studentcrud {
    private int id;
    private String studentName;
    Studentcrud() {
    }
    Studentcrud(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }
    void setID(int id) {
        this.id = id;
    }
    int getID() {
        return this.id;
    }
    void setStudentName(String studentname) {
        this.studentName = studentname;
    }
    String getStudentName() {
        return this.studentName;
    }
}


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