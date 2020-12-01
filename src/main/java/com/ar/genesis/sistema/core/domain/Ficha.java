package com.ar.genesis.sistema.core.domain;

import javax.persistence.*;

@Entity(name = "fichas")
@SequenceGenerator(name = "seq_fichas", sequenceName = "seq_fichas", allocationSize = 1)
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fichas")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 150)
    String nombre;
    @Column(name = "domicilio", nullable = false, length = 150)
    String domicilio;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "localidadid")
    Localidad localidad;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "provinciaid")
    Provincia provincia;
    @Column(name = "telefono", nullable = false, length = 30)
    String telefono;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tipo_ivaid")
    TipoIva tipoIva;
    @Column(name = "cuit", nullable = false, length = 11)
    String cuit;
    @Column(name = "ibrutos", nullable = false, length = 15)
    String ibrutos;
    @Column(name = "contacto", nullable = true, length = 255)
    String contacto;

    public Ficha() {
    }

    private Ficha(Integer id, String nombre, String domicilio, Localidad localidad, Provincia provincia, String telefono, TipoIva tipoIva, String cuit, String ibrutos, String contacto) {
        this.setId(id);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setLocalidad(localidad);
        this.setProvincia(provincia);
        this.setTelefono(telefono);
        this.setTipoIva(tipoIva);
        this.setCuit(cuit);
        this.setIbrutos(ibrutos);
        this.setContacto(contacto);
    }
    public static Ficha instancia(Integer id, String nombre, String domicilio, Localidad localidad, Provincia provincia, String telefono, TipoIva tipoIva, String cuit, String ibrutos, String contacto){
        return new Ficha(id, nombre, domicilio, localidad, provincia, telefono, tipoIva, cuit, ibrutos, contacto);
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

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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

    public String getIbrutos() {
        return ibrutos;
    }

    public void setIbrutos(String ibrutos) {
        this.ibrutos = ibrutos;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}
