package com.ar.genesis.sistema.usuario.core.domain;

import com.ar.genesis.sistema.sucursal.core.domain.Sucursal;

import javax.persistence.*;

@Entity(name = "usuarios")
@SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    String nombre;
    @Column(name = "nombreusuario", nullable = false, length = 50)
    String nombreUsuario;
    @Column(name = "contrasenia", nullable = false, length = 50)
    String contrasenia;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sucursalid")
    Sucursal sucursal;

    public Usuario() {
    }

    private Usuario(Integer id, String nombre, String nombreUsuario, String contrasenia, Sucursal sucursal) {
        this.setId(id);
        this.setNombre(nombre);
        this.setNombreUsuario(nombreUsuario);
        this.setContrasenia(contrasenia);
        this.setSucursal(sucursal);
    }
    public static Usuario instancia(Integer id, String nombre, String nombreusuario, String contrasenia, Sucursal sucursal){
        return new Usuario(id, nombre, nombreusuario, contrasenia, sucursal);
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

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
}