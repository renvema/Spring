package com.dao;

import com.entity.Code;
import com.entity.Order;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Order> getOrder(User user) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Code> query = session.createQuery(
                "FROM Order WHERE user = :user ORDER BY id DESC");
        query.setParameter("user", user);
        List list = query.getResultList();
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of((Order) list.get(0));
        }
    }

    @Override
    public void add(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }
}
