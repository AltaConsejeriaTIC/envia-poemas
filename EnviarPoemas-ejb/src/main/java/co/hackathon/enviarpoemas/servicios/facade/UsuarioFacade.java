/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.services.UsuarioPersonaService;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author aatm
 */
@Stateless
@LocalBean
public class UsuarioFacade {
    private @EJB UsuarioPersonaService usuarioPersonaService;
    
    public void crerUsuario(UsuarioDTO usuarioDTO) throws BusinessException{
        usuarioPersonaService.validaCrearUsuario(usuarioDTO);
        usuarioPersonaService.crearUsuarioYPersona(usuarioDTO);        
    }
}
