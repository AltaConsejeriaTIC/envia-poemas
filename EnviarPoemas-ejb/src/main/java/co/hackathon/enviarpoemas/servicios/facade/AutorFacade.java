/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import co.hackathon.enviarpoemas.servicios.modelo.Autor;
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
@LocalBean
@Stateless
public class AutorFacade implements InterfaceListaBasicaFacade{
    
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    @Override
    public List<ListaBasicaDTO> consultaTodosDTO(){
        return em.createNamedQuery("Autor.consultaTodosDTO", ListaBasicaDTO.class)
                .getResultList();
    }
    
    @Override
    public void creaOEdita(ListaBasicaDTO autorDTO){
        if(autorDTO.getListaBasicaID() != null){
            Autor aManejado = em.getReference(Autor.class, autorDTO.getListaBasicaID());
            aManejado.setNombre(autorDTO.getNombre());         
        }else{
            Autor autor = new Autor(autorDTO.getNombre());
            em.persist(autor);
        }
    }
    
    public List<String> consultaNombresPoetasSimilares(String nombrePoeta){
        return em.createNamedQuery("Autor.consultaNombresPoetasXnombreSimilar", String.class)
                .setParameter("nombreAutor", "%" + nombrePoeta + "%")
                .getResultList();
    }
    
    public Integer consultaAutorXNombre(String nombre){
        try{
        return em.createNamedQuery("Autor.consultaIdXnombre", Integer.class)
                .setParameter("nombreAutor", nombre)
                .getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
    }
}
