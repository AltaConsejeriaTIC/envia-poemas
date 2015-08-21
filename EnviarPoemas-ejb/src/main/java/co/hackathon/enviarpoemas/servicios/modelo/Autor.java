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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aatm
 */
@Entity
@Table(name = "\"AUTOR\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.consultaTodosDTO",
            query = "select new co.hackathon.enviarpoemas.dto.ListaBasicaDTO(a.autorId, a.nombre)"
            + " from Autor a "),
    @NamedQuery(name = "Autor.consultaNombresPoetasXnombreSimilar",
            query = "select a.nombre from Autor a where lower(a.nombre) like lower(:nombreAutor) "),
    @NamedQuery(name = "Autor.consultaIdXnombre",
            query = "select a.autorId from Autor a where lower(a.nombre) = lower(:nombreAutor) ")

})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @SequenceGenerator(
            name = "AUTOR_SEQUENCE_GENERATOR",
            sequenceName = "\"SEQ_AUTOR\"",
            allocationSize = 1
    )

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTOR_SEQUENCE_GENERATOR")
    @Id
    @Column(name = "\"AUTOR_ID\"")
    private Integer autorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"NOMBRE\"")
    private String nombre;
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "autorId")
    private Collection<Poema> poemaCollection;

    public Autor() {
    }

    public Autor(Integer autorId) {
        this.autorId = autorId;
    }

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    public Autor(Integer autorId, String nombre) {
        this.autorId = autorId;
        this.nombre = nombre;
    }

    public Integer getAutorId() {
        return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
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
