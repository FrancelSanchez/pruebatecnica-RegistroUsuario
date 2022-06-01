<%-- 
    Document   : PruebaTecnica
    Created on : May 30, 2022, 7:39:39 PM
    Author     : Francel Sanchez
--%>

<%@page import="java.net.UnknownHostException"%>
<%@page import="java.net.InetAddress"%>
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
                        <h5>Agregar nuevo Usuario</h5>
                    </div>
                 <%
                  String hostname = "Unknown";
                    
                  try
                    {
                        InetAddress addr;
                        addr = InetAddress.getLocalHost();
                        hostname = addr.getHostName();
                        
                    }
                    catch (UnknownHostException ex)
                    {
                        System.out.println("Hostname can not be resolved");
                    }
                 %>
                    </div>             
        
        <div class="card-body">
        <form action="Controlador">
            <label>Nombre</label>
            <input type="text" name="textnom" class="form-control" required>
             <label>Apellido</label>
            <input type="text" name="textap" class="form-control" required>
            <label>Comentario</label>
            <input type="text" name="textcomentario" class="form-control">
            <input type="text" name="hostname"  value="<%= hostname%>" hidden="" class="form-control">
            <input type="submit" name="accion" value="Guardar">
 
            <a href="Controlador?accion=index">Regresar</a>
          </form>
            </div>  
            </div>
    </body>
</html>
