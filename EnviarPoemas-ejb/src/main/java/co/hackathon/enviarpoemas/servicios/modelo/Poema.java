/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.hackathon.enviarpoemas.servicios.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aatm
 */
@Entity
@Table(name = "\"POEMA\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poema.consultaPoemaDTOTipoGoogle", 
            query = "select new co.hackathon.enviarpoemas.dto.PoemaDTO(p.poemaId, p.titulo, a.nombre) "
                    + "from Poema p join p.autorId a join p.categoriaId c "
                    + " where lower(p.titulo) like lower(:texto) "
                    + "or lower(p.texto) like lower(:texto) "
                    + " or lower(a.nombre) like lower(:texto) "
                    + " or lower(c.nombre) like lower(:texto) "),
    @NamedQuery(name = "Poema.consultaDetallePoemaDTOXid", 
            query = "select new co.hackathon.enviarpoemas.dto.PoemaDTO(p.poemaId, p.titulo, p.texto, "
                    + "a.autorId, a.nombre, c.categoriaId, c.nombre)"
                    + "from Poema p join p.autorId a join p.categoriaId c "
                    + "where p.poemaId = :poemaID")
    

})
public class Poema implements Serializable {
    private static final long serialVersionUID = 1L;
    @SequenceGenerator(
        name="POEMA_SEQUENCE_GENERATOR",
        sequenceName="\"SEQ_POEMA\"",
        allocationSize=1)
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POEMA_SEQUENCE_GENERATOR")     
    @Column(name = "\"POEMA_ID\"")
    private Integer poemaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "\"TEXTO\"")
    private String texto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "\"TITULO\"")
    private String titulo;
    @JoinColumn(name = "\"AUTOR_ID\"", referencedColumnName = "\"AUTOR_ID\"")
    @ManyToOne(optional = false)
    private Autor autorId;
    @JoinColumn(name = "\"CATEGORIA_ID\"", referencedColumnName = "\"CATEGORIA_ID\"")
    @ManyToOne(optional = false)
    private CategoriaPoema categoriaId;

    public Poema() {
    }

    public Poema(Integer poemaId) {
        this.poemaId = poemaId;
    }

    public Poema(Integer poemaId, String texto, String titulo) {
        this.poemaId = poemaId;
        this.texto = texto;
        this.titulo = titulo;
    }

    public Integer getPoemaId() {
        return poemaId;
    }

    public void setPoemaId(Integer poemaId) {
        this.poemaId = poemaId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public void setAutorId(Autor autorId) {
        this.autorId = autorId;
    }

    public CategoriaPoema getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaPoema categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poemaId != null ? poemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poema)) {
            return false;
        }
        Poema other = (Poema) object;
        if ((this.poemaId == null && other.poemaId != null) || (this.poemaId != null && !this.poemaId.equals(other.poemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.hackathon.enviarpoemas.servicios.modelo.Poema[ poemaId=" + poemaId + " ]";
    }
    
}
