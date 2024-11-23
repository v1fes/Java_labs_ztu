package com.education.ztu;

class Teacher extends Person {
    private static int counter;
    private String subject;
    private String university;
    private Car car;

    Teacher() {
        super();
        counter++;
    }

    Teacher(String firstname, String lastname, int age, Gender gender, Location location, String subject, String university, Car car) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    public static int showCounter() {
        return counter;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void getOccupation() {
        System.out.println("Occupation: Teacher");
    }
}
