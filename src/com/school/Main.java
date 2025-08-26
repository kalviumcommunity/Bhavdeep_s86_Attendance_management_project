package com.school;

public class Main {
    public static void main(String[] args) {
        // Auto-ID generation for Students
        Student[] students = {
            new Student("Alice"),
            new Student("Bob"),
            new Student("Charlie"),
            new Student("David"),
            new Student("Eva")
        };

        // Auto-ID generation for Courses
        Course[] courses = {
            new Course("Mathematics"),
            new Course("Physics"),
            new Course("Chemistry"),
            new Course("Biology")
        };

        System.out.println("Student Details:");
        for (Student s : students) {
            s.display();
        }

        System.out.println("\nCourse Details:");
        for (Course c : courses) {
            c.display();
        }
    }
}
