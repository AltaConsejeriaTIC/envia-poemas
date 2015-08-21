/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.services;

import co.hackathon.enviarpoemas.dto.AutorDTO;
import co.hackathon.enviarpoemas.servicios.modelo.Autor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aatm
 */
public class AutorService {
    @PersistenceContext(unitName="EnviarPoemasPU") 
    protected EntityManager em;
    
    public static Autor convierteDTOaEntity(AutorDTO autorDTO){
        return new Autor(autorDTO.getAutorId(), autorDTO.getNombreAutor());        
    }
}
