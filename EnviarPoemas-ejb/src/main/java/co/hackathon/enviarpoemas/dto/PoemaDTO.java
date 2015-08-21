/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.dto;

/**
 *
 * @author aatm
 */
public class PoemaDTO {
    private Integer poemaId;
    private String texto;

    public Integer getPoemaId() {
        return poemaId;
    }

    public void setPoemaId(Integer poemaId) {
        this.poemaId = poemaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
}
