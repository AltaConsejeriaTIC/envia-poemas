/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.constantes;

/**
 *
 * @author aatm
 */
public enum RolEnum {
    USUARIO(1),
    ADMINISTRADOR(2);

    private RolEnum(Integer id) {
        this.id = id;
    }
    
    private Integer id;

    public Integer getId() {
        return id;
    }
    
    
}
