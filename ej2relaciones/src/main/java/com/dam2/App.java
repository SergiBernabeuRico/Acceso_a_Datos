package com.dam2;

import com.dam2.ej2relaciones.*;
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
        Empleado empleado2 = new Jefe("Antonio López",2222,"recursos humanos");
        empleado2.setEmpresa(empresa1);

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
        Inversor inversor1 = new Inversor("David García");
        inversor1.getEmpresas().add(empresa1);
        Inversor inversor2 = new Inversor("Inversores del Sureste");
        inversor2.getEmpresas().add(empresa1);
        Empresa empresa2 = new Empresa("Electricidad Fuster");
        inversor2.getEmpresas().add(empresa2);
        empresa1.getInversores().add(inversor1);
        empresa1.getInversores().add(inversor2);
        empresa2.getInversores().add(inversor2);

        Empleado empleado3 = new Tecnico("Carlos Cosa",3333,"informática");
        empleado3.setEmpresa(empresa2);
        empresa2.getEmpleados().add(empleado3);
        //ss.persist(empleado1);
        //ss.persist(empleado2);
        ss.persist(empresa1);
        ss.persist(empresa2);
        tr.commit();

    }
}
