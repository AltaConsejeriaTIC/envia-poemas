/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.web.model.ListaBasicaModel;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@RequestScoped
@ManagedBean
public class MenuController {
    
    public static final String ADMIN_LISTAS_BASICAS = "/faces/administrador/administrarListasBasicas.xhtml";    

           
    @ManagedProperty(value = "#{listaBasicaController}")
    private ListaBasicaController listaBasicaController;
    
    public String irAdministrarAutores(){
        listaBasicaController.iniciar(ListaBasicaModel.TipoListaBasica.AUTOR);
        return FacesUtil.redirection(ADMIN_LISTAS_BASICAS);
    }
    
    public String irAdministrarCategorias(){
        listaBasicaController.iniciar(ListaBasicaModel.TipoListaBasica.CATEGORIA_POEMA);
        return FacesUtil.redirection(ADMIN_LISTAS_BASICAS);
    }
    
    public String irAdministrarPoemas(){
        
        return FacesUtil.redirection(ADMIN_LISTAS_BASICAS);
    }

   

    public void setListaBasicaController(ListaBasicaController listaBasicaController) {
        this.listaBasicaController = listaBasicaController;
    }

    
}
