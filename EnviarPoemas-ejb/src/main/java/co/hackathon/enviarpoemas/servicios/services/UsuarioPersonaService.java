/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.services;

import co.hackathon.enviarpoemas.constantes.CodigosErrorEnum;
import co.hackathon.enviarpoemas.constantes.RolEnum;
import co.hackathon.enviarpoemas.dto.MensajeRespuesta;
import co.hackathon.enviarpoemas.dto.PersonaDTO;
import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.modelo.Persona;
import co.hackathon.enviarpoemas.servicios.modelo.Rol;
import co.hackathon.enviarpoemas.servicios.modelo.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author aatm
 */
@Stateless
@LocalBean
public class UsuarioPersonaService {
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    public static Usuario convierteUsuarioDTOaEntidad(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setClave(usuarioDTO.getClave());
        usuario.setNombreLogin(usuarioDTO.getCorreoElectronico());
        return usuario;
    }    
    
    public void validaCrearUsuario(UsuarioDTO usuarioDTO) throws BusinessException{
        //valida correo
        Long cantidadXcorreo = em.createNamedQuery("Usuario.cuentaPorCorreo", Long.class)
                .setParameter("correo", usuarioDTO.getCorreoElectronico())
                .getSingleResult();
        if(cantidadXcorreo > 0){
            throw new BusinessException(new MensajeRespuesta(CodigosErrorEnum.CORREO_EXISTENTE.name(), 
                                        "Correo ya registrado, usa la opción recordar clave"));
        }
    }
    
    public void crearUsuarioYPersona(UsuarioDTO usuarioDTO){
        Usuario usuario = UsuarioPersonaService.convierteUsuarioDTOaEntidad(usuarioDTO);
        usuario.setRolCollection(new ArrayList<Rol>(1));
        usuario.getRolCollection().add(em.getReference(Rol.class, RolEnum.USUARIO.getId()));
        em.persist(usuario);
        Persona persona = conviertePersonaDTOaEntidad(usuarioDTO);
        em.persist(persona);
    }
    
    
    
    public static Persona conviertePersonaDTOaEntidad(PersonaDTO personaDTO){
        Persona persona = new Persona();
        persona.setCorreoElectronico(personaDTO.getCorreoElectronico());
        persona.setNombre(personaDTO.getNombre());
        return persona;
    }
}
