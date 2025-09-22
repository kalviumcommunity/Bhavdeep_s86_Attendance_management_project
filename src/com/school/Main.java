package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Students
        Student[] students = {
            new Student("Alice", "Grade 10"),
            new Student("Bob", "Grade 11"),
            new Student("Charlie", "Grade 12"),
            new Student("David", "Grade 10"),
            new Student("Eva", "Grade 11")
        };

        // Create Teachers
        Teacher[] teachers = {
            new Teacher("Mr. Smith", "Mathematics"),
            new Teacher("Ms. Johnson", "Physics")
        };

        // Create Staff
        Staff[] staffMembers = {
            new Staff("Mrs. Brown", "Administrator"),
            new Staff("Mr. Green", "Janitor")
        };

        // Create Courses
        Course[] courses = {
            new Course("Mathematics"),
            new Course("Physics"),
            new Course("Chemistry"),
            new Course("Biology")
        };

        System.out.println("Student Details:");
        for (Student s : students) {
            s.displayDetails();
        }

        System.out.println("\nTeacher Details:");
        for (Teacher t : teachers) {
            t.displayDetails();
        }

        System.out.println("\nStaff Details:");
        for (Staff st : staffMembers) {
            st.displayDetails();
        }

        System.out.println("\nCourse Details:");
        for (Course c : courses) {
            c.display();
        }

        // Attendance Records
        List<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students[0].getId(), courses[0].getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students[1].getId(), courses[1].getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students[2].getId(), courses[2].getCourseId(), "Late")); // invalid
        attendanceLog.add(new AttendanceRecord(students[3].getId(), courses[0].getCourseId(), "Present"));

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }
    }
}
