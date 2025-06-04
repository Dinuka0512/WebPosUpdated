package org.example.dao.custom.impl;

import org.example.config.FactoryConfig;
import org.example.dao.custom.CustomerDAO;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() {
        Session session = FactoryConfig.getInstance().sessionFactory();
        session.beginTransaction();
        Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
        List<Customer> resultList = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return (ArrayList<Customer>) resultList;
    }

    @Override
    public boolean save(Customer dto) {
        Session session = FactoryConfig.getInstance().sessionFactory();
        session.beginTransaction();
        session.persist(dto);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Customer dto) {
        return false;
    }

    @Override
    public boolean exist(String id) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public Customer search(String id) {
        return null;
    }
}
