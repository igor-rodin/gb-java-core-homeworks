package ru.rodin.javacore.hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {

        int STUDENT_LIST_SIZE = 100;
        List<Student> studentList = generateStudents(STUDENT_LIST_SIZE);


        String speciality = "Информатика";
        double averageGrade = 4.5;
        int bestStudentLimit = 5;

        List<Student> fiveBestComputerScienceStudents = studentList.stream()
                .filter(student -> student.getSpeciality().equals(speciality) &&  student.getAverageGrade() >= averageGrade)
                .sorted(new Student.AverageGradeComparator(true))
                .limit(bestStudentLimit).toList();
        fiveBestComputerScienceStudents.forEach(System.out::println);
    }

    /**
     * Генерирует список студентов со случайными оценками
     * @param studentListSize - количество студентов
     * @return - список студентов
     */
    private static List<Student> generateStudents(int studentListSize) {
        List<Student> studentList = new ArrayList<>();
        List<String> specialityList = List.of("Информатика", "Математика", "История", "Физическая культура", "Физика", "Химия");

        for (int i = 0; i < studentListSize; i++) {
            String speciality = specialityList.get(i % specialityList.size());
            String name = "Student_" + i;
            List<Double> grades = Stream.generate(() -> new Random().nextInt(4, 6)).limit(10).map(Double::valueOf).toList();
            studentList.add(new Student(name, grades, speciality));
        }

        return studentList;
    }
}
