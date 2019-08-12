package com.service;

import com.dao.OrderDao;
import com.entity.Order;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Transactional(readOnly = true)
    @Override
    public Optional<Order> getOrder(User user) {
        return orderDao.getOrder(user);
    }

    @Transactional
    @Override
    public void add(Order order) {
        orderDao.add(order);
    }
}
