package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_ivas")
@SequenceGenerator(name = "seq_tipo_ivas", sequenceName = "seq_tipo_ivas", allocationSize = 1)
public class TipoIva {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_ivas")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;
    
    public TipoIva() {
    }

    private TipoIva(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoIva instancia(Integer id, String nombre){
        return new TipoIva(id, nombre);
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