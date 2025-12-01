package com.dam2.ej2relaciones;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("jefe")
public class Jefe extends Empleado{
    @Column
    private String departamento;

    public Jefe() {
    }

    public Jefe(String nom, double salario, String departamento) {
        super(nom, salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "departamento='" + departamento + '\'' +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", empresa=" + empresa +
                ", deporte=" + deporte +
                ", usuario=" + usuario +
                '}';
    }
}
