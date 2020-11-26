package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "subrubros")
@SequenceGenerator(name = "seq_subrubros", sequenceName = "seq_subrubros", allocationSize = 1)
public class SubRubro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_subrubros")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public SubRubro() {
    }

    private SubRubro(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static SubRubro instancia(Integer id, String nombre){
        return new SubRubro(id, nombre);
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