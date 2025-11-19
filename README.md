# Attendance Management Project

This is a Java-based project developed as part of Kalvium's Object Oriented Programming course (SPE 2025). The goal of this project is to build an attendance system using OOP principles.

## Getting Started

To run this project:

1. Compile the code: `javac src\com\school\Main.java`
2. Run the code: `java -cp src com.school.Main`


## Part 2 - Core Domain Modelling

- Added `Student` and `Course` classes with constructors and display methods.
- Created arrays of students and courses.
- Printed their details using `Main.java`.


## Part 3: Constructor Initialization & Auto-ID Generation
- Implemented parameterized constructors in `Student` and `Course` classes for object initialization.
- Utilized `private static` member variables for automatic and unique ID generation.
- Demonstrated the use of the `this` keyword to distinguish instance variables from constructor parameters.
- Changed `Course`'s `courseId` to `int` for simpler auto-generation and updated its display.
- Updated `Main.java` to use constructors and show ID progression.

### How to Run (ensure this is up-to-date)
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/Student.java src/com/school/Course.java src/com/school/Main.java` (or `javac src/com/school/*.java`)
3. Run: `java -cp src com.school.Main`

## Part 4: Data Encapsulation & Attendance Recording Validation
- Applied encapsulation to `Student` and `Course` classes by making fields `private` and adding public `getters`.
- Introduced a new `AttendanceRecord` class with `private` fields, a constructor, and `getters` to store attendance data.
- Implemented basic validation in the `AttendanceRecord` constructor for the attendance status (allowing only "Present" or "Absent").
- Used an `ArrayList` in `Main.java` to store and display `AttendanceRecord` objects.
- Demonstrated retrieving IDs using getters (e.g., `student1.getStudentId()`) when creating records.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java` (or list individual files including `AttendanceRecord.java`)
3. Run: `java -cp src com.school.Main`

## Part 5: Establishing Students, Teaching & Non-Teaching Staff hierarchy
- Created a base class `Person.java` with common attributes (`id`, `name`), a universal auto-ID generator, and a `displayDetails()` method.
- Modified `Student.java` to inherit from `Person`, using `super()` to call the parent constructor and overriding `displayDetails()` to add student-specific info (e.g., grade level).
- Created `Teacher.java` extending `Person`, adding a `subjectTaught` attribute and its own `displayDetails()`.
- Created `Staff.java` extending `Person`, adding a `role` attribute and its own `displayDetails()`.
- Demonstrated creation and display of `Student`, `Teacher`, and `Staff` objects in `Main.java`.
- Updated `AttendanceRecord` creation to use the inherited `getId()` method.

## Part 6: Interface-Driven Persistence with Storage
- Defined a `Storable` interface with a `toDataString()` method.
- Modified `Student`, `Course`, and `AttendanceRecord` classes to implement the `Storable` interface and provide their specific `toDataString()` implementations (CSV format).
- Created a `FileStorageService` class with a `saveData(List<? extends Storable> items, String filename)` method to write `Storable` objects to a text file.
- Utilized `try-with-resources` for safe file handling (`PrintWriter`, `FileWriter`).
- Demonstrated in `Main.java` how to save lists of students, courses, and attendance records to separate files (`students.txt`, `courses.txt`, `attendance_log.txt`).
- Discussed the flexibility provided by interfaces for handling different types of storable objects uniformly.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check the generated files: `students.txt`, `courses.txt`, `attendance_log.txt`.

## Part 7: Polymorphic Behaviour in Attendance and Displaying Reports
- Modified `AttendanceRecord` to hold `Student` and `Course` objects instead of just their IDs, enhancing its object-oriented nature and how records are displayed. The `toDataString()` method still uses IDs for simpler file storage.
- Created a `displaySchoolDirectory(List<Person> people)` method in `Main.java` to demonstrate polymorphism. This method iterates through a list of `Person` objects (containing `Student`, `Teacher`, `Staff` instances) and calls `person.displayDetails()`. The correct overridden method for each specific object type is executed at runtime.
- Populated a `List<Person>` in `main` and used it with `displaySchoolDirectory`.
- Updated `Main.java` to use `instanceof` and casting when preparing the list of students for saving, as `Person` itself does not implement `Storable`.
- Discussed how polymorphism allows for flexible and extensible code by treating different object types uniformly through a common interface or base class reference.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`

## Part 8: Overloaded Commands: Multiple Ways to Mark and Query Attendance
- Created an `AttendanceService.java` class to encapsulate attendance logic and manage the list of `AttendanceRecord` objects.
- Implemented overloaded `markAttendance` methods in `AttendanceService`:
    - `markAttendance(Student student, Course course, String status)`
    - `markAttendance(int studentId, int courseId, String status, List<Student> allStudents, List<Course> allCourses)` (performs lookups)
- Implemented overloaded `displayAttendanceLog` methods in `AttendanceService`:
    - `displayAttendanceLog()` (shows all records)
    - `displayAttendanceLog(Student student)` (filters by student)
    - `displayAttendanceLog(Course course)` (filters by course)
- Utilized Java Streams for filtering records in the specific display methods.
- `AttendanceService` now uses `FileStorageService` to save its `attendanceLog`.
- Demonstrated the use of these overloaded methods in `Main.java`, showing how different method signatures allow for flexible ways to call the same conceptual operation.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `attendance_log.txt` for saved records.

## Part 9: RegistrationService, Dependency Injection, and Enhanced File Persistence
- Modified `Teacher.java` and `Staff.java` to implement the `Storable` interface with their respective `toDataString()` methods, enabling their data to be persisted to files.
- Created a new `RegistrationService.java` class that acts as a centralized registry for managing:
    - Students, Teachers, Staff members, and Courses
    - Methods: `registerStudent()`, `registerTeacher()`, `registerStaff()`, `createCourse()`
    - Lookup methods: `findStudentById()`, `findCourseById()`
    - `getAllPeople()` to retrieve all registered persons (students, teachers, staff)
    - `saveAllRegistrations()` to persist all managed lists to their respective files (`students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`)
- Refactored `AttendanceService.java`:
    - Added dependency on `RegistrationService` through constructor injection
    - Updated `markAttendance(int studentId, int courseId, String status)` to use `RegistrationService` for lookups instead of requiring list parameters
    - Removed private helper methods for student/course lookup (now handled by `RegistrationService`)
- Refactored `Main.java`:
    - Implemented proper dependency injection: `FileStorageService` → `RegistrationService` → `AttendanceService`
    - Used `RegistrationService` methods to register all students, teachers, staff, and courses
    - Updated `displaySchoolDirectory()` to accept `RegistrationService` and call `getAllPeople()`
    - Simplified attendance marking by using the ID-based method that leverages `RegistrationService`
    - Calls `registrationService.saveAllRegistrations()` and `attendanceService.saveAttendanceData()` to persist all data
- Demonstrated separation of concerns, dependency injection, and centralized management of school entities.
- Successfully generates `teachers.txt` and `staff.txt` files along with existing data files.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java com.school.Main`
4. Verify generated files: `students.txt`, `teachers.txt`, `staff.txt`, `courses.txt`, `attendance_log.txt`


## Part 10: Capacity Management & SOLID Principles Reflection
- Added a `capacity` feature to the `Course` class, along with an internal list of `enrolledStudents`.
- Updated `Course.displayDetails()` to show capacity and enrollment count, and `Course.toDataString()` to save capacity.
- Modified `RegistrationService`:
    - `createCourse` method now accepts a capacity parameter.
    - Added `enrollStudentInCourse(Student student, Course course)` method to handle enrollment logic, checking against course capacity.
- Updated `Main.java` to demonstrate course creation with capacity, student enrollment attempts (including exceeding capacity), and displaying updated course information.
- Discussed how other SOLID principles (like Open-Closed and Dependency Inversion) could be applied for further enhancements and flexibility.
- Concluded the 10-part project, having built a foundational console-based attendance system.

### How to Run
1. Navigate to the project root directory.
2. Compile: `javac src/com/school/*.java`
3. Run: `java -cp src com.school.Main`
4. Check `courses.txt` for the capacity field and other files for their respective data.