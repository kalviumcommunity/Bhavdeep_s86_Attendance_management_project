package com.school;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void displaySchoolDirectory(List<Person> people) {
        for (Person person : people) {
            person.displayDetails();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create and populate ArrayLists
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student("Alice", "Grade 10");
        Student s2 = new Student("Bob", "Grade 11");
        Student s3 = new Student("Charlie", "Grade 12");
        Student s4 = new Student("David", "Grade 10");
        Student s5 = new Student("Eva", "Grade 11");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);

        ArrayList<Course> courses = new ArrayList<>();
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("Chemistry");
        Course c4 = new Course("Biology");
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);

        ArrayList<AttendanceRecord> attendanceLog = new ArrayList<>();
        attendanceLog.add(new AttendanceRecord(s1, c1, "Present"));
        attendanceLog.add(new AttendanceRecord(s2, c2, "Absent"));
        attendanceLog.add(new AttendanceRecord(s3, c3, "Late")); // invalid, will be set to 'Invalid'
        attendanceLog.add(new AttendanceRecord(s4, c1, "Present"));

        // Teachers and Staff
        Teacher tA = new Teacher("Mr. Smith", "Mathematics");
        Teacher tB = new Teacher("Ms. Johnson", "Physics");
        Staff stA = new Staff("Mrs. Brown", "Administrator");
        Staff stB = new Staff("Mr. Green", "Janitor");

        // Build a school directory list of Person
        ArrayList<Person> schoolPeople = new ArrayList<>();
        // Add students
        schoolPeople.add(s1);
        schoolPeople.add(s2);
        schoolPeople.add(s3);
        schoolPeople.add(s4);
        schoolPeople.add(s5);
        // Add teachers
        schoolPeople.add(tA);
        schoolPeople.add(tB);
        // Add staff
        schoolPeople.add(stA);
        schoolPeople.add(stB);

        System.out.println("School Directory:\n");
        displaySchoolDirectory(schoolPeople);

        System.out.println("Course Details:");
        for (Course c : courses) {
            c.display();
        }

        System.out.println("\nAttendance Records:");
        for (AttendanceRecord record : attendanceLog) {
            record.displayRecord();
        }

        // Save data to files
        FileStorageService storage = new FileStorageService();

        // If saving students from a mixed Person list, filter for Student instances
        List<Student> studentsToSave = new ArrayList<>();
        for (Person p : schoolPeople) {
            if (p instanceof Student) {
                studentsToSave.add((Student) p);
            }
        }

        storage.saveData(studentsToSave, "students.txt");
        storage.saveData(courses, "courses.txt");
        storage.saveData(attendanceLog, "attendance_log.txt");
    }
}
