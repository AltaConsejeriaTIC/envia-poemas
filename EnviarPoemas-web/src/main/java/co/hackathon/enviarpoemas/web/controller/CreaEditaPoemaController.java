/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.web.controller;

import co.hackathon.enviarpoemas.dto.AutorDTO;
import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import co.hackathon.enviarpoemas.dto.PoemaDTO;
import co.hackathon.enviarpoemas.exceptions.BusinessException;
import co.hackathon.enviarpoemas.servicios.facade.AutorFacade;
import co.hackathon.enviarpoemas.servicios.facade.CategoriaPoemaFacade;
import co.hackathon.enviarpoemas.servicios.facade.PoemaFacade;
import co.hackathon.enviarpoemas.web.model.CreaEditaPoemaModel;
import co.hackathon.enviarpoemas.web.model.ListaPoemasModel;
import co.hackathon.enviarpoemas.web.util.FacesMessages;
import co.hackathon.enviarpoemas.web.util.FacesUtil;
import java.util.List;
import javax.ejb.EJB;
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

    public static final String INICIO = "/faces/index.xhtml";

    @ManagedProperty(value = "#{creaEditaPoemaModel}")
    private CreaEditaPoemaModel creaEditaPoemaModel;

    @ManagedProperty(value = "#{listaPoemasModel}")
    private ListaPoemasModel listaPoemasModel;

    @EJB private AutorFacade autorFacade;
    @EJB private PoemaFacade poemaFacade;
    @EJB private CategoriaPoemaFacade categoriaPoemaFacade;
    
    public void iniciarCreacion() {
        creaEditaPoemaModel.clean();
        creaEditaPoemaModel.setPoemaDTO(new PoemaDTO());
        creaEditaPoemaModel.getPoemaDTO().setAutorDTO(new AutorDTO());
        creaEditaPoemaModel.getPoemaDTO().setCategoriaPoemaDTO(new ListaBasicaDTO());
        creaEditaPoemaModel.setCategoriasDTO(categoriaPoemaFacade.consultaTodosDTO());
    }

    
    public void iniciarEdicion(Integer poemaId) {
        creaEditaPoemaModel.setCategoriasDTO(categoriaPoemaFacade.consultaTodosDTO());
    }

    public String crearOeditar() {
        try {
            if (creaEditaPoemaModel.getPoemaDTO().getPoemaId() != null) {
                poemaFacade.actualizarPoema(creaEditaPoemaModel.getPoemaDTO());
                FacesMessages.addInfo("El poema fue actualizado correctamente");
            } else {
                poemaFacade.crearPoema(creaEditaPoemaModel.getPoemaDTO());
                FacesMessages.addInfo("El poema fue creado correctamente");
            }
            creaEditaPoemaModel.clean();
            listaPoemasModel.clean();
            return FacesUtil.redirection(INICIO);
        } catch (BusinessException be) {
            FacesMessages.addError(be.getMessage());
        }
        return null;
    }

    public List<String> completarNombresAutor(String nombreAutor) {
        return autorFacade.consultaNombresPoetasSimilares(nombreAutor);
    }

    public void setCreaEditaPoemaModel(CreaEditaPoemaModel creaEditaPoemaModel) {
        this.creaEditaPoemaModel = creaEditaPoemaModel;
    }

    public void setListaPoemasModel(ListaPoemasModel listaPoemasModel) {
        this.listaPoemasModel = listaPoemasModel;
    }

}
