/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.web.model.CreaEditaPoemaModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aatm
 */
@RequestScoped
@ManagedBean
public class CreaEditaPoemaController {
   
    @ManagedProperty(value = "#{creaEditaPoemaModel}")
    private CreaEditaPoemaModel creaEditaPoemaModel;

    
    public void setCreaEditaPoemaModel(CreaEditaPoemaModel creaEditaPoemaModel) {
        this.creaEditaPoemaModel = creaEditaPoemaModel;
    }
    
    
    
}
