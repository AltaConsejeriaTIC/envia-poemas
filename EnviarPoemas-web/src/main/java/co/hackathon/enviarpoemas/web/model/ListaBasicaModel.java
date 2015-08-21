/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.model;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
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
public class ListaBasicaModel implements Serializable{
    
    private List<ListaBasicaDTO> listasBasicas;
    private ListaBasicaDTO listaBasicaSeleccionada;
    private ListaBasicaDTO listaBasicaEnEdicion = new ListaBasicaDTO();
    private TipoListaBasica tipoListaActual;
    private String nombreListaActual;        
    
    public enum TipoListaBasica{
        CATEGORIA_POEMA,
        AUTOR;
    }
    
    public void clean(){
        listasBasicas = null;
        listaBasicaSeleccionada = null;
        tipoListaActual = null;
    }

    public List<ListaBasicaDTO> getListasBasicas() {
        return listasBasicas;
    }

    public void setListasBasicas(List<ListaBasicaDTO> listasBasicas) {
        this.listasBasicas = listasBasicas;
    }

    public ListaBasicaDTO getListaBasicaSeleccionada() {
        return listaBasicaSeleccionada;
    }

    public void setListaBasicaSeleccionada(ListaBasicaDTO listaBasicaSeleccionada) {
        this.listaBasicaSeleccionada = listaBasicaSeleccionada;
    }

    public ListaBasicaDTO getListaBasicaEnEdicion() {
        return listaBasicaEnEdicion;
    }

    public void setListaBasicaEnEdicion(ListaBasicaDTO listaBasicaEnEdicion) {
        this.listaBasicaEnEdicion = listaBasicaEnEdicion;
    }

    public TipoListaBasica getTipoListaActual() {
        return tipoListaActual;
    }

    public void setTipoListaActual(TipoListaBasica tipoListaActual) {
        this.tipoListaActual = tipoListaActual;
        switch (tipoListaActual) {
            case AUTOR: nombreListaActual = "Autor";break; 
            case CATEGORIA_POEMA: nombreListaActual = "Categoria poema";break;
        }        
    }

    public String getNombreListaActual() {
        return nombreListaActual;
    }
    
}
