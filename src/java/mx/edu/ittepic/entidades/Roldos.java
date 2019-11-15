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
@Table(name = "roldos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roldos.findAll", query = "SELECT r FROM Roldos r")
    , @NamedQuery(name = "Roldos.findByIdrol", query = "SELECT r FROM Roldos r WHERE r.idrol = :idrol")
    , @NamedQuery(name = "Roldos.findByNombrerol", query = "SELECT r FROM Roldos r WHERE r.nombrerol = :nombrerol")})
public class Roldos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol")
    private Integer idrol;
    @Size(max = 30)
    @Column(name = "nombrerol")
    private String nombrerol;

    public Roldos() {
    }

    public Roldos(Integer idrol) {
        this.idrol = idrol;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombrerol() {
        return nombrerol;
    }

    public void setNombrerol(String nombrerol) {
        this.nombrerol = nombrerol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrol != null ? idrol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roldos)) {
            return false;
        }
        Roldos other = (Roldos) object;
        if ((this.idrol == null && other.idrol != null) || (this.idrol != null && !this.idrol.equals(other.idrol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Roldos[ idrol=" + idrol + " ]";
    }
    
}
