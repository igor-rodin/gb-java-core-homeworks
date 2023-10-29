package ru.rodin.javacore.hw4.shop;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private static int orderCounts = 0;
    private final int id;

    private Customer customer;
    private Map<Product, Integer> products;
    private final LocalDateTime orderDate;

    public Order(Customer customer, Map<Product, Integer> products) {
        this.id = ++orderCounts;
        this.orderDate = LocalDateTime.now();
        this.customer = customer;
        this.products = products;
    }
}
