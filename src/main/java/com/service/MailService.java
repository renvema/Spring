package com.service;


import com.entity.Order;

public interface MailService {

    void sendConfirmCode(Order order);
}
