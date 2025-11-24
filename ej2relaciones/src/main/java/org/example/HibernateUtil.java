package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // SesionFactory estática (única para toda la app)
    private static SessionFactory sf;

    // Contructor privado -> patrón singleton
    private HibernateUtil(){};

    public static SessionFactory getSessionFactory(){
        if(null == sf)
            sf = new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());

        return sf;
    }
}
