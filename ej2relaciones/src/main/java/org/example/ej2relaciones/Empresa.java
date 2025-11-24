package org.example.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "empresas")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nom;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL) // Cuando persista la empresa, persistiran también los empleados
    private List<Empleado> empleados;

    public Empresa() {
    }

    public Empresa(String nom) {
        this.nom = nom;
    }

    public Empresa(String nom, List<Empleado> empleados) {
        this.nom = nom;
        this.empleados = empleados;
    }

    public Long getId() {
        return id;
    }

/*    public void setId(Long id) {
        this.id = id;
    }*/

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
