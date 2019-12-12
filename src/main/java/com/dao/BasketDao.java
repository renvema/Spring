package com.dao;

import com.entity.Basket;
import com.entity.Product;
import com.entity.User;

import java.util.Optional;

public interface BasketDao {

    void addBasket(Basket basket);

    void addProductToBasket(Basket basket, Product product);

    int size(Basket basket);

    Optional<Basket> getBasketByUser(User user);
}
