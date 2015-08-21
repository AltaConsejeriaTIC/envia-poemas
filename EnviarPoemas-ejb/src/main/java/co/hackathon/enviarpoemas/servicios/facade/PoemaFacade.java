/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.modelo.Poema;
import co.hackathon.enviarpoemas.servicios.services.PoemaService;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aatm
 */
@Stateless
@LocalBean
public class PoemaFacade {
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    @EJB private PoemaService poemaService;
    
    public void crearPoema(PoemaDTO poemaDTO) throws BusinessException{        
        poemaService.definirValoresYValidarPoema(poemaDTO);
        Poema p = new Poema();
        poemaService.copiaPropiedadesDeDTOaEntidad(poemaDTO, p);
        em.persist(p);        
    }

    public void actualizarPoema(PoemaDTO poemaDTO) throws BusinessException{
        poemaService.definirValoresYValidarPoema(poemaDTO);
        Poema p = em.getReference(Poema.class, poemaDTO.getPoemaId());
        poemaService.copiaPropiedadesDeDTOaEntidad(poemaDTO, p);        
    }
    
    public void eliminaPoema(PoemaDTO poemaDTO){        
        em.remove(new Poema(poemaDTO.getPoemaId()));
    }
    /**
     * Crea la entidad dado el DTO, sin embargo solo copia las propiedades de primernivel.
     * @param poemaDTO
     * @return 
     */
    public static Poema convierteDTOaEntity(PoemaDTO poemaDTO){
        Poema p = new Poema();
        p.setTexto(poemaDTO.getTexto());
        p.setTitulo(poemaDTO.getTitulo());
        return p;
    }
}
