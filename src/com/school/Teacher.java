package com.school;

public class Teacher extends Person implements Storable {
    private String subjectTaught;

    public Teacher(String name, String subjectTaught) {
        super(name);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject Taught: " + subjectTaught);
        System.out.println("Role: Teacher");
    }

    @Override
    public String toDataString() {
        return id + "," + name + "," + subjectTaught;
    }
}
