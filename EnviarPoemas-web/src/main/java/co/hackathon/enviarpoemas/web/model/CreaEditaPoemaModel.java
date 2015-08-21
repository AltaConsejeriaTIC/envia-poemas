/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@ManagedBean
@RequestScoped
public class CreaEditaPoemaModel {
    
    private PoemaDTO poemaDTO;

    public CreaEditaPoemaModel() {
    }
        
    public void clean(){
        poemaDTO = null;
    }

    public PoemaDTO getPoemaDTO() {
        return poemaDTO;
    }

    public void setPoemaDTO(PoemaDTO poemaDTO) {
        this.poemaDTO = poemaDTO;
    }
    
    
}
