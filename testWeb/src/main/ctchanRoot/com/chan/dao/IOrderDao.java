package com.chan.dao;

import com.chan.entity.Order;


public interface IOrderDao {
    Order getOrderById(Long orderId);

    void modifyOrder(Order order);

    void addOrder(Order order);
}
