package com.ar.genesis.sistema.permisousuario.service.dto;

import com.ar.genesis.sistema.permiso.service.dto.PermisoDTO;
import com.ar.genesis.sistema.usuario.service.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PermisoUsuarioDTO {

    @JsonProperty("id")
    Integer id;
    @JsonProperty("permisoid")
    PermisoDTO permiso;
    @JsonProperty("usuarioid")
    UsuarioDTO usuario;

    public PermisoUsuarioDTO(Integer id, PermisoDTO permiso, UsuarioDTO usuario) {
        this.setId(id);
        this.setPermiso(permiso);
        this.setUsuario(usuario);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PermisoDTO getPermiso() {
        return permiso;
    }

    public void setPermiso(PermisoDTO permiso) {
        this.permiso = permiso;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
}
