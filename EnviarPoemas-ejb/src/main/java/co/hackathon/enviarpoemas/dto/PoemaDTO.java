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
public class PoemaDTO implements Serializable{
    private Integer poemaId;
    private String texto;
    private String titulo;
    private AutorDTO autorDTO;
    private ListaBasicaDTO categoriaPoemaDTO;
    
    public Integer getPoemaId() {
        return poemaId;
    }

    public void setPoemaId(Integer poemaId) {
        this.poemaId = poemaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public AutorDTO getAutorDTO() {
        return autorDTO;
    }

    public void setAutorDTO(AutorDTO autorDTO) {
        this.autorDTO = autorDTO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ListaBasicaDTO getCategoriaPoemaDTO() {
        return categoriaPoemaDTO;
    }

    public void setCategoriaPoemaDTO(ListaBasicaDTO categoriaPoemaDTO) {
        this.categoriaPoemaDTO = categoriaPoemaDTO;
    }
    
    
}
