/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.services;

import co.hackathon.enviarpoemas.constantes.CodigosErrorEnum;
import co.hackathon.enviarpoemas.dto.MensajeRespuesta;
import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.facade.AutorFacade;
import co.hackathon.enviarpoemas.servicios.modelo.Autor;
import co.hackathon.enviarpoemas.servicios.modelo.CategoriaPoema;
import co.hackathon.enviarpoemas.servicios.modelo.Poema;
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
public class PoemaService {
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
        @EJB private AutorFacade autorFacade;

    public void definirValoresYValidarPoema(PoemaDTO poemaDTO) throws BusinessException{
        Integer autorId = autorFacade.consultaAutorXNombre(poemaDTO.getAutorDTO().getNombreAutor());        
        poemaDTO.getAutorDTO().setAutorId(autorId);
        if(autorId == null){
            throw new BusinessException(new MensajeRespuesta(CodigosErrorEnum.AUTOR_NO_EXISTE.name(), "No es posible encontrar el autor"));
        }
        
    }
    
    public void copiaPropiedadesDeDTOaEntidad(PoemaDTO poemaDTO, Poema p) {
        Autor autor = em.getReference(Autor.class, poemaDTO.getAutorDTO().getAutorId());
        CategoriaPoema cp = em.getReference(CategoriaPoema.class, poemaDTO.getCategoriaPoemaDTO().getListaBasicaID());
        p.setAutorId(autor);
        p.setCategoriaId(cp);
        p.setTexto(poemaDTO.getTexto());
        p.setTitulo(poemaDTO.getTitulo());
    }
}
