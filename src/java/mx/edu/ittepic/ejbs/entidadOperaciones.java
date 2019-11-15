/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.Query;
import mx.edu.ittepic.entidades.Entidaddos;
import mx.edu.ittepic.entidades.Usuariotres;
/**
 *
 * @author arlet
 */
@Stateless
public class entidadOperaciones implements entidadOperacionesRemote {
     @PersistenceContext
    EntityManager em;
     
      public String nuevoUsuario (String nombreusuario, String email, String contrasena)
    {
        Usuariotres r = new Usuariotres();
        r.setNombreusuario(nombreusuario);
        r.setEmail(email);
        r.setContrasena(contrasena);
        
        String msj;
        
        try
        {
            em.persist(r);
            
            msj = "{\"code\":200, \"msj\"La operacion se realizo correctamente\"}";
            
        } catch (Exception e)
        {
            msj = "{\"code\":400, \"msj\"Error en los tipos de parametros\"}";
        }
        return msj;
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
