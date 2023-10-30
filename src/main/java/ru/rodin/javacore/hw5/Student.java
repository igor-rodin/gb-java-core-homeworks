package ru.rodin.javacore.hw5;

import java.util.Comparator;
import java.util.List;

public class Student {
    private String name;
    private final List<Double> grades;
    private String speciality;

    public Student(String name, List<Double> grades, String speciality) {
        this.name = name;
        this.grades = grades;
        this.speciality = speciality;
    }

    public double getAverageGrade() {
        return this.grades.stream().mapToDouble(Double::doubleValue).average().orElseThrow();
    }

    static class AverageGradeComparator implements Comparator<Student> {
        private final boolean reverse;

        public AverageGradeComparator() {
            this(false);
        }

        public AverageGradeComparator(boolean reverse) {
            this.reverse = reverse;
        }

        @Override
        public int compare(Student studentFirst, Student studentSecond) {
            if (reverse) {
                return Double.compare(studentSecond.getAverageGrade(), studentFirst.getAverageGrade());
            }
            return Double.compare(studentFirst.getAverageGrade(), studentSecond.getAverageGrade());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", speciality='" + speciality + '\'' +
                ", averageGrade=" + getAverageGrade() +
                '}';
    }
}
