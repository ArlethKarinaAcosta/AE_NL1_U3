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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arlet
 */
@Entity
@Table(name = "entidaddos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidaddos.findAll", query = "SELECT e FROM Entidaddos e")
    , @NamedQuery(name = "Entidaddos.findByIdentidad", query = "SELECT e FROM Entidaddos e WHERE e.identidad = :identidad")
    , @NamedQuery(name = "Entidaddos.findByNombreentidad", query = "SELECT e FROM Entidaddos e WHERE e.nombreentidad = :nombreentidad")})
public class Entidaddos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identidad")
    private Integer identidad;
    @Size(max = 30)
    @Column(name = "nombreentidad")
    private String nombreentidad;

    public Entidaddos() {
    }

    public Entidaddos(Integer identidad) {
        this.identidad = identidad;
    }

    public Integer getIdentidad() {
        return identidad;
    }

    public void setIdentidad(Integer identidad) {
        this.identidad = identidad;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
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
        if (!(object instanceof Entidaddos)) {
            return false;
        }
        Entidaddos other = (Entidaddos) object;
        if ((this.identidad == null && other.identidad != null) || (this.identidad != null && !this.identidad.equals(other.identidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Entidaddos[ identidad=" + identidad + " ]";
    }
    
}
