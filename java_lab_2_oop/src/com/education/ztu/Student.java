package com.education.ztu;

class Student extends Person {
    private static int counter;
    private int course;
    private String speciality;
    private String university;

    Student() {
        super();
        counter++;
    }

    Student(String firstname, String lastname, int age, Gender gender, Location location, int course, String speciality, String university) {
        super(firstname, lastname, age, gender, location);
        this.course = course;
        this.speciality = speciality;
        this.university = university;
        counter++;
    }

    public static int showCounter() {
        return counter;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Student");
    }
}
