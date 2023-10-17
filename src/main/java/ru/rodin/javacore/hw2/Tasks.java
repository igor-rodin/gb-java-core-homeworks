package ru.rodin.javacore.hw2;

public class Tasks {
    /**
     * Считает количество четных чисел в массиве
     * @param numbers Массив чисел
     * @return Количество четных чисел
     */
    public static int countEvens(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException();
        }
        int counts = 0;
        for (int val : numbers) {
            if (val % 2 == 0) {
                counts++;
            }
        }
        return counts;
    }

    /**
     * Находит разницу между максимальным и минимальным элементами массива чисел
     * @param numbers Массив чисел
     * @return Разницу max -min
     */
    public static int diffMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int min = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            min = Math.min(numbers[i], min);
            max = Math.max(numbers[i], max);
        }

        return max - min;
    }

    /**
     * Проверяет, есть ли в массиве чисел два рядом стоящих нулевых элементов
     * @param numbers Массив чисел
     * @return True, если есть и False в противоположном случае
     */
    public static boolean hasSiblingZeros(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0 && numbers[i + 1] == 0) {
                return true;
            }
        }

        return false;
    }
}
