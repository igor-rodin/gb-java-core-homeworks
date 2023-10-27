package ru.rodin.javacore.hw3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    @Test
    void increaseSalary() {
        var emp1 = new Employee("test", "test", "test", "test", 2023, 10, 10, "test", 10);
        var emp2 = new Employee("test", "test", "test", "test", 2023, 10, 10, "test", 10);
        var emp3 = new Employee("test", "test", "test", "test", 2023, 10, 10, "test", 10);
        var emp4 = new Employee("test", "test", "test", "test", 2023, 10, 10, "test", 10);
        var manager = new Manager("test", "test", "test", "test", 2023, 10, 10, "test", 10);

        emp1.setSalary(100);
        emp1.setBirthYear(2000);
        emp2.setSalary(100);
        emp2.setBirthYear(1975);
        manager.setSalary(1000);
        List<Employee> employees = List.of(emp1, emp2, emp3, emp4, manager);

        for ( Employee employee : employees) {
            Manager.increaseSalary(employee, 45, 50);
        }

        assertEquals(100, emp1.getSalary());
        assertEquals(150, emp2.getSalary());
        assertEquals(1000, manager.getSalary());
    }
}