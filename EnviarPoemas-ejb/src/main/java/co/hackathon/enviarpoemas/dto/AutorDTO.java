/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.dto;

import java.io.Serializable;

/**
 *
 * @author aatm
 */
public class AutorDTO implements Serializable{
    
    private Integer autorId;
    private String nombreAutor;

    public AutorDTO() {
    }

    
    /**
     * NamedQuery:
     * - Autor.consultaTodosDTO
     * @param autorId
     * @param nombreAutor 
     */
    public AutorDTO(Integer autorId, String nombreAutor) {
        this.autorId = autorId;
        this.nombreAutor = nombreAutor;
    }

    
    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    
    
}
