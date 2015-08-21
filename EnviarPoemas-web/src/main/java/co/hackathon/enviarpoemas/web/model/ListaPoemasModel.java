/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.PoemaDTO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author aatm
 */
@SessionScoped
@ManagedBean
public class ListaPoemasModel{
    private List<PoemaDTO> listaPoemas;
    private PoemaDTO poemaActual;
    private String textoBusqueda;

    public ListaPoemasModel() {
    }

    public void clean(){
        listaPoemas = null;
        poemaActual = null;
        textoBusqueda = null;
    }
    
    public List<PoemaDTO> getListaPoemas() {
        return listaPoemas;
    }

    public void setListaPoemas(List<PoemaDTO> listaPoemas) {
        this.listaPoemas = listaPoemas;
    }

    public PoemaDTO getPoemaActual() {
        return poemaActual;
    }

    public void setPoemaActual(PoemaDTO poemaActual) {
        this.poemaActual = poemaActual;
    }

    public String getTextoBusqueda() {
        return textoBusqueda;
    }

    public void setTextoBusqueda(String textoBusqueda) {
        this.textoBusqueda = textoBusqueda;
    }
    
    
    
}
