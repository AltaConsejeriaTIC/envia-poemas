/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.dto;

import co.hackathon.enviarpoemas.constantes.RolEnum;
import java.util.List;

/**
 *
 * @author aatm
 */
public class UsuarioDTO extends PersonaDTO {

    private Integer usuarioId;
    private List<RolDTO> roles;
    private String clave;
    private String claveConfirmar;

    public UsuarioDTO() {
    }

    /**
     * NamedQuery : - Usuario.buscaXCorreoYclave
     *
     * @param usuarioId
     * @param correo
     * @param nombre
     */
    public UsuarioDTO(Integer usuarioId, String correo, String nombre) {
        this.usuarioId = usuarioId;
        setCorreoElectronico(correo);
        setNombre(nombre);
    }

    public boolean tieneRolAdministrador() {
        if (getRoles() != null) {
            for (RolDTO rolDTO : getRoles()) {
                if (rolDTO.getRolID().equals(RolEnum.ADMINISTRADOR.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<RolDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDTO> roles) {
        this.roles = roles;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveConfirmar() {
        return claveConfirmar;
    }

    public void setClaveConfirmar(String claveConfirmar) {
        this.claveConfirmar = claveConfirmar;
    }

}
