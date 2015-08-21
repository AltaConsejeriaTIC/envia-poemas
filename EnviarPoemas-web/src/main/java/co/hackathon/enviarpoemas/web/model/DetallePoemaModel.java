/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aatm
 */
@ManagedBean
@SessionScoped
public class DetallePoemaModel implements Serializable{
    
    private PoemaDTO poemaDTO;

    public DetallePoemaModel() {
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
