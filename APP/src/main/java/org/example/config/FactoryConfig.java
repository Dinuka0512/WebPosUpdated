package org.example.config;

import org.example.entity.Customer;
import org.example.entity.Item;
import org.example.entity.OrderDetail;
import org.example.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfig {
    public static FactoryConfig factoryConfig;
    public SessionFactory sessionFactory;

    //CREATE THE CONSTRUCTOR
    private FactoryConfig(){
        Configuration configuration = new Configuration();

            //Annotated classes
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Item.class);
            configuration.addAnnotatedClass(OrderDetail.class);
            configuration.addAnnotatedClass(Orders.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfig getInstance(){
        return (factoryConfig==null)? factoryConfig = new FactoryConfig(): factoryConfig;
    }

    public Session sessionFactory(){
        return sessionFactory.openSession();
    }
}
