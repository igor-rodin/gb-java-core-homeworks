package ru.rodin.javacore.hw4.shop;

public class Product {
    private static int productCounts = 0;
    private final int id;
    private String title;
    private double price;

    public Product(String title, double price) {
        productCounts++;
        id = productCounts;
        this.title = title;
        setPrice(price);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        this.price = price;
    }
}
