package org.example;

import org.example.config.FactoryConfig;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfig.getInstance().sessionFactory();
    }
}