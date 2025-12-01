package com.dam2.ej2relaciones;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("técnico")
public class Tecnico extends Empleado{
    @Column
    private String materia;

    public Tecnico() {
    }

    public Tecnico(String nom, double salario, String materia) {
        super(nom, salario);
        this.materia = materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "materia='" + materia + '\'' +
                ", id=" + id +
                ", nom='" + nom + '\'' +
                ", salario=" + salario +
                ", empresa=" + empresa +
                ", deporte=" + deporte +
                ", usuario=" + usuario +
                '}';
    }
}
