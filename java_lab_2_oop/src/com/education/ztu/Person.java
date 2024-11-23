package com.education.ztu;

abstract class Person implements Human {
    private static int counter;
    private String firstname;
    private String lastname;
    private int age;
    private Gender gender;
    private Location location;

    {
        // Initialization block
        this.firstname = "Unknown";
        this.lastname = "Unknown";
        this.age = 0;
        this.gender = Gender.MALE;
        this.location = Location.KIEV;
    }

    Person() {
        counter++;
    }

    Person(String firstname, String lastname, int age, Gender gender, Location location) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    public static int showCounter() {
        return counter;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getFullInfo() {
        return firstname + " " + lastname + ", Age: " + age + ", Gender: " + gender + ", Location: " + location;
    }

    @Override
    public void sayFullName() {
        System.out.println("Full Name: " + firstname + " " + lastname);
    }

    @Override
    public void sayAge() {
        System.out.println("Age: " + age);
    }

    @Override
    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    @Override
    public void sayGender() {
        System.out.println("Gender: " + gender);
    }

    public abstract void getOccupation();
}