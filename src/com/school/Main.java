package com.school;

public class Main {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 101),
            new Student("Bob", 102),
            new Student("Charlie", 103)
        };

        Course[] courses = {
            new Course("Mathematics", "MTH101"),
            new Course("Physics", "PHY101")
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
