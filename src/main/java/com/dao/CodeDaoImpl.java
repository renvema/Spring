package com.dao;

import com.entity.Code;
import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class CodeDaoImpl implements CodeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Code code) {
        sessionFactory.getCurrentSession().save(code);
    }

    @Override
    public Optional<Code> getCodeForUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        TypedQuery<Code> query = session.createQuery(
                "FROM Code WHERE user = :user ORDER BY id DESC ");
        query.setParameter("user", user);
        List list = query.getResultList();
        if (list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of((Code) list.get(0));
        }
    }
}
