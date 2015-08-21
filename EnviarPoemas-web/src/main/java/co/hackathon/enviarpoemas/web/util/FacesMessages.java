/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author aatm
 */
public class FacesMessages {
    
    public static void addError(String mensaje) {
        addMessage(null, FacesMessage.SEVERITY_ERROR, mensaje);
    }
    
    public static void addError(String id, String mensaje) {
        addMessage(id, FacesMessage.SEVERITY_ERROR, mensaje);
    }

    public static void addMessage(String id, FacesMessage.Severity severity, String mensaje) {
        FacesMessage fm = new FacesMessage(severity, mensaje, mensaje);
        FacesContext.getCurrentInstance().addMessage(id, fm);
    }
    
    public static void addSystemError() {
        addError("Ha ocurrido un error inesperado, porfavor comuniquese con el administrador del sistema");
    }
    
}
