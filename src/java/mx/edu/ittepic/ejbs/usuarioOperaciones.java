/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.ejbs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.Query;
import mx.edu.ittepic.entidades.Usuariotres;

/**
 *
 * @author arlet
 */
@Stateless
public class usuarioOperaciones {
    
    
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
            
msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";            
        } catch (Exception e)
        {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";        }
        return msj;
        
    }
    
    public String consultaUsuario()
    {
        try
        {
             Query q;
            List<Usuariotres> listaRol;
            q=em.createNamedQuery("Usuariotres.findAll");
            listaRol=q.getResultList(); //Ejecutar consulta.
            
            //Convertir la lista a objetos JSON
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.toJson(listaRol);
            
        } catch(Exception e)
        {
           return "{msg:'Error'}";
         
        }
    } //fin consultaRol
    
     public String eliminarUsuario(int idusuario)
   {
      
       Usuariotres usuario = new Usuariotres();
       String msj;
       
       try {
          usuario = (Usuariotres) em.createNamedQuery("Usuariotres.findByIdusuario").setParameter("idusuario", idusuario).getSingleResult();
          em.remove(em.merge(usuario));
          
           
msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
       } catch (NumberFormatException e)
       {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
       }
       return msj;
       
   
   }
     
     public String actualizarUsuario(int idusuario, String nombreusuario, String email, String contrasena)
   {
       GsonBuilder builder = new GsonBuilder();
       Gson gson = builder.create();
       String msj;
       Usuariotres usuario = new Usuariotres();
       
       try {
          usuario = em.find(Usuariotres.class, idusuario);
          usuario.setNombreusuario(nombreusuario);
          usuario.setEmail(email);
          usuario.setContrasena(contrasena);
          em.merge(usuario);
           
msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
       } catch (NumberFormatException e)
       {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
       }
       return msj;
       
   
   }
    
    
    
}