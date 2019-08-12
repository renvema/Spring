package com.service;

import com.entity.Basket;
import com.entity.Product;
import com.entity.User;

import java.util.Optional;

public interface BasketService {

    void addBasket(Basket basket);

    void addProductToBasket(Basket basket, Product product);

    int size(Basket basket);

    Optional<Basket> getBasketByUser(User user);
}
