package com.ar.genesis.sistema.permisousuario.core.domain;

import com.ar.genesis.sistema.permiso.core.domain.Permiso;
import com.ar.genesis.sistema.usuario.core.domain.Usuario;

import javax.persistence.*;

@Entity(name = "permisosusuarios")
@SequenceGenerator(name = "seq_permisosusuarios", sequenceName = "seq_permisosusuarios", allocationSize = 1)
public class PermisoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_permisosusuarios")
    Integer id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "permisoid")
    Permiso permiso;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuarioid")
    Usuario usuario;

    public PermisoUsuario() {
    }

    private PermisoUsuario(Integer id, Permiso permiso, Usuario usuario) {
        this.setId(id);
        this.setPermiso(permiso);
        this.setUsuario(usuario);
    }

    public static PermisoUsuario instancia(Integer id, Permiso permiso, Usuario usuario){
        return new PermisoUsuario(id, permiso, usuario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
