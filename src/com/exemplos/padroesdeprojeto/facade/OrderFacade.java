package com.exemplos.padroesdeprojeto.facade;

import com.exemplos.padroesdeprojeto.Order;
import com.exemplos.padroesdeprojeto.singleton.DatabaseConnection;
import com.exemplos.padroesdeprojeto.strategy.PaymentStrategy;

public class OrderFacade {
    private final DatabaseConnection dbConnection;
    private PaymentStrategy paymentStrategy;

    public OrderFacade(PaymentStrategy paymentStrategy) {
        this.dbConnection = DatabaseConnection.getInstance();
        this.paymentStrategy = paymentStrategy;
    }

    public void placeOrder(Order order) {
        dbConnection.connect();
        System.out.println("Order placed: " + order.getProduct());
        paymentStrategy.pay(order.getAmount());
    }
}
