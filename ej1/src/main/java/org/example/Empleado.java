package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

/**
 * Entidad Empleado.
 * Se mapea a la tabla "empleados" de la base de datos.
 */
@Entity                     // Esta clase es una entidad JPA
@Table(name = "empleados")  // Nombre de la tabla
public class Empleado implements Serializable {

    //  Campo id: será la clave primaria de la tabla.
    @Id                                      // Marca este campo como PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental
    @Column(name = "id")                     // Nombre de la columna en la tabla
    private Long id;    // clave primaria

    //  Campo nombre del empleado
    @Column(name = "nom")
    private String nom;

    //  Campo salario del empleado
    @Column(name = "salario")
    private double salario;

    /**
     * Constructor vacío obligatorio para Hibernate.
     * Hibernate necesita poder crear objetos sin parámetros.
     */
    public Empleado() {
    }

    // Constructor para crear empleados desde el código
    public Empleado(String nom, double salario) {
        this.nom = nom;
        this.salario = salario;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    // Normalmente no usaremos mucho este setter, porque el id lo genera la BD
    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nom='" + nom + ", salario=" + salario + '}';
    }
}
