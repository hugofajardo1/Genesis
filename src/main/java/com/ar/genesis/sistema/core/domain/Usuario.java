package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Usuario() {
    }

    private Usuario(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Usuario instancia(Integer id, String nombre){
        return new Usuario(id, nombre);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}