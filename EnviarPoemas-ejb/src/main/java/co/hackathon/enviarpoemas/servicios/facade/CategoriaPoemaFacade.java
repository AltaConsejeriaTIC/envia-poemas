/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import co.hackathon.enviarpoemas.servicios.modelo.CategoriaPoema;
import java.util.List;
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
public class CategoriaPoemaFacade implements InterfaceListaBasicaFacade{

    @PersistenceContext(unitName = "EnviarPoemasPU")
    protected EntityManager em;

    @Override
    public List<ListaBasicaDTO> consultaTodosDTO() {
        return em.createNamedQuery("CategoriaPoema.consultaTodosDTO", ListaBasicaDTO.class)
                .getResultList();
    }
    
    @Override
    public void creaOEdita(ListaBasicaDTO categoriaDTO){
        if(categoriaDTO.getListaBasicaID() != null){
            CategoriaPoema categoriaPoemaManejado = em.getReference(CategoriaPoema.class, categoriaDTO.getListaBasicaID());
            categoriaPoemaManejado.setNombre(categoriaDTO.getNombre());         
        }else{
            CategoriaPoema categoriaPoema = new CategoriaPoema(categoriaDTO.getNombre());
            em.persist(categoriaPoema);
        }
    }
}
