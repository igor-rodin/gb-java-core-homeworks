package ru.rodin.javacore.hw4.shop;

public class Customer {
    private static int customersCounts = 0;

    private final int id;

    private String name;
    private String address;

    public Customer(String name, String address) {
        customersCounts++;
        this.id = customersCounts;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
