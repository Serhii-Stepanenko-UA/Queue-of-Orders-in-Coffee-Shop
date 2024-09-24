package org.example.app.coffee.order;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.logging.Level.*;
//import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {

    private static final Logger LOGGER =
            LogManager.getLogger(Main.class.getName());

    private static CoffeeOrderBoard coffeeOrderBoard;

    public static void main(String[] args) {
        // Встановлення на SEVERE з дефолтного INFO
        // може перекрити інші рівні
//        LOGGER.setLevel(Level.SEVERE);   // З org.apache.logging.log4j.Logger не працює
//        LOGGER.setLevel(Level.WARNING); // Працює з java.util.logging.Level
//        LOGGER.log(Level.WARNING, "This is level WARNING logging");
//        LOGGER.log(Level.SEVERE, "This is level SEVERE logging");

        LOGGER.trace("Це повідомлення трасування");
        LOGGER.debug("Це повідомлення дебаг рівня");
        LOGGER.info("Це інформаційне повідомлення");
        LOGGER.warn("Це попереджувальне повідомлення");
        LOGGER.error("Це повідомлення про помилку");
        LOGGER.fatal("Це повідомлення про фатальну помилку");
        System.out.println("This is Java Logging API.");

        // Створюємо початковий список замовлень, вручну
        coffeeOrderBoard = new CoffeeOrderBoard();

        // За-/Розкомпілювати для тестів
        coffeeOrderBoard.addOrder(new Order(4, "Alen"));
        coffeeOrderBoard.addOrder(new Order(27, "Yoda"));
        coffeeOrderBoard.addOrder(new Order(33, "Obi-van"));
        coffeeOrderBoard.addOrder(new Order(34,"John Snow"));

        try {
            // Виводимо початковий список у порядку надходження замовлень
            // або отримуємо викид, що черга має 0 замовлень
            System.out.println("\nInitial Queue of " + coffeeOrderBoard.getOrdersCount() + " orders:");
            System.out.println(coffeeOrderBoard.draw());

            // Роз-/Закомпілювати для тесту на створення першого замовлення у пустий лист
//            coffeeOrderBoard.addOrder(coffeeOrderBoard.createOrder("Pioner"));

            // Останнє замовлення номер
            System.out.println("The last orders number is: " +  coffeeOrderBoard.draw().getLast().getNum());

        } catch (Exception e) {
            LOGGER.error("Черга замовлень пуста! Перед отриманням стану - додайте замовлення.");
        }

        // Створення нових замовлень за іменем додавання в список черги
        coffeeOrderBoard.addOrder(coffeeOrderBoard.createOrder("Micael"));
        coffeeOrderBoard.addOrder(coffeeOrderBoard.createOrder("Sara"));
        coffeeOrderBoard.addOrder(coffeeOrderBoard.createOrder("Tom"));

        // Перевірка поточного стану після додавання замовлень
        System.out.println("\nQueue after adding new order is " + coffeeOrderBoard.getOrdersCount() + " orders:");
        System.out.println(coffeeOrderBoard.draw());
        System.out.println("The last orders number is: " +  coffeeOrderBoard.draw().getLast().getNum());

        // Перевірка першого номеру в черзі до видачі поточного замовлення
        System.out.println("\nThe first orders number is: " +  coffeeOrderBoard.draw().getFirst().getNum());
        // Доставлення чергового замовлення із видаленням із черги
        coffeeOrderBoard.deliverOrder();
        System.out.println("The first orders number is: " +  coffeeOrderBoard.draw().getFirst().getNum());
        System.out.println("Queue after delivering order is " + coffeeOrderBoard.getOrdersCount() + " orders:");
        System.out.println(coffeeOrderBoard.draw());

        try {
            // Видача і видалення позачергового замовлення по індексу
            // Або при помилковому індексі - викид повідомлення про помилку
            coffeeOrderBoard.deliver(1);
//            coffeeOrderBoard.deliver(20);

//            LOGGER.error("Замовлення з таким індексом не існує.");
            System.out.println("\nQueue after delivering order is " + coffeeOrderBoard.getOrdersCount() + " orders:");
            System.out.println(coffeeOrderBoard.draw());
        } catch (RuntimeException e) {
//            LOGGER.log(Level.SEVERE, "Exception: " + e.getMessage());
            LOGGER.error("Введено індекс за межами розміру листа замовлень!");
        }
    }
}
