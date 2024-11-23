package com.education.ztu;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("John", "Doe", 40, Gender.MALE, Location.KIEV, "Math", "University A", new Car("Toyota"));
        teacher.getOccupation();
        teacher.sayFullName();
        teacher.sayAge();
        teacher.sayLocation();
        teacher.sayGender();
        teacher.getCar().getEngine().startEngine();

        Student student = new Student("Jane", "Smith", 20, Gender.FEMALE, Location.ZHYTOMYR, 3, "Computer Science", "University B");
        student.getOccupation();
        student.sayFullName();
        student.sayAge();
        student.sayLocation();
        student.sayGender();

        Employee employee = new Employee("Alex", "Johnson", 35, Gender.MALE, Location.VINNYTSYA, "Tech Corp", "Developer", new Car("Honda"));
        employee.getOccupation();
        employee.sayFullName();
        employee.sayAge();
        employee.sayLocation();
        employee.sayGender();
        employee.getCar().getEngine().startEngine();

        System.out.println("Teacher instanceof Person: " + (teacher instanceof Person));
        System.out.println("Student instanceof Person: " + (student instanceof Person));
        System.out.println("Employee instanceof Human: " + (employee instanceof Human));
    }
}