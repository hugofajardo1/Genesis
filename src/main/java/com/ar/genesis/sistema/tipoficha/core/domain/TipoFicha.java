package com.ar.genesis.sistema.tipoficha.core.domain;

import javax.persistence.*;

@Entity(name = "tipo_fichas")
@SequenceGenerator(name = "seq_tipo_fichas", sequenceName = "seq_tipo_fichas", allocationSize = 1)
public class TipoFicha {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_fichas")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;

    public TipoFicha() {
    }

    private TipoFicha(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public static TipoFicha instancia(Integer id, String nombre){
        return new TipoFicha(id, nombre);
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