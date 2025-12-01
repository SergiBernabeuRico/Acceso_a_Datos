package com.dam2;

import com.dam2.ej2relaciones.Deporte;
import com.dam2.ej2relaciones.Empleado;
import com.dam2.ej2relaciones.Empresa;
import com.dam2.ej2relaciones.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Empresa empresa1 = new Empresa("Congelados Martínez");
        Empleado empleado1 = new Empleado("Pepe Pérez",2000,empresa1);
        Empleado empleado2 = new Empleado("Antonio López",2222,empresa1);
        empresa1.getEmpleados().add(empleado1);
        empresa1.getEmpleados().add(empleado2);
        empleado1.setDeporte(new Deporte("tenis"));
        empleado2.setDeporte(new Deporte("futbol sala"));
        Usuario usuario1 = new Usuario("pepe","secreto");
        usuario1.setEmpleado(empleado1);
        Usuario usuario2 = new Usuario("toni","secreta");
        usuario2.setEmpleado(empleado2);
        empleado1.setUsuario(usuario1);
        empleado2.setUsuario(usuario2);
        //ss.persist(empleado1);
        //ss.persist(empleado2);
        ss.persist(empresa1);
        tr.commit();

    }
}
