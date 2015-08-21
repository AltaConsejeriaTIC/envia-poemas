/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.servicios.facade.PoemaFacade;
import co.hackathon.enviarpoemas.web.model.ListaPoemasModel;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import javax.ejb.EJB;
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

    @ManagedProperty(value = "#{creaEditaPoemaController}")
    private CreaEditaPoemaController creaEditaPoemaController;    
    @EJB private PoemaFacade poemaFacade;
    
    @ManagedProperty(value = "#{detallePoemaController}")
    private DetallePoemaController detallePoemaController;
    
    private static final String CREAR_POEMA_URL = "/faces/administrador/creaOeditaPoema.xhtml";
    private static final String DETALLE_POEMA_URL = "/faces/detallepoema.xhtml";

    public void buscarPoemas(){
        listaPoemasModel.setListaPoemas(poemaFacade.buscaPoemaTipoGoogle(listaPoemasModel.getTextoBusqueda()));
    } 
    
    public String crearPoema(){
        
        creaEditaPoemaController.iniciarCreacion();
        return FacesUtil.redirection(CREAR_POEMA_URL);
    }
    
    public String verDetalle(){
        detallePoemaController.cargaDetalle(listaPoemasModel.getPoemaActual().getPoemaId());
        return FacesUtil.redirection(DETALLE_POEMA_URL);
    }
    
    public void setListaPoemasModel(ListaPoemasModel listaPoemasModel) {
        this.listaPoemasModel = listaPoemasModel;
    }

    public void setCreaEditaPoemaController(CreaEditaPoemaController creaEditaPoemaController) {
        this.creaEditaPoemaController = creaEditaPoemaController;
    }    

    public void setDetallePoemaController(DetallePoemaController detallePoemaController) {
        this.detallePoemaController = detallePoemaController;
    }
    
    
}
