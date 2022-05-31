<%-- 
    Document   : index
    Created on : May 30, 2022, 6:13:53 PM
    Author     : Francel Sanchez
--%>
<%@page import="com.pruebatecnica.registrousuario.beans.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.pruebatecnica.registrousuario.UsuarioService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
       <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <div class="container mt-4">
                <div clas="card">
                    <div class="card-header">
                        <a href="Controlador?accion=add"  class="btn btn-primary"> Agregar Usuario</a>
                    </div>
                    </div>
                </div>
        
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                         <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Comentario</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        UsuarioService userR = new UsuarioService();
                        List<Usuario> datos =userR.getUsuarios();
                       int index;
                        for(Usuario u:datos){
                             index = datos.indexOf(u);
                     %>
                    <tr>
                        <td><%= index %></td>
                        <td><%= u.getNombre()%></td>
                        <td><%= u.getApellido()%></td>
                        <td><%= u.getComentario()%></td>
                        <td>
                            <a href="Controlador?accion=editar&id=<%= index %>" class="btn btn-warning">Editar</a>
                            <a href="Controlador?accion=delete&id=<%= index %>" class="btn btn-danger">Delete <%
                                
                            %> 
                            </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>      

    </body>
</html>
