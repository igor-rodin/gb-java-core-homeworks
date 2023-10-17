package ru.rodin.javacore.hw2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TasksTest {

    @Test
    void testCountEvens() {
        int[] arr = {
                2, 1, 2, 3, 4
        };
        assertThat(Tasks.countEvens(arr)).isEqualTo(3);
    }

    @Test
    void testDiffMinMax() {
        int[] arr = {2, 1, 2, 3, 4};
        assertThat(Tasks.diffMinMax(arr)).isEqualTo(3);
    }

    @Test
    void testThatArrHasSiblingZeros() {
        int[] arr = {1, 1, 2, 0, 0};
        assertThat(Tasks.hasSiblingZeros(arr)).isTrue();
    }

    @Test
    void testThatArrHasNoSiblingZeros() {
        int[] arr = {1, 0, 2, -4, 0};
        int[] arr2 = {1, 9, 2, -4, 0};
        int[] arr3 = {0};
        assertThat(Tasks.hasSiblingZeros(arr)).isFalse();
        assertThat(Tasks.hasSiblingZeros(arr2)).isFalse();
        assertThat(Tasks.hasSiblingZeros(arr3)).isFalse();
    }
}