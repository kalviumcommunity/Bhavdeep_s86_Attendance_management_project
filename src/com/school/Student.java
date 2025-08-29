package com.school;

public class Student {
    private static int nextStudentIdCounter = 1; // static counter for auto-ID
    private int studentId;
    private String name;

    // Constructor
    public Student(String name) {
        this.studentId = nextStudentIdCounter++;
        this.name = name;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    // Display method
    public void display() {
        System.out.println("Student ID: S" + studentId + ", Name: " + name);
    }
}
