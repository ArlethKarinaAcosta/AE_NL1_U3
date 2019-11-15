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
@Table(name = "duda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duda.findAll", query = "SELECT d FROM Duda d")
    , @NamedQuery(name = "Duda.findByIdduda", query = "SELECT d FROM Duda d WHERE d.idduda = :idduda")
    , @NamedQuery(name = "Duda.findByPregunta", query = "SELECT d FROM Duda d WHERE d.pregunta = :pregunta")
    , @NamedQuery(name = "Duda.findByComentario", query = "SELECT d FROM Duda d WHERE d.comentario = :comentario")})
public class Duda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idduda")
    private Integer idduda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pregunta")
    private Serializable pregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentario")
    private Serializable comentario;

    public Duda() {
    }

    public Duda(Integer idduda) {
        this.idduda = idduda;
    }

    public Duda(Integer idduda, Serializable pregunta, Serializable comentario) {
        this.idduda = idduda;
        this.pregunta = pregunta;
        this.comentario = comentario;
    }

    public Integer getIdduda() {
        return idduda;
    }

    public void setIdduda(Integer idduda) {
        this.idduda = idduda;
    }

    public Serializable getPregunta() {
        return pregunta;
    }

    public void setPregunta(Serializable pregunta) {
        this.pregunta = pregunta;
    }

    public Serializable getComentario() {
        return comentario;
    }

    public void setComentario(Serializable comentario) {
        this.comentario = comentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idduda != null ? idduda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duda)) {
            return false;
        }
        Duda other = (Duda) object;
        if ((this.idduda == null && other.idduda != null) || (this.idduda != null && !this.idduda.equals(other.idduda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Duda[ idduda=" + idduda + " ]";
    }
    
}
