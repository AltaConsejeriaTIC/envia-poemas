/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.web.model.CreaEditaPoemaModel;
import co.hackathon.enviarpoemas.web.model.ListaPoemasModel;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@ManagedBean
@RequestScoped
public class ListaPoemasController {
    
    @ManagedProperty(value ="#{listaPoemasModel}" )
    private ListaPoemasModel listaPoemasModel;

    @ManagedProperty(value = "#{creaEditaPoemaModel}")
    private CreaEditaPoemaModel creaEditaPoemaModel;

    private static final String CREAR_POEMA_URL = "faces/administrador/creaOeditaPoema.xhtml";
    
    public void buscarPoemas(){
        
    } 
    
    public String crearPoema(){
        creaEditaPoemaModel.clean();
        creaEditaPoemaModel.setPoemaDTO(new PoemaDTO());
        return FacesUtil.redirection(CREAR_POEMA_URL);
    }
    
    public void setListaPoemasModel(ListaPoemasModel listaPoemasModel) {
        this.listaPoemasModel = listaPoemasModel;
    }

    public void setCreaEditaPoemaModel(CreaEditaPoemaModel creaEditaPoemaModel) {
        this.creaEditaPoemaModel = creaEditaPoemaModel;
    }
    
    
}
