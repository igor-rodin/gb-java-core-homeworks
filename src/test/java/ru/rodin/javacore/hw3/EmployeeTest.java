package ru.rodin.javacore.hw3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testDatesAreEquals() {
        Employee employee = new Employee("test", "test", "test", "test", 2023, 10, 10, "test", 1.0);
        assertEquals(0, employee.compareAge(10, 10, 2023));
    }
    @Test
    void testEmployeeIsOlder() {
        Employee employee = new Employee("test", "test", "test", "test", 1980,  10, 10, "test", 1.0);
        assertTrue(employee.compareAge(10, 10, 2023) < 0);
    }
    @Test
    void testEmployeeIsYounger() {
        Employee employee  = new Employee("test", "test", "test", "test", 2020,  10, 10, "test", 1.0);
        assertTrue(employee.compareAge(10, 10, 1980) > 0);
    }
}