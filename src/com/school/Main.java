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

        // Create courses using RegistrationService
        registrationService.createCourse("Mathematics");
        registrationService.createCourse("Physics");
        registrationService.createCourse("Chemistry");
        registrationService.createCourse("Biology");

        // Display school directory
        System.out.println("School Directory:\n");
        displaySchoolDirectory(registrationService);

        // Display courses
        System.out.println("Course Details:");
        for (Course c : registrationService.getCourses()) {
            c.display();
        }

        // Get specific students and courses for attendance marking
        List<Student> students = registrationService.getStudents();
        List<Course> courses = registrationService.getCourses();

        // Mark attendance using object-based method
        if (students.size() > 0 && courses.size() > 0) {
            attendanceService.markAttendance(students.get(0), courses.get(0), "Present");
        }
        if (students.size() > 1 && courses.size() > 1) {
            attendanceService.markAttendance(students.get(1), courses.get(1), "Absent");
        }
        if (students.size() > 2 && courses.size() > 2) {
            attendanceService.markAttendance(students.get(2), courses.get(2), "Late");
        }
        if (students.size() > 3 && courses.size() > 0) {
            attendanceService.markAttendance(students.get(3), courses.get(0), "Present");
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
