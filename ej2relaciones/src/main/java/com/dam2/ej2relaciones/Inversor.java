package com.dam2.ej2relaciones;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inversores")
public class Inversor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @ManyToMany
    @JoinTable(name = "empresas_inversores", joinColumns = @JoinColumn(name = "id_inversor"), inverseJoinColumns = @JoinColumn(name = "id_empresa"))
    private List<Empresa> empresas;

    public Inversor() {
    }

    public Inversor(String nombre) {
        this.nombre = nombre;
        empresas = new ArrayList<>();
    }

    public Inversor(String nombre, List<Empresa> empresas) {
        this.nombre = nombre;
        this.empresas = empresas;
    }

    public Long getId() {
        return id;
    }

/*    public void setId(Long id) {
        this.id = id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    @Override
    public String toString() {
        return "Inversor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empresas=" + empresas +
                '}';
    }
}
