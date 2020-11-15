package com.ar.genesis.sistema.core.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "tipo_clientes")
@SequenceGenerator(name = "seq_TipoCliente", sequenceName = "seq_TipoCliente", allocationSize = 1)
public class TipoCliente {
    @Id
    @GeneratedValue
    Integer id;
    String nombre;
    public TipoCliente() {
    }

    private TipoCliente(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoCliente instancia(Integer id, String nombre){
        return new TipoCliente(id, nombre);
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
