package com.javafee.springdemo.dao;

import com.javafee.springdemo.entity.Numerator;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Log
@Repository
public class NumeratorDaoImpl implements NumeratorDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Numerator> getNumerators() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Numerator order by id, value", Numerator.class).getResultList();
    }

    @Override
    public List<Numerator> searchNumeratorsByValue(String value) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query;
        //log.info(String.valueOf(value != null && value.trim().length() > 0 && Integer.parseInt(value) >= 0));
        if (value != null && value.trim().length() > 0 && Integer.parseInt(value) >= 0) {
            query = currentSession.createQuery("from Numerator where value = :theValue");
            query.setParameter("theValue", Integer.parseInt(value));
        } else
            query = currentSession.createQuery("from Numerator", Numerator.class);
        List<Numerator> numerators = query.getResultList();
        return numerators;
    }

    @Override
    public Numerator getNumeratorById(int id) {
        return sessionFactory.getCurrentSession().get(Numerator.class, id);
    }

    @Override
    public void deleteNumerator(Numerator numerator) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(numerator);
    }

    @Override
    public void deleteNumeratorById(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("delete from Numerator where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void saveNumerator(Numerator numerator) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(numerator);
    }
}
