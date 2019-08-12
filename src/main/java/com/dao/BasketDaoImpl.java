package com.dao;

import com.entity.Basket;
import com.entity.Product;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class BasketDaoImpl implements BasketDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addBasket(Basket basket) {
        sessionFactory.getCurrentSession().save(basket);
    }

    @Override
    public void addProductToBasket(Basket basket, Product product) {
        Session session = sessionFactory.getCurrentSession();
        basket.getProducts().add(product);
        session.update(basket);

    }

    @Override
    public int size(Basket basket) {
        return basket.getProducts().size();
    }

    @Override
    public Optional<Basket> getBasketByUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Basket> query = session.createQuery(
                "FROM Basket WHERE user = :user ORDER BY id DESC");
        query.setParameter("user", user);
        List list = query.getResultList();
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of((Basket) list.get(0));
        }
    }
}
