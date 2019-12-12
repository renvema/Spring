package com.dao;

import com.entity.Order;
import com.entity.User;

import java.util.Optional;

public interface OrderDao {

    Optional<Order> getOrder(User user);

    void add(Order order);
}
