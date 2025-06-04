package org.example.dao;

import org.example.dao.custom.impl.CustomerDAOImpl;

import java.lang.reflect.Type;

public class DAOFactory implements SuperDAO {
    public static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (daoFactory == null)? daoFactory = new DAOFactory(): daoFactory;
    }

    public enum getDaoType{
        CUSTOMER
    }

    public SuperDAO getDao(getDaoType type){
        switch (type){
            case CUSTOMER -> {
                return new CustomerDAOImpl();
            }

            default -> {
                return null;
            }
        }
    }
}
