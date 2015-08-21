/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.services;

import co.hackathon.enviarpoemas.dto.RolDTO;
import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import java.util.ArrayList;
import java.util.List;
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
public class LoginService {
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    
    public UsuarioDTO login(UsuarioDTO usuarioDTO) throws BusinessException {
        try{
        UsuarioDTO usuarioExistenteDTO = em.createNamedQuery("Usuario.buscaXCorreoYclave", UsuarioDTO.class)
                .setParameter("correo", usuarioDTO.getCorreoElectronico())
                .setParameter("clave", usuarioDTO.getClave())
                .getSingleResult();
            List<Integer> rolesId = em.createNamedQuery("Rol.consultarIdsXUsuarioId", Integer.class)
                    .setParameter("usuarioId", usuarioExistenteDTO.getUsuarioId())
                    .getResultList();
            List<RolDTO> rolesDTO = new ArrayList<>(rolesId.size());
            for(Integer idRol : rolesId){
                rolesDTO.add(new RolDTO(idRol));
            }
            usuarioExistenteDTO.setRoles(rolesDTO);
            return usuarioExistenteDTO;
        }catch(NoResultException nre){
            throw new BusinessException("No es posible iniciar sesión");
        }
    }
    
}
