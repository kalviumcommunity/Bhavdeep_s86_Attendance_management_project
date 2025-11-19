package com.school;

import java.util.List;

public class Main {
    public static void displaySchoolDirectory(RegistrationService regService) {
        List<Person> people = regService.getAllPeople();
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Initialize services with dependency injection
        FileStorageService storage = new FileStorageService();
        RegistrationService registrationService = new RegistrationService(storage);
        AttendanceService attendanceService = new AttendanceService(storage, registrationService);

        // Register students using RegistrationService
        registrationService.registerStudent("Alice", "Grade 10");
        registrationService.registerStudent("Bob", "Grade 11");
        registrationService.registerStudent("Charlie", "Grade 12");
        registrationService.registerStudent("David", "Grade 10");
        registrationService.registerStudent("Eva", "Grade 11");

        // Register teachers using RegistrationService
        registrationService.registerTeacher("Mr. Smith", "Mathematics");
        registrationService.registerTeacher("Ms. Johnson", "Physics");

        // Register staff using RegistrationService
        registrationService.registerStaff("Mrs. Brown", "Administrator");
        registrationService.registerStaff("Mr. Green", "Janitor");

        // Create courses using RegistrationService with capacity
        registrationService.createCourse("Mathematics", 3);
        registrationService.createCourse("Physics", 2);
        registrationService.createCourse("Chemistry", 4);
        registrationService.createCourse("Biology", 2);

        // Display school directory
        System.out.println("School Directory:\n");
        displaySchoolDirectory(registrationService);

        // Display courses
        System.out.println("Course Details:");
        for (Course c : registrationService.getCourses()) {
            c.display();
        }

        // Get specific students and courses for enrollment and attendance marking
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();
        
        System.out.println("\n--- Enrolling Students in Courses ---");
        
        // Enroll students in courses
        if (students.size() > 0 && courses.size() > 0) {
            registrationService.enrollStudentInCourse(students.get(0), courses.get(0)); // Alice in Mathematics
        }
        if (students.size() > 1 && courses.size() > 0) {
            registrationService.enrollStudentInCourse(students.get(1), courses.get(0)); // Bob in Mathematics
        }
        if (students.size() > 2 && courses.size() > 1) {
            registrationService.enrollStudentInCourse(students.get(2), courses.get(1)); // Charlie in Physics
        }
        if (students.size() > 3 && courses.size() > 1) {
            registrationService.enrollStudentInCourse(students.get(3), courses.get(1)); // David in Physics
        }
        if (students.size() > 4 && courses.size() > 0) {
            registrationService.enrollStudentInCourse(students.get(4), courses.get(0)); // Eva in Mathematics
        }
        
        // Attempt to enroll one more student in Mathematics (should fail - exceeds capacity)
        if (students.size() > 2 && courses.size() > 0) {
            registrationService.enrollStudentInCourse(students.get(2), courses.get(0)); // Charlie in Mathematics (should fail)
        }

        // Display updated course details after enrollment
        System.out.println("\n--- Course Details After Enrollment ---");
        for (Course c : registrationService.getCourses()) {
            c.displayDetails();
            System.out.println();
        }

        System.out.println("--- Marking Attendance ---");
        
        // Mark attendance using object-based method (check enrollment first)
        if (students.size() > 0 && courses.size() > 0) {
            if (courses.get(0).getEnrolledStudents().contains(students.get(0))) {
                attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
            }
        }
        if (students.size() > 1 && courses.size() > 1) {
            if (courses.get(1).getEnrolledStudents().contains(students.get(1))) {
                attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
            }
        }
        if (students.size() > 2 && courses.size() > 2) {
            if (courses.get(2).getEnrolledStudents().contains(students.get(2))) {
                attendanceService.markAttendance(students.get(2), courses.get(2), "Late");
            }
        }
        if (students.size() > 3 && courses.size() > 0) {
            if (courses.get(0).getEnrolledStudents().contains(students.get(3))) {
                attendanceService.markAttendance(students.get(3), courses.get(0), "Present");
            }
        }

        // Mark attendance using ID-based method (new version)
        if (students.size() > 0 && courses.size() > 0) {
            attendanceService.markAttendance(students.get(0).getId(), courses.get(0).getCourseId(), "Present");
        }

        System.out.println("\nAll Attendance Records (via attendanceService):");
        attendanceService.displayAttendanceLog();

        if (students.size() > 0) {
            System.out.println("\nAttendance Records for Student: " + students.get(0).getName());
            attendanceService.displayAttendanceLog(students.get(0));
        }

        if (courses.size() > 0) {
            System.out.println("\nAttendance Records for Course: " + courses.get(0).getCourseName());
            attendanceService.displayAttendanceLog(courses.get(0));
        }

        // Save all data using services
        registrationService.saveAllRegistrations();
        attendanceService.saveAttendanceData();

        System.out.println("\nAll data saved successfully!");
    }
}
