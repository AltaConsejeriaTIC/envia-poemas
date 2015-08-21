package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.constantes.CodigosErrorEnum;
import co.hackathon.enviarpoemas.dto.UsuarioDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.facade.LoginFacade;
import co.hackathon.enviarpoemas.servicios.facade.UsuarioFacade;
import co.hackathon.enviarpoemas.web.model.CrearUsuarioModel;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import co.hackathon.enviarpoemas.web.model.LoginModel;
import co.hackathon.enviarpoemas.web.util.FacesMessages;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aatm
 */
@ManagedBean
@RequestScoped
public class LoginController {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB private LoginFacade loginFacade; 
    
    @ManagedProperty(value = "#{loginModel}")
    private LoginModel loginModel;

    @ManagedProperty(value = "#{crearUsuarioModel}")
    private CrearUsuarioModel crearUsuarioModel;
    
    public static final String INICIO = "/faces/index.xhtml";
    
    public String crearUsuario() {
        try {
            usuarioFacade.crerUsuario(crearUsuarioModel.getUsuarioDTO());
            return FacesUtil.redirection(INICIO);
        } catch (BusinessException ex) {
            if(ex.getMensajeRespuesta().getCodigo().equals(CodigosErrorEnum.CORREO_EXISTENTE.name())){
                FacesMessages.addError("formcreausuario:correoId", ex.getMessage());                
            }else{
                FacesMessages.addError(ex.getMessage());
            }
        }catch(Exception e){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
            FacesMessages.addSystemError();
        }
        return null;
    }

    public String login(){
        try{
            UsuarioDTO usuarioDTO = loginFacade.login(loginModel.getUsuarioDTO());
            loginModel.setUsuarioDTO(usuarioDTO);
            return FacesUtil.redirection(INICIO);
        }catch(BusinessException be){
            FacesMessages.addError("formlogin:correoLogin", be.getMessage());
            FacesMessages.addError("formlogin:clave", be.getMessage());
        }catch(Exception e){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);            
        }
        return null;
    }
    
    public String cerrarSesion(){
        FacesUtil.getSession().invalidate();
        return FacesUtil.redirection(INICIO);
    }
    //<editor-fold defaultstate="collapsed" desc="set get">    
    public void setLoginModel(LoginModel loginModel) {
        this.loginModel = loginModel;
    }
    
    public void setCrearUsuarioModel(CrearUsuarioModel crearUsuarioModel) {
        this.crearUsuarioModel = crearUsuarioModel;
    }    

    //</editor-fold>

}
