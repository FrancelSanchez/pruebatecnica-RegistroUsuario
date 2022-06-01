/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatecnica.registrousuario.services;

import com.pruebatecnica.registrousuario.services.UsuarioService;
import com.pruebatecnica.registrousuario.beans.Transacciones;
import com.pruebatecnica.registrousuario.beans.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francel Sanchez
 */
public class UsuarioServiceTest {
    
    public UsuarioServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsuarios method, of class UsuarioService.
     */
    @Test
    public void testGetUsuarios() {
        System.out.println("getUsuarios");
        UsuarioService instance = new UsuarioService();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.getUsuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTrans method, of class UsuarioService.
     */
    @Test
    public void testGetTrans() {
        System.out.println("getTrans");
        UsuarioService instance = new UsuarioService();
        List<Transacciones> expResult = null;
        List<Transacciones> result = instance.getTrans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of crearUsuarios method, of class UsuarioService.
     */
    @Test
    public void testCrearUsuarios() {
        System.out.println("crearUsuarios");
        String nombre = "";
        String apellido = "";
        String comentario = "";
        String hora = "";
        String hostname = "";
        UsuarioService instance = new UsuarioService();
        instance.crearUsuarios(nombre, apellido, comentario, hora, hostname);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of borrarUser method, of class UsuarioService.
     */
    @Test
    public void testBorrarUser() {
        System.out.println("borrarUser");
        int user = 0;
        UsuarioService instance = new UsuarioService();
        instance.borrarUser(user);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of buscarUsuarioById method, of class UsuarioService.
     */
    @Test
    public void testBuscarUsuarioById() {
        System.out.println("buscarUsuarioById");
        int id = 0;
        UsuarioService instance = new UsuarioService();
        Usuario expResult = null;
        Usuario result = instance.buscarUsuarioById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of editarUsuario method, of class UsuarioService.
     */
    @Test
    public void testEditarUsuario() {
        System.out.println("editarUsuario");
        int id = 0;
        String nombre = "";
        String apellido = "";
        String comentario = "";
        UsuarioService instance = new UsuarioService();
        Usuario expResult = null;
        Usuario result = instance.editarUsuario(id, nombre, apellido, comentario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
