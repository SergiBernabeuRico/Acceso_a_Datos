package org.example;

import jakarta.persistence.*;

import java.io.Serializable;

    /**
     * Entidad Disco.
     * Se mapea a la tabla "discos" de la base datos
     */
    @Entity                 // Esta clase es es una entidad JPA
    @Table(name = "discos") // Nombre de la tabla
    public class Disco implements Serializable{

        // Campo id: será la clave primaria de la tabla.
        @Id                                                 // Marca este campo como PRIMARY KEY
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor autoincremental
        @Column(name = "id")                                // Nombre de la columna en la tabla
        private long id;

        // Campo nombre del disco
        @Column (name = "nom")
        private String nom;

        // Campo nombre del artista/grupo
        @Column(name = "autor")
        private String autor;

        // Constructor vacío, hibernate necesita crear objetos sin parámetros
        public Disco(){

        }

        // Constructor con parámetros para crear Discos desde el código AppDisco
        public Disco(String nom, String autor){
            this.nom = nom;
            this.autor = autor;
        }

        // SETTERS Y GETTERS
        public Long getId(){
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getNom(){
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getAutor(){
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String toString(){
            return "Disco{id = " + id + ", nombre = " + nom + ", autor = " + autor;
        }
    }

