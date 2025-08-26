package com.school;

public class Course {
    private static int nextCourseIdCounter = 101; // static counter for auto-ID
    private int courseId;
    private String courseName;

    // Constructor
    public Course(String courseName) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
    }

    public void display() {
        System.out.println("Course ID: C" + courseId + ", Name: " + courseName);
    }
}
