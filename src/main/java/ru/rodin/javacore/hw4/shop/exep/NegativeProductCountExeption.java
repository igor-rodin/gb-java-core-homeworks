package ru.rodin.javacore.hw4.shop.exep;

public class NegativeProductCountExeption extends RuntimeException{
    private final int productCount;

    public NegativeProductCountExeption(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String getMessage() {
        return String.format("Количество товара не может быть отрицательным, получено %d", this.productCount);
    }
}
