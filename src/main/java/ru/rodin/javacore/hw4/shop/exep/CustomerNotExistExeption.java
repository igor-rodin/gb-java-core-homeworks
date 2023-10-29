package ru.rodin.javacore.hw4.shop.exep;

public class CustomerNotExistExeption extends RuntimeException {
    private final int customerId;

    public CustomerNotExistExeption(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String getMessage() {
        return String.format("Покупатель с id %d не существует", this.customerId);
    }
}
