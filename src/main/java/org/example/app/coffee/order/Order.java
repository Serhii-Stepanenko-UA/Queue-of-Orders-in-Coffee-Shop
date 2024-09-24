package org.example.app.coffee.order;

public class Order {
    private int num = 1;
    private String name;

    public Order(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;
        return num == order.num && name.equals(order.name);
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
