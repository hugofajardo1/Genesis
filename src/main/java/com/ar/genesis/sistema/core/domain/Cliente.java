package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "clientes")
@SequenceGenerator(name = "seq_clientes", sequenceName = "seq_clientes", allocationSize = 1)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clientes")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 150)
    String nombre;
    @Column(name = "domicilio", nullable = false, length = 150)
    String domicilio;
    @Column(name = "telefono", nullable = false, length = 30)
    String telefono;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_ivaid")
    TipoIva tipoIva;

    @Column(name = "cuit", nullable = false, length = 11)
    String cuit;

    public Cliente() {
    }

    private Cliente(Integer id, String nombre, String domicilio, String telefono, TipoIva tipoIva, String cuit) {
        this.setId(id);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setTelefono(telefono);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
    }
    public static Cliente instancia(Integer id, String nombre, String domicilio, String telefono, TipoIva tipoIva, String cuit){
        return new Cliente(id, nombre, domicilio, telefono, tipoIva, cuit);
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoIva getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(TipoIva tipoIva) {
        this.tipoIva = tipoIva;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
}
