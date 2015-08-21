/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import co.hackathon.enviarpoemas.servicios.facade.AutorFacade;
import co.hackathon.enviarpoemas.servicios.facade.CategoriaPoemaFacade;
import co.hackathon.enviarpoemas.servicios.facade.InterfaceListaBasicaFacade;
import co.hackathon.enviarpoemas.web.model.ListaBasicaModel;
import co.hackathon.enviarpoemas.web.util.FacesMessages;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author aatm
 */
@ManagedBean
@RequestScoped
public class ListaBasicaController {
    
    @ManagedProperty(value = "#{listaBasicaModel}")
    private ListaBasicaModel listaBasicaModel;
    @EJB private CategoriaPoemaFacade categoriaPoemaFacade;
    @EJB private AutorFacade autorFacade;
    
    public void iniciar(ListaBasicaModel.TipoListaBasica tipoListaBasica) {
        listaBasicaModel.clean();
        listaBasicaModel.setTipoListaActual(tipoListaBasica);
        listaBasicaModel.setListasBasicas(contruyeFacade().consultaTodosDTO());

    }
    
    private InterfaceListaBasicaFacade contruyeFacade(){
        switch(listaBasicaModel.getTipoListaActual()){
            case AUTOR: return autorFacade;
            case CATEGORIA_POEMA: return categoriaPoemaFacade;
        }
        return null;
    }

      public void creaOedita() {
        contruyeFacade().creaOEdita(listaBasicaModel.getListaBasicaEnEdicion());
        if(listaBasicaModel.getListaBasicaEnEdicion().getListaBasicaID() != null){
            FacesMessages.addInfo("Se ha actualizado exitosamente");
        }else{
            FacesMessages.addInfo("Ha sido creado exitosamente");
        }
        iniciar(listaBasicaModel.getTipoListaActual());
                
    }

    public void crearNuevo() {
        listaBasicaModel.setListaBasicaEnEdicion(new ListaBasicaDTO());
        RequestContext.getCurrentInstance().update("form:popupListaBasicaId");        
        RequestContext.getCurrentInstance().execute("PF('popupListaBasica').show()");
    }

    public void editarSeleccionado() {
        ListaBasicaDTO listaBasicaActual = listaBasicaModel.getListaBasicaSeleccionada();
        listaBasicaModel.setListaBasicaEnEdicion(new ListaBasicaDTO(listaBasicaActual.getListaBasicaID(), listaBasicaActual.getNombre()));     
        RequestContext.getCurrentInstance().update("form:popupListaBasicaId");        
        RequestContext.getCurrentInstance().execute("PF('popupListaBasica').show()");
    }

    
    
    public void setListaBasicaModel(ListaBasicaModel listaBasicaModel) {
        this.listaBasicaModel = listaBasicaModel;
    }    
    
}
