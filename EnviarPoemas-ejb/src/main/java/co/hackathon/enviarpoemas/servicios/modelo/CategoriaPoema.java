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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aatm
 */
@Entity
@Table(name = "CATEGORIA_POEMA")
@XmlRootElement
@NamedQueries({
    })
public class CategoriaPoema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORIA_ID")
    private Integer categoriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoriaId")
    private Collection<Poema> poemaCollection;

    public CategoriaPoema() {
    }

    public CategoriaPoema(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public CategoriaPoema(Integer categoriaId, String nombre) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
        hash += (categoriaId != null ? categoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPoema)) {
            return false;
        }
        CategoriaPoema other = (CategoriaPoema) object;
        if ((this.categoriaId == null && other.categoriaId != null) || (this.categoriaId != null && !this.categoriaId.equals(other.categoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.hackathon.enviarpoemas.servicios.modelo.CategoriaPoema[ categoriaId=" + categoriaId + " ]";
    }
    
}
