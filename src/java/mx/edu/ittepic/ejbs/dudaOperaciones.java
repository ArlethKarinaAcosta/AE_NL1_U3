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
import mx.edu.ittepic.entidades.Dudados;

/**
 *
 * @author arlet
 */
@Stateless
public class dudaOperaciones {

    @PersistenceContext
    EntityManager em;
    
   public String nuevoDuda (String pregunta, String comentario)
    {
        Dudados r = new Dudados();
        r.setPregunta(pregunta);
        r.setComentario(comentario);
        
        
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
   
   public String consultaDuda()
    {
        try
        {
             Query q;
            List<Dudados> listaRol;
            q=em.createNamedQuery("Dudados.findAll");
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
   
   public String eliminarDuda(int idduda)
   {
      
       Dudados duda = new Dudados();
       String msj;
       
       try {
          duda = (Dudados) em.createNamedQuery("Dudados.findByIdduda").setParameter("idduda", idduda).getSingleResult();
          em.remove(em.merge(duda));
          
           
  msj = "{\"code\":200, \"msj\":\"La operacion se realizo correctamente\"}";
       } catch (NumberFormatException e)
       {
msj = "{\"code\":400, \"msj\":\"Error en los tipos de parametros\"}";
       }
       return msj;
       
   
   }
   
   public String actualizarDuda(int idduda, String pregunta, String comentario)
   {
       GsonBuilder builder = new GsonBuilder();
       Gson gson = builder.create();
       String msj;
       Dudados duda = new Dudados();
       
       try {
          duda = em.find(Dudados.class, idduda);
          duda.setPregunta(pregunta);
          duda.setComentario(comentario);
          
           
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
