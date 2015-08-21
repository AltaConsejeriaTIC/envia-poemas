/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.exceptions;

import co.hackathon.enviarpoemas.dto.MensajeRespuesta;

/**
 *
 * @author aatm
 */
public class BusinessException extends Exception{

    private MensajeRespuesta mensajeRespuesta;
    
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(MensajeRespuesta mensajeRespuesta) {
        super(mensajeRespuesta.getMensaje());
        this.mensajeRespuesta = mensajeRespuesta;
    }

    
    public MensajeRespuesta getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(MensajeRespuesta mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }    
    
}
