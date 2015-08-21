package co.hackathon.enviarpoemas.web.model;



import co.hackathon.enviarpoemas.constantes.RolEnum;
import co.hackathon.enviarpoemas.dto.RolDTO;
import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aatm
 */
@ManagedBean
@SessionScoped
public class LoginModel implements Serializable{
    
    private UsuarioDTO usuarioDTO = new UsuarioDTO();

    public void clean(){
        usuarioDTO = null;
    }
    
    public boolean hayUsuarioLogeado(){
        return usuarioDTO != null && usuarioDTO.getUsuarioId() != null;
    }
    
    public boolean esAdministrador(){
        if(hayUsuarioLogeado()){
            return usuarioDTO.tieneRolAdministrador();
        }
        return false;
    }
    
    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
        this.usuarioDTO = usuarioDTO;
    }    
    
}
