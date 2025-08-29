package com.school;

import java.util.ArrayList;
import java.util.List;

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

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getStudentId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getStudentId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getStudentId(), courses[2].getCourseId(), "Late")); // invalid
        attendanceLog.add(new AttendanceRecord(students[3].getStudentId(), courses[0].getCourseId(), "Present"));

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
