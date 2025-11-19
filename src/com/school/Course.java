package com.school;

import java.util.ArrayList;
import java.util.List;

public class Course implements Storable {
    private static int nextCourseIdCounter = 101; // static counter for auto-ID
    private int courseId;
    private String courseName;
    private int capacity;
    private List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, int capacity) {
        this.courseId = nextCourseIdCounter++;
        this.courseName = courseName;
        this.capacity = capacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public int getNumberOfEnrolledStudents() {
        return enrolledStudents.size();
    }

    // Add student to course
    public boolean addStudent(Student student) {
        if (capacity > enrolledStudents.size()) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    // Display method
    public void displayDetails() {
        System.out.println("Course ID: C" + courseId + ", Name: " + courseName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current number of enrolled students: " + enrolledStudents.size());
    }

    // Legacy display method for backwards compatibility
    public void display() {
        displayDetails();
    }

    @Override
    public String toDataString() {
        return courseId + "," + courseName + "," + capacity;
    }
}
