/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.dto;

import java.io.Serializable;

/**
 *
 * @author aatm
 */
public class ListaBasicaDTO implements Serializable{

    private Integer listaBasicaID;
    private String nombre;

    public ListaBasicaDTO() {
    }

    public ListaBasicaDTO(Integer listaBasicaID, String nombre) {
        this.listaBasicaID = listaBasicaID;
        this.nombre = nombre;
    }

    public Integer getListaBasicaID() {
        return listaBasicaID;
    }

    public void setListaBasicaID(Integer listaBasicaID) {
        this.listaBasicaID = listaBasicaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
