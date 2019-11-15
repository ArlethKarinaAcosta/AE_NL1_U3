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
@Table(name = "usuariotres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuariotres.findAll", query = "SELECT u FROM Usuariotres u")
    , @NamedQuery(name = "Usuariotres.findByIdusuario", query = "SELECT u FROM Usuariotres u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuariotres.findByNombreusuario", query = "SELECT u FROM Usuariotres u WHERE u.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Usuariotres.findByEmail", query = "SELECT u FROM Usuariotres u WHERE u.email = :email")
    , @NamedQuery(name = "Usuariotres.findByContrasena", query = "SELECT u FROM Usuariotres u WHERE u.contrasena = :contrasena")})
public class Usuariotres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 50)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "contrasena")
    private String contrasena;

    public Usuariotres() {
    }

    public Usuariotres(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuariotres)) {
            return false;
        }
        Usuariotres other = (Usuariotres) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.ittepic.entidades.Usuariotres[ idusuario=" + idusuario + " ]";
    }
    
}
