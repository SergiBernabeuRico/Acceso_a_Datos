package org.example;

import org.example.ej2relaciones.Empleado;
import org.example.ej2relaciones.Empresa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class App 
{
    public static void main( String[] args ){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Empresa empresa1 = new Empresa("Congelados Nieves");
        Empleado empleado1 = new Empleado("Pablo Martínez", 1500, empresa1);

        ss.persist(empresa1);
        ss.persist(empleado1);

        tr.commit();
        ss.close();
        sf.close();
    }
}
