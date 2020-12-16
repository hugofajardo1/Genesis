package com.ar.genesis.sistema.proveedor.core.domain;

import javax.persistence.*;

@Entity(name = "proveedores")
@SequenceGenerator(name = "seq_proveedores", sequenceName = "seq_proveedores", allocationSize = 1)
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proveedores")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public Proveedor() {
    }

    private Proveedor(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static Proveedor instancia(Integer id, String nombre){
        return new Proveedor(id, nombre);
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