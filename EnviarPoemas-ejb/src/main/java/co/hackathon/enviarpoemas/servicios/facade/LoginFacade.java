/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.services.LoginService;
import co.hackathon.enviarpoemas.servicios.services.UsuarioPersonaService;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aatm
 */
@Stateless
@LocalBean
public class LoginFacade{
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    private @EJB LoginService loginService;

    public UsuarioDTO login(UsuarioDTO usuarioDTO) throws BusinessException {
        return loginService.login(usuarioDTO);
    }
    
    
}
