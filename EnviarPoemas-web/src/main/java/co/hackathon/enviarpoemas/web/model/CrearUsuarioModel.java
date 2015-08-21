/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@ManagedBean
@RequestScoped
public class CrearUsuarioModel {
    
    private UsuarioDTO usuarioDTO = new UsuarioDTO();

    public CrearUsuarioModel() {
    }
    
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }
    
    

}
