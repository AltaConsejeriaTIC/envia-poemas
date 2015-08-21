/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.servicios.facade.PoemaFacade;
import co.hackathon.enviarpoemas.web.model.DetallePoemaModel;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@RequestScoped
@ManagedBean
public class DetallePoemaController {

    @EJB
    private PoemaFacade poemaFacade;
    @ManagedProperty(value = "#{detallePoemaModel}")
    private DetallePoemaModel detallePoemaModel;
    private static final String INICIO = "/faces/index.xhtml";

    public void cargaDetalle(Integer id) {
        PoemaDTO poemaDetalle = poemaFacade.consultaDetallePoema(id);
        detallePoemaModel.setPoemaDTO(poemaDetalle);
    }

    public String irAIncio(){
        
        return FacesUtil.redirection(INICIO);
    }
    
    public void setDetallePoemaModel(DetallePoemaModel detallePoemaModel) {
        this.detallePoemaModel = detallePoemaModel;
    }
    
    
}
