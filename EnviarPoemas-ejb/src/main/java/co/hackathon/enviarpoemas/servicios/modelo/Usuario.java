/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aatm
 */
@Entity
@Table(name = "\"USUARIO\"")
@NamedQueries({
    @NamedQuery( name = "Usuario.cuentaPorCorreo", 
            query = "select count(u) from Usuario u where u.nombreLogin = :correo"),
    @NamedQuery( name = "Usuario.buscaXCorreoYclave", 
            query = "select new co.hackathon.enviarpoemas.dto.UsuarioDTO("
                    + " u.usuarioId, u.nombreLogin, p.nombre)"
                    + " from Usuario u, Persona p "
                    + " where u.nombreLogin = :correo"
                    + " and u.clave = :clave"
                    + " and u.nombreLogin = p.correoElectronico ")
})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @SequenceGenerator(
        name="USUARIO_SEQUENCE_GENERATOR",
        sequenceName="\"SEQ_USUARIO\"",
        allocationSize=1
    )
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_SEQUENCE_GENERATOR")    
    @Column(name = "\"USUARIO_ID\"")
    private Integer usuarioId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "\"NOMBRE_LOGIN\"")
    private String nombreLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "\"CLAVE\"")
    private String clave;
    @ManyToMany(mappedBy = "usuarioCollection")
    private Collection<Rol> rolCollection;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Usuario(Integer usuarioId, String nombreLogin, String clave) {
        this.usuarioId = usuarioId;
        this.nombreLogin = nombreLogin;
        this.clave = clave;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreLogin() {
        return nombreLogin;
    }

    public void setNombreLogin(String nombreLogin) {
        this.nombreLogin = nombreLogin;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.hackathon.enviarpoemas.servicios.modelo.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
