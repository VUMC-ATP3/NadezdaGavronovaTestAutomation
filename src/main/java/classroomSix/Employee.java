package classroomSix;

import com.github.javafaker.Faker;

import javax.xml.namespace.QName;

public class Employee {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public Employee(){
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.position = faker.company().profession();
        this.salary = faker.number().randomDouble(2, 100, 2000);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }



}
