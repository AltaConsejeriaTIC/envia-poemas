/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import co.hackathon.enviarpoemas.dto.PoemaDTO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aatm
 */
@ManagedBean
@SessionScoped
public class CreaEditaPoemaModel implements Serializable{
    
    private PoemaDTO poemaDTO;
    private List<ListaBasicaDTO> categoriasDTO;
    
    public CreaEditaPoemaModel() {
    }
        
    public void clean(){
        poemaDTO = null;
        categoriasDTO = null;
    }

    public PoemaDTO getPoemaDTO() {
        return poemaDTO;
    }

    public void setPoemaDTO(PoemaDTO poemaDTO) {
        this.poemaDTO = poemaDTO;
    }

    public List<ListaBasicaDTO> getCategoriasDTO() {
        return categoriasDTO;
    }

    public void setCategoriasDTO(List<ListaBasicaDTO> categoriasDTO) {
        this.categoriasDTO = categoriasDTO;
    }
    
    
}
