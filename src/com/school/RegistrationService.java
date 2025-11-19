package com.school;

import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;
    private List<Course> courses;
    private FileStorageService storageService;

    public RegistrationService(FileStorageService storageService) {
        this.storageService = storageService;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Registration methods
    public void registerStudent(String name, String gradeLevel) {
        Student student = new Student(name, gradeLevel);
        students.add(student);
    }

    public void registerTeacher(String name, String subjectTaught) {
        Teacher teacher = new Teacher(name, subjectTaught);
        teachers.add(teacher);
    }

    public void registerStaff(String name, String role) {
        Staff staff = new Staff(name, role);
        staffMembers.add(staff);
    }

    public void createCourse(String courseName, int capacity) {
        Course course = new Course(courseName, capacity);
        courses.add(course);
    }

    // Enrollment method
    public boolean enrollStudentInCourse(Student student, Course course) {
        boolean success = course.addStudent(student);
        if (success) {
            System.out.println("Successfully enrolled " + student.getName() + " in " + course.getCourseName());
        } else {
            System.out.println("Failed to enroll " + student.getName() + " in " + course.getCourseName() + " - Course is full!");
        }
        return success;
    }

    // Getters for lists
    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // Lookup methods
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public Course findCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) {
                return c;
            }
        }
        return null;
    }

    // Get all people
    public List<Person> getAllPeople() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(students);
        allPeople.addAll(teachers);
        allPeople.addAll(staffMembers);
        return allPeople;
    }

    // Save all registrations to files
    public void saveAllRegistrations() {
        storageService.saveData(students, "students.txt");
        storageService.saveData(teachers, "teachers.txt");
        storageService.saveData(staffMembers, "staff.txt");
        storageService.saveData(courses, "courses.txt");
    }
}
