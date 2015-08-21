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

    public PoemaDTO() {
    }

    
    /**
     * NamedQuery:
     * - Poema.consultaPoemaDTOTipoGoogle
     * @param poemaId
     * @param titulo
     * @param nombreAutor 
     */
    public PoemaDTO(Integer poemaId, String titulo, String nombreAutor) {
        this.poemaId = poemaId;
        this.titulo = titulo;
        this.autorDTO = new AutorDTO();
        this.autorDTO.setNombreAutor(nombreAutor);
    }

    /**
     * NamedQuery:
     * -Poema.consultaDetallePoemaDTOXid
     * @return 
     */
    public PoemaDTO(Integer poemaId, String texto, String titulo, 
            Integer autorId, String nombreAutor, 
            Integer categoriaPoemaId, String nombreCategoria) {
        this.poemaId = poemaId;
        this.texto = texto;
        this.titulo = titulo;
        this.setAutorDTO(new AutorDTO(autorId, nombreAutor));
        this.setCategoriaPoemaDTO(new ListaBasicaDTO(categoriaPoemaId, nombreCategoria));
    }
    
    
    
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
