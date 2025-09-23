package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create and populate ArrayLists
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Grade 10"));
        students.add(new Student("Bob", "Grade 11"));
        students.add(new Student("Charlie", "Grade 12"));
        students.add(new Student("David", "Grade 10"));
        students.add(new Student("Eva", "Grade 11"));

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));
        courses.add(new Course("Biology"));

        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(students.get(0).getId(), courses.get(0).getCourseId(), "Present"));
        attendanceLog.add(new AttendanceRecord(students.get(1).getId(), courses.get(1).getCourseId(), "Absent"));
        attendanceLog.add(new AttendanceRecord(students.get(2).getId(), courses.get(2).getCourseId(), "Late")); // invalid
        attendanceLog.add(new AttendanceRecord(students.get(3).getId(), courses.get(0).getCourseId(), "Present"));

        // Teachers and Staff (unchanged)
        Teacher[] teachers = {
            new Teacher("Mr. Smith", "Mathematics"),
            new Teacher("Ms. Johnson", "Physics")
        };
        Staff[] staffMembers = {
            new Staff("Mrs. Brown", "Administrator"),
            new Staff("Mr. Green", "Janitor")
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

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Save data to files
        FileStorageService storage = new FileStorageService();
        storage.saveData(students, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}
