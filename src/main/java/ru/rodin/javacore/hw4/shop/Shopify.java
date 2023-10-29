package ru.rodin.javacore.hw4.shop;

import ru.rodin.javacore.hw4.shop.exep.CustomerNotExistExeption;
import ru.rodin.javacore.hw4.shop.exep.NegativeProductCountExeption;
import ru.rodin.javacore.hw4.shop.exep.ProductNotExistExeption;

import java.util.HashMap;
import java.util.Map;

/**
 * Сервиз для создания заказа
 */
public class Shopify {
    /**
     * Возвращает новый заказ или бросает исключение
     * @param customerId id покупателя
     * @param orderLines список покупок
     * @return новый заказ
     */
    public static Order makeOrder(int customerId, Map<Integer, Integer> orderLines) {
        Customer customer = Storage.findCustomerById(customerId);
        if (customer == null) {
            throw new CustomerNotExistExeption(customerId);
        }

        Map<Product, Integer> products = new HashMap<>();
        for (var line : orderLines.entrySet()) {
            int productId = line.getKey();
            var product = Storage.findProductById(productId);
            if (product == null) {
                throw new ProductNotExistExeption(productId);
            }
            int productCount = line.getValue();
            if (productCount < 0) {
                throw new NegativeProductCountExeption(productCount);
            }
            products.put(product, productCount);
        }

        return new Order(customer, products);
    }
}
