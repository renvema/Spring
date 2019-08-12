package com.service;

import com.dao.BasketDao;
import com.entity.Basket;
import com.entity.Product;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private BasketDao basketDao;

    @Transactional
    @Override
    public void addBasket(Basket basket) {
        basketDao.addBasket(basket);
    }

    @Transactional
    @Override
    public void addProductToBasket(Basket basket, Product product) {
        basketDao.addProductToBasket(basket, product);
    }

    @Transactional
    @Override
    public int size(Basket basket) {
        return basketDao.size(basket);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Basket> getBasketByUser(User user) {
        return basketDao.getBasketByUser(user);
    }
}
