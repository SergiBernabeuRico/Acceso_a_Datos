package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class AppDisco {
    public static void main(String[] args){

        // 1. CREAR UN OBJETO CONFIGURATION Y CARGAR EL hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");   // busca el fichero en src/main/resources

        // 2. CREAR LA SessionFactory A PARTIR DE LA CONFIGURACION
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // 3. ABRIR UNA SESION (equivalente a una conexión a la Base de Datos)
        Session sesion = sessionFactory.openSession();

        // 4. INICIAR UNA TRANSACCION
        Transaction tx = sesion.beginTransaction();

        try{
            // 5. CREAR UN OBJETO Disco EN ESTADO "transient"
            Disco disc = new Disco("Odisea en el lodo", "SFDK");

            // 6. GUARDAR EL DISCO (Hibernate GENERA EL INSERT EN LA BD)
            sesion.save(disc);

            // 7. CONFIRMAR LA TRANSACCION
            tx.commit();

            System.out.println("Disco insertado correctamente");
        }catch (Exception e){
            // Si algo falla, deshacemos la transacción
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            sesion.close();
            sessionFactory.close();
        }
    }
}
