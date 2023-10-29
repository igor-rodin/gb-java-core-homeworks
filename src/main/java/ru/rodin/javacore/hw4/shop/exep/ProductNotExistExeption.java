package ru.rodin.javacore.hw4.shop.exep;

public class ProductNotExistExeption extends RuntimeException {
    private final int productId;

    public ProductNotExistExeption(int productId) {
        this.productId = productId;
    }

    @Override
    public String getMessage() {
        return String.format("Товар с id %d не существует", this.productId);
    }
}
