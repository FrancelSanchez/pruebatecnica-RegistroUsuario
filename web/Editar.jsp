<%-- 
    Document   : Editar
    Created on : May 31, 2022, 12:55:35 PM
    Author     : Francel Sanchez
--%>

<%@page import="com.pruebatecnica.registrousuario.beans.Usuario"%>
<%@page import="com.pruebatecnica.registrousuario.UsuarioService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
                <div clas="card">
                    <div class="card-header">
                        <h5>Editar Usuario</h5>
                    </div>
                    <%
                    int id = Integer.parseInt((String)request.getAttribute("iduser"));
                    
                    UsuarioService user = new UsuarioService();
                    Usuario u = user.buscarUsuarioById(id);
                    
                    %>
                    </div>             
        
        <div class="card-body">
        <form action="Controlador">
            <label>Id</label>
               <input type="text" value="<%= id%>" name="iduser" readonly="" class="form-control">
            <label>Nombre</label>
            <input type="text" value="<%= u.getNombre()%>" name="textnom" class="form-control" required>
             <label>Apellido</label>
            <input type="text" value="<%= u.getApellido()%>" name="textap" class="form-control" required>
            <label>Comentario</label>
            <input type="text" value="<%= u.getComentario()%>"  name="textcomentario" class="form-control">
            <input type="submit" name="accion" value="Actualizar">
            <a href="Controlador?accion=index">Regresar</a>
          </form>
            </div>  
            </div>
    </body>
</html>