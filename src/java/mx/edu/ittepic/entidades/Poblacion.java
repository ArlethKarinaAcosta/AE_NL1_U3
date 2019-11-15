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
@Table(name = "poblacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Poblacion.findAll", query = "SELECT p FROM Poblacion p")
    , @NamedQuery(name = "Poblacion.findByIdpoblacion", query = "SELECT p FROM Poblacion p WHERE p.idpoblacion = :idpoblacion")
    , @NamedQuery(name = "Poblacion.findByNombrepoblacion", query = "SELECT p FROM Poblacion p WHERE p.nombrepoblacion = :nombrepoblacion")})
public class Poblacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpoblacion")
    private Integer idpoblacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombrepoblacion")
    private Serializable nombrepoblacion;

    public Poblacion() {
    }

    public Poblacion(Integer idpoblacion) {
        this.idpoblacion = idpoblacion;
    }

    public Poblacion(Integer idpoblacion, Serializable nombrepoblacion) {
        this.idpoblacion = idpoblacion;
        this.nombrepoblacion = nombrepoblacion;
    }

    public Integer getIdpoblacion() {
        return idpoblacion;
    }

    public void setIdpoblacion(Integer idpoblacion) {
        this.idpoblacion = idpoblacion;
    }

    public Serializable getNombrepoblacion() {
        return nombrepoblacion;
    }

    public void setNombrepoblacion(Serializable nombrepoblacion) {
        this.nombrepoblacion = nombrepoblacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpoblacion != null ? idpoblacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poblacion)) {
            return false;
        }
        Poblacion other = (Poblacion) object;
        if ((this.idpoblacion == null && other.idpoblacion != null) || (this.idpoblacion != null && !this.idpoblacion.equals(other.idpoblacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Poblacion[ idpoblacion=" + idpoblacion + " ]";
    }
    
}
