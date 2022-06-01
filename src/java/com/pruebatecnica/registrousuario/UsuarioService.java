
package com.pruebatecnica.registrousuario;

import com.pruebatecnica.registrousuario.beans.Transacciones;
import com.pruebatecnica.registrousuario.beans.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

// Este es el web service para insertar, eliminar o actualizar registros en la lista usuarios
@Path("Usuario")
@RequestScoped
public class UsuarioService {
    
    //COMO NO SE DEBE CONECTAR A UNA BASE DE DATOS REAL UTILICE UNA LISTA DE OBJETO TIPO USUARIO PARA GUARDAR LOS REGISTROS.
   
    static final List<Usuario> listUsuario = new ArrayList<>();  // OBJETO LISTA TIPO USUARIO
     static final List<Transacciones> listTransacciones= new ArrayList<>();  // OBJETO LISTA TIPO USUARIO
    @Context
    private UriInfo context;
    public UsuarioService() {
    }

    @GET
    @Path("/getUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getUsuarios() { // METODO GET PARA OBTENER LA LISTA DE USUARIOS
  
    return listUsuario; // RETORNA UNA LISTA DE USUARIOS
    }
    
    @GET
    @Path("/getTransacciones")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transacciones> getTrans() { // METODO GET PARA OBTENER LA LISTA DE USUARIOS
  
    return listTransacciones; // RETORNA UNA LISTA DE USUARIOS
    }
    
    @Path("crearUsuarios")
    @POST 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void crearUsuarios(@PathParam("nombre") String nombre,@PathParam("apellido") String apellido, @PathParam("comentario") String comentario, @PathParam("hora") String hora, @PathParam("hostname") String hostname) {// METODO POST PARA CREAR USUARIOS NUEVOS
          Usuario usuarionew = new Usuario(); // OBJETO TIPO USUARIO PARA SETEAR LOS VALORES
        usuarionew.setNombre(nombre);
        usuarionew.setApellido(apellido);
        usuarionew.setComentario(comentario);        
         listUsuario.add(usuarionew); // AGREGARNO VALORES A LA LISTA
       
            Transacciones trans = new Transacciones(); // INSTANCIANDO LA LISTA PARA AGREGAR LA MAQUINA Y LA HORA DE LA INSERCION
            trans.setHora(hora);           
            trans.setMaquina(hostname);
            listTransacciones.add(trans);
            
         ;

    } 
    
    
    @Path("borrarUser")
    @DELETE 
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void borrarUser(int user) { // METODO PARA BORRAR LOS USUARIOS
       if(listUsuario.isEmpty() == false){ // VALIDO QUE LA LISTA NO ESTE VACIA PARA QUE NO DE ERROR AL MOMENTO DE INTENTAR BORRAR
             listUsuario.remove(user);// REMUEVE LOS USUARIOS DE LA LISTA
             listTransacciones.remove(user);// REMUEVE LOS REGISTROS DE LA LISTA TRANSACCIONES
        }
       

    } 
      
    
    @GET
    @Path("buscarUsuarioById")
    @Produces(MediaType.APPLICATION_JSON) 
    public Usuario buscarUsuarioById(int id) { //METODO GET PARA OBTENER USUARIOS POR EL ID, ESTE METODO ES USADO PARA PASAR LOS DATOS DEL USUARIO DEL INDEX A LA PAGINA DE EDITAR
       Usuario usuarioResp = new Usuario(); 
      //SETEO DEL OBJETO USUARIO MEDIANTE EL ID OBTENIDO DE LA LISTA
       usuarioResp.setNombre(listUsuario.get(id).getNombre());
       usuarioResp.setApellido(listUsuario.get(id).getApellido());
       usuarioResp.setComentario(listUsuario.get(id).getComentario());        
  
        return usuarioResp;
    }
    
    
    @PUT
    @Path("editarUsuario")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Usuario editarUsuario(@PathParam("id") int id, @PathParam("nombre") String nombre,@PathParam("apellido") String apellido, @PathParam("comentario") String comentario) { // METODO PARA EDITAR EL USUARIO
        Usuario usuarioResp = new Usuario();   
       usuarioResp.setNombre(nombre); 
       usuarioResp.setApellido(apellido); 
       usuarioResp.setComentario(comentario); 
        listUsuario.set(id, usuarioResp);
  
       return usuarioResp;
    }
    
    

    
    


   
}
