package org.example.app.coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CoffeeOrderBoard {

    private static final Logger LOGGER =
            LogManager.getLogger(CoffeeOrderBoard.class);

    private List<Order> orders = new LinkedList<>();

    //  Метод addOrder додає замовлення з наданим номером та іменем в кінець зв'язаного списку.
    public void addOrder(Order order) {
        Objects.requireNonNull(order,
                "Parameter [order] must not be null!");
        orders.addLast(order);
    }

    // Метод createOrder створює нове замовлення, приймаючи ім'я та надає замовленню номер (натуральний порядок).
    public Order createOrder(String name) {
        int num;
        if (!orders.isEmpty()) {
            num = orders.getLast().getNum() + 1;
            return new Order(num, name);
        } else {
            num = 1;
            return new Order(num, name);
        }
    }

    // Метод deliverOrder видає найближче на черзі замовлення.
    // Видача супроводжується видаленням замовлення зі списку
    public void deliverOrder() {
        System.out.println("Delivery of the current order, removal from the list: "
                + orders.removeFirst());
    }

    // Метод deliver, приймає на вхід індекс замовлення.
    // Данний метод видає замовлення з певним індексом.
    // Видача супроводжується видаленням замовлення зі списку.
    // Данний метод обробляє ситуацію, коли замовлення, що надійшло пізніше, готове раніше.
    public Order deliver(int ind) {
        return orders.remove(ind);
    }

    // Метод draw який виводить у консоль інформацію про поточний стан черги
    // у порядку найближчого до видачі замовлення.
    public List<Order> draw() {
        return orders;
    }

    // Метод getOrderCount повертає розмір черги
    public int getOrdersCount() {
        return orders.size();
    }

}
