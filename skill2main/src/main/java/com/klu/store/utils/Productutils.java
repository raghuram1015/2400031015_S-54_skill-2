package com.klu.store.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Productutils {

    private static final SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}