package ru.rodin.javacore.hw4.shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product_1 = new Product("title", 100);
        Product product_2 = new Product("title2", 100);

        assertEquals(1, product_1.getId());
        assertEquals(2, product_2.getId());
    }
}