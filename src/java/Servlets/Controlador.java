/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import com.pruebatecnica.registrousuario.UsuarioService;
import com.pruebatecnica.registrousuario.beans.Transacciones;
import com.pruebatecnica.registrousuario.beans.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    String add ="AgregarUsuario.jsp";
    String editar ="Editar.jsp";
    String index= "index.jsp";
    String acceso=""; // VARIABLE PARA DETERMINAR HACIA DONDE DEBE ENVIAR EL DISPACHER CUANDO SE EJECUTA UNA FUNCION
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if(accion.equals("add")){ // CUANDO EL USUARIO PULSA EL BOTON DE AGREGAR USUARIO EN EL INDEX ESTE REALIZA ESTA VALIDACION PARA ENVIARLO A LA PAGINA DE AGREGAR USUARIO
            acceso = add;
            
                
        }else if(accion.equals("Guardar")){ // CUANDO EL USUARIO PULSA EL BOTON DE GUARDAR DESDE LA PAGINA PARA AGREGAR USUARIOS ESTE CONTROLADOR ES EL QUE CAPTURA LA INFORMACION PARA ENVIARLA AL SERVICIO WEB
      
          DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");         
            UsuarioService userservice = new UsuarioService(); // INSTNACIANDO EL OBJETO DEL WEB SERVICE             
            userservice.crearUsuarios(request.getParameter("textnom"),request.getParameter("textap"),request.getParameter("textcomentario"),dtf2.format(LocalDateTime.now()),request.getParameter("hostname")); // EJECUANDO EL METODO CREAR USUARIO DENTRO DEL WEB SERVICE
            acceso = index;
        }
        else if(accion.equals("Actualizar")){ // CUANDO EL USUARIO PULSA EL BOTON DE ACTUALIZAR ESTE CONTROLADOR ES QUIEN ENVIA LA INFORMACION HACIA EL METODO EN EL WEB SERVICE PARA ACTUALIZAR EL REGISTRO
            int id = Integer.parseInt(request.getParameter("iduser"));
            UsuarioService userservice = new UsuarioService();        
            userservice.editarUsuario(id,request.getParameter("textnom"),request.getParameter("textap"),request.getParameter("textcomentario"));
            acceso = index;
        }
        else if(accion.equals("editar")){// CUANDO SE PULSA EL BOTON EDITAR DENTRO DE LA LISTA DE USUARIO ESTA VALIDACION ES PARA REDIRECCIONAR  A LA PAGINA DE EDITAR
            acceso = editar;            
            request.setAttribute("iduser", request.getParameter("id")); // PASANDO EL INDEX DE LA LISTA PARA PODER BUSCAR ESE REGISTRO UNICO DENTRO DE LA LISTA DE USUARIO Y PODER EDITARLO
        }else if(accion.equals("index")){ // REDIRECCIONANDO EL INDEX
            acceso = index;
        }else if(accion.equals("delete")){ // SE PULSA EL BOTON DELETE ESTA VALIDACION ENVIA LOS PARAMETROS AL WEB SERVICE        
            int id = Integer.parseInt(request.getParameter("id")); // OBTENIENDO EL INDEX DE LA LISTA USUARIOS
            UsuarioService userservice = new UsuarioService(); // INSTANCIANDO EL OBJETO USUARIO
            userservice.borrarUser(id); // ENVIANDO A BORRAR EL USUARIO
            acceso = index;
            
                
        }  
        RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
