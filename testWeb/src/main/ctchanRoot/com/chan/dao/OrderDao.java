package com.chan.dao;

import com.chan.entity.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class OrderDao implements IOrderDao {
    @Override
    public Order getOrderById(Long orderId) {
        return null;
    }

    @Override
    public void modifyOrder(Order order) {

    }

    @Override
    public void addOrder(Order order) {

    }
}
