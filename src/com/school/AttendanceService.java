package com.school;

import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    private List<AttendanceRecord> attendanceLog;
    private FileStorageService storageService;

    public AttendanceService(FileStorageService storageService) {
        this.storageService = storageService;
        this.attendanceLog = new ArrayList<>();
    }

    public void markAttendance(Student student, Course course, String status) {
        AttendanceRecord record = new AttendanceRecord(student, course, status);
        attendanceLog.add(record);
    }

    public void markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses) {
        Student s = findStudentById(studentId, allStudents);
        Course c = findCourseById(courseId, allCourses);
        if (s == null || c == null) {
            System.out.println("Could not find student or course for IDs: " + studentId + ", " + courseId);
            return;
        }
        markAttendance(s, c, status);
    }

    private Student findStudentById(int id, List<Student> allStudents) {
        if (allStudents == null) return null;
        for (Student s : allStudents) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourseById(int id, List<Course> allCourses) {
        if (allCourses == null) return null;
        for (Course c : allCourses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public void displayAttendanceLog() {
        if (attendanceLog.isEmpty()) {
            System.out.println("No attendance records.");
            return;
        }
        for (AttendanceRecord r : attendanceLog) {
            r.displayRecord();
        }
    }

    public void displayAttendanceLog(Student student) {
        for (AttendanceRecord r : attendanceLog) {
            if (r.getStudent() != null && student != null && r.getStudent().getId() == student.getId()) {
                r.displayRecord();
            }
        }
    }

    public void displayAttendanceLog(Course course) {
        for (AttendanceRecord r : attendanceLog) {
            if (r.getCourse() != null && course != null && r.getCourse().getCourseId() == course.getCourseId()) {
                r.displayRecord();
            }
        }
    }

    public void saveAttendanceData() {
        storageService.saveData(attendanceLog, "attendance_log.txt");
    }

    public List<AttendanceRecord> getAttendanceLog() {
        return attendanceLog;
    }
}
