package com.service;

import com.entity.Order;
import com.entity.User;

import java.util.Optional;

public interface OrderService {

    Optional<Order> getOrder(User user);

    void add(Order order);
}
