package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ValueGenerationType;

import java.io.Serializable;

/**
 * Entidad Director
 * Se mapea a la tabla "directores" de la base de datos
 */

@Entity     // Esta clase es una entidad JPA
@Table(name = "directores")     // Nombre de la tabla
public class Director implements Serializable {

    // Campo id: Será la clave primaria de la tabla
    @Id                                                     // Marca el campo como PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Valor autoincremental
    @Column(name = "id")                                    // Nombre de la columna en la tabla
    private long id;                                        // Clave primaria

    // Campo nombre del director
    @Column(name = "nom")
    private String nom;

    // Campo salario del director
    @Column(name = "salario")
    private double salario;

    /**
     * Constructor vacío obligatorio para Hibernate
     * Hibernate necesita poder crear objetos sin parámetros
     */
    public Director(){

    }

    public Director(String nom, double salario){
        this.nom = nom;
        this.salario = salario;
    }

    // SETTERS Y GETTERS
    public long getId(){
        return id;
    }

    // Normalmente este setter no será muy utilizado, porque el id lo genera la base de datos
    public void setId(long id) {
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
    public String toString(){
        return "Empleado{ id= " + id + ", nom= " + nom + ", salario= " + salario + "}";
    }
}
