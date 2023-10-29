package ru.rodin.javacore.hw4.shop;

import ru.rodin.javacore.hw4.shop.exep.CustomerNotExistExeption;
import ru.rodin.javacore.hw4.shop.exep.NegativeProductCountExeption;
import ru.rodin.javacore.hw4.shop.exep.ProductNotExistExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        var orderLines = Map.of(1, 2, 2, 1, 4, 3);
        makeOrder(1, orderLines);

        makeOrder(2, orderLines);

        var orderLinesWithWrongProduct = Map.of(1, 2, 2, 1, 4, 3, 10, 9);
        makeOrder(2, orderLinesWithWrongProduct);

        var orderLinesWithNegativeCount = Map.of(1, 2, 2, 1, 4, -3);
        makeOrder(3, orderLinesWithNegativeCount);

        makeOrder(10, orderLines);

        System.out.println("Всего заказов: " + orders.size());
        for (var order : orders) {
            System.out.println(order);
        }
    }

    private static void makeOrder(int customerId, Map<Integer, Integer> orderLines) {
        try {
            orders.add(Shopify.makeOrder(customerId, orderLines));

        } catch (CustomerNotExistExeption | NegativeProductCountExeption | ProductNotExistExeption e) {
            System.out.println(e.getMessage());
        }
    }
}
