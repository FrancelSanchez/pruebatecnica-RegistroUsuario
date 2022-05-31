/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatecnica.registrousuario.beans;

/**
 *
 * @author Francel Sanchez
 */
public class Usuario {
    

    private String nombre;
    private String apellido;
    private String comentario;

    public Usuario() {
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
     public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String descripcion) {
        this.comentario = descripcion;
    }
    
    
    
}
