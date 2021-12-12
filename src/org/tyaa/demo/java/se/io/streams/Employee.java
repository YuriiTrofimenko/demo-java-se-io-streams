package org.tyaa.demo.java.se.io.streams;

import java.io.Serializable;

public class Employee implements Serializable {
    public Integer id;
    public String name;
    public double salary;
    public Employee chief;

    public Employee(Integer id, String name, double salary, Employee chief) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.chief = chief;
    }

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.salary = employee.salary;
        this.chief = employee.chief;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", salary=" + salary +
            ", chief=" + chief +
            '}';
    }
}
