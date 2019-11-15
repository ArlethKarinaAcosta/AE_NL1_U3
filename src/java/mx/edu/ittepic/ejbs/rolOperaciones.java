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
import mx.edu.ittepic.entidades.Roldos;

/**
 *
 * @author arlet
 */
@Stateless
public class rolOperaciones{
    @PersistenceContext
    EntityManager em;
    
    public String nuevoRol(String nombrerol)
    {
        Roldos r = new Roldos();
        r.setNombrerol(nombrerol);
        
        
        String msj;
        
        try
        {
            em.persist(r);
            
 msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";            
        } catch (Exception e)
        {
            msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
        }
        return msj;
        
    }
    
    public String consultaRol()
    {
        try
        {
             Query q;
            List<Roldos> listaRol;
            q=em.createNamedQuery("Roldos.findAll");
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
    
    public String eliminarRol(int idrol)
   {
      
       Roldos duda = new Roldos();
       String msj;
       
       try {
          duda = (Roldos) em.createNamedQuery("Roldos.findByIdrol").setParameter("idrol", idrol).getSingleResult();
          em.remove(em.merge(duda));
          
           
 msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
       } catch (NumberFormatException e)
       {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
       }
       return msj;
       
   
   }
    
    public String actualizarRol(int idrol, String nombrerol)
   {
       GsonBuilder builder = new GsonBuilder();
       Gson gson = builder.create();
       String msj;
       Roldos rol = new Roldos();
       
       try {
          rol = em.find(Roldos.class, idrol);
          rol.setNombrerol(nombrerol);
          
           
 msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
       } catch (NumberFormatException e)
       {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
       }
       return msj;
       
   
   }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
