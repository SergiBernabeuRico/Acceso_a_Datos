package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Clase principal.
 * En este main haremos la inserción de un empleado usando Hibernate.
 */
public class AppEmpleado {

    public static void main(String[] args) {

        // 1. Crear el objeto Configuration y cargar hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // busca el fichero en src/main/resources

        // 2. Crear la SessionFactory a partir de la configuración
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // 3. Abrir una sesión (equivalente a una conexión con la BD)
        Session sesion = sessionFactory.openSession();

        // 4. Iniciar una transacción
        Transaction tx = sesion.beginTransaction();

        try {
            // 5. Crear un objeto Empleado en estado "transient"
            Empleado emp = new Empleado("juan", 1475.00);

            // 6. Guardar el empleado (Hibernate genera el INSERT)
            sesion.save(emp); // ahora emp pasa a estado "persistent"

            // 7. Confirmar la transacción (se ejecuta el INSERT en la BD)
            tx.commit();

            System.out.println("Empleado insertado correctamente: " + emp);

        } catch (Exception e) {
            // Si algo falla, deshacemos la transacción
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            // 8. Cerramos la sesión y la SessionFactory
            sesion.close();
            sessionFactory.close();
        }
    }
}
