package com.ar.genesis.sistema.vendedor.core.domain;

import javax.persistence.*;

@Entity(name = "vendedores")
@SequenceGenerator(name = "seq_vendedores", sequenceName = "seq_vendedores", allocationSize = 1)
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vendedores")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Vendedor() {
    }

    private Vendedor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Vendedor instancia(Integer id, String nombre){
        return new Vendedor(id, nombre);
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