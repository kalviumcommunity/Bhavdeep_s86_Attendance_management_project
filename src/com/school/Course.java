package com.school;

public class Course {
    private String courseName;
    private String courseCode;

    public Course(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public void display() {
        System.out.println("Course Code: " + courseCode + ", Name: " + courseName);
    }
}
