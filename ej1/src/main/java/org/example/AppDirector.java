package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Clase principal para hacer la inserción de un director usando hibernate.
 */
public class AppDirector
{
    public static void main( String[] args){

        // 1. Crear el objeto Configuration y cargar hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // 2. Crear la SessionFactori a partir de de configuración
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // 3. Abrir una sesión
        Session sesion = sessionFactory.openSession();

        // 4. Iniciar una transacción
        Transaction tx = sesion.beginTransaction();

        try{
            // 5. Crear un objeto Director en estado "Transient"
            Director dir = new Director("Gonzalo", 35000);

            // 6. Guardar el empleado (HIBERNATE GENERA EL INSERT)
            sesion.save(dir);   // Ahora dir pasa a estado "parsient"

            // 7. Confirmar la transacción (se ejecuta el Insert a la BD)
            tx.commit();

            System.out.println("Director insertado correctamente " + dir);
        } catch (Exception e){
            // Si algo falla deshacemos la transacción
            if (tx != null){
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            // 8. Cerramos la sesión y la SessionFactori
            sesion.close();
            sessionFactory.close();
        }
    }
}
