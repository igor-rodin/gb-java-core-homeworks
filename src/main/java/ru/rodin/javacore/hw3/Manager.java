package ru.rodin.javacore.hw3;

public class Manager extends Employee {
    public Manager(String firstName, String patronymic, String lastName, String position, int birthYear, int birthMonth, int birthDay, String phoneNumber, double salary) {
        super(firstName, patronymic, lastName, position, birthYear, birthMonth, birthDay, phoneNumber, salary);
    }

    /**
     * Повышает зарплату сотруднику на premium если он старше age и не является менеджером
     *
     * @param employee
     * @param age
     * @param premium
     */
    public static void increaseSalary(Employee employee, int age, double premium) {
        if (premium < 0) {
            throw new IllegalArgumentException("Надбавка, не может быть отрицательной");
        }

        if (employee instanceof Manager) {
            return;
        }
        if (employee.getAge() < age) {
            return;
        }

        employee.setSalary(employee.getSalary() + premium);
    }
}
