/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arlet
 */
@Entity
@Table(name = "entidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidad.findAll", query = "SELECT e FROM Entidad e")
    , @NamedQuery(name = "Entidad.findByIdentidad", query = "SELECT e FROM Entidad e WHERE e.identidad = :identidad")
    , @NamedQuery(name = "Entidad.findByEntidad", query = "SELECT e FROM Entidad e WHERE e.entidad = :entidad")})
public class Entidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identidad")
    private Integer identidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entidad")
    private Serializable entidad;

    public Entidad() {
    }

    public Entidad(Integer identidad) {
        this.identidad = identidad;
    }

    public Entidad(Integer identidad, Serializable entidad) {
        this.identidad = identidad;
        this.entidad = entidad;
    }

    public Integer getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    public Serializable getEntidad() {
        return entidad;
    }

    public void setEntidad(Serializable entidad) {
        this.entidad = entidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identidad != null ? identidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entidad)) {
            return false;
        }
        Entidad other = (Entidad) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Entidad[ identidad=" + identidad + " ]";
    }
    
}
