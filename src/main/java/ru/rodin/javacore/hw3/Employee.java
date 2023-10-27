package ru.rodin.javacore.hw3;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;


public class Employee {
    public static final int MAX_MONTH = 12;
    public static final int MIN_MONTH = 1;
    private String firstName;
    private String patronymic;
    private String lastName;
    private String position;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private String phoneNumber;
    private double salary;

    public Employee(String firstName, String patronymic, String lastName, String position, int birthYear, int birthMonth, int birthDay, String phoneNumber, double salary) {
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        setSalary(salary);
        setBirthYear(birthYear);
        setBirthMonth(birthMonth);
        setBirthDay(birthDay);
    }

    /**
     * Gets the age of a person based on their birth year.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return LocalDate.now().getYear() - this.birthYear;
    }

    public void showInfo() {
        String info = MessageFormat.format("Сотрудник: \n\tИмя: {0}, Фамилия: {1}, Отчество: {2}\n\tДата рождения: {3}.{4}.{5}\n\tТелефон: {6}\n\tЗарплата: {7}\n\tДолжность: {8}",
                this.firstName, this.lastName, this.patronymic, this.birthDay, this.birthMonth, this.birthYear, this.phoneNumber, this.salary, this.position);
        System.out.println(info);
    }

    /**
     * Compare dates by year, month and day.
     * @param day
     * @param month
     * @param year
     * @return negative if employee is older, positive if employee is younger, 0 if they are the same
     */
    public int compareAge(int day, int month, int year) {
        int empDate = birthYear * 10_000 + birthMonth * 100 + birthDay;
        int secondDate = year * 10_000 + month * 100 + day;
        return  empDate - secondDate;

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int birthYear) {
        if (birthYear > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Неверный год рождения");
        }
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return this.birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        var now = LocalDate.now();
        if (birthMonth > MAX_MONTH || birthMonth < MIN_MONTH) {
            throw new IllegalArgumentException("Неверный месяц рождения");
        }
        if (this.birthYear == now.getYear() && birthMonth > now.getMonthValue()) {
            throw new IllegalArgumentException("Неверный месяц рождения");
        }
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        var now = LocalDate.now();
        var maxDays = now.getMonth().length(now.isLeapYear());
        if (birthDay > maxDays || birthDay < 1) {
            throw new IllegalArgumentException("Неверный день рождения");
        }
        if (this.birthYear == now.getYear() && this.birthMonth == now.getMonthValue() && birthDay > now.getDayOfMonth()) {
            throw new IllegalArgumentException("Неверный день рождения");
        }
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }
}
