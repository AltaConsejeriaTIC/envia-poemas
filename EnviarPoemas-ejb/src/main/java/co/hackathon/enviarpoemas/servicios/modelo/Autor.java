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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aatm
 */
@Entity
@Table(name = "AUTOR")
@XmlRootElement
@NamedQueries({
    })
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTOR_ID")
    private Integer autorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOMBRE")
    private int nombre;
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "autorId")
    private Collection<Poema> poemaCollection;

    public Autor() {
    }

    public Autor(Integer autorId) {
        this.autorId = autorId;
    }

    public Autor(Integer autorId, int nombre) {
        this.autorId = autorId;
        this.nombre = nombre;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Poema> getPoemaCollection() {
        return poemaCollection;
    }

    public void setPoemaCollection(Collection<Poema> poemaCollection) {
        this.poemaCollection = poemaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorId != null ? autorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.autorId == null && other.autorId != null) || (this.autorId != null && !this.autorId.equals(other.autorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.hackathon.enviarpoemas.servicios.modelo.Autor[ autorId=" + autorId + " ]";
    }
    
}
