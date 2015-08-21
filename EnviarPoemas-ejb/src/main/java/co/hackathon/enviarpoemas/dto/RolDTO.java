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
public class RolDTO {
    private Integer rolID;

    public RolDTO(Integer rolID) {
        this.rolID = rolID;
    }

    
    public Integer getRolID() {
        return rolID;
    }

    public void setRolID(Integer rolID) {
        this.rolID = rolID;
    }      
}
