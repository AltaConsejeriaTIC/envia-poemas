/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.facade;

import co.hackathon.enviarpoemas.dto.ListaBasicaDTO;
import java.util.List;

/**
 *
 * @author aatm
 */
public interface InterfaceListaBasicaFacade {

    public List<ListaBasicaDTO> consultaTodosDTO();

    public void creaOEdita(ListaBasicaDTO listaBasicaDTO);

}
