package com.demo.shopping.service;

import com.demo.shopping.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    List<Order> getAllOrders();
}
