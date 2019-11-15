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
@Table(name = "dudados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dudados.findAll", query = "SELECT d FROM Dudados d")
    , @NamedQuery(name = "Dudados.findByIdduda", query = "SELECT d FROM Dudados d WHERE d.idduda = :idduda")
    , @NamedQuery(name = "Dudados.findByPregunta", query = "SELECT d FROM Dudados d WHERE d.pregunta = :pregunta")
    , @NamedQuery(name = "Dudados.findByComentario", query = "SELECT d FROM Dudados d WHERE d.comentario = :comentario")})
public class Dudados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idduda")
    private Integer idduda;
    @Size(max = 50)
    @Column(name = "pregunta")
    private String pregunta;
    @Size(max = 100)
    @Column(name = "comentario")
    private String comentario;

    public Dudados() {
    }

    public Dudados(Integer idduda) {
        this.idduda = idduda;
    }

    public Integer getIdduda() {
        return idduda;
    }

    public void setIdduda(Integer idduda) {
        this.idduda = idduda;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
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
        if (!(object instanceof Dudados)) {
            return false;
        }
        Dudados other = (Dudados) object;
        if ((this.idduda == null && other.idduda != null) || (this.idduda != null && !this.idduda.equals(other.idduda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Dudados[ idduda=" + idduda + " ]";
    }
    
}
