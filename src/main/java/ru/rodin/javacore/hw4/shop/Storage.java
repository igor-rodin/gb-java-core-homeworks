package ru.rodin.javacore.hw4.shop;

import java.util.List;

/**
 * Хранилище покупателей и товаров
 */
public class Storage {
    private static final List<Customer> customers = List.of(
            new Customer("Customer1", "Minsk"),
            new Customer("Customer2", "Moscow"),
            new Customer("Customer3", "Berlin"));

    private static final List<Product> products = List.of(
            new Product("Product1", 100),
            new Product("Product2", 200),
            new Product("Product3", 300),
            new Product("Product4", 400));

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public static Customer findCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public static Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
