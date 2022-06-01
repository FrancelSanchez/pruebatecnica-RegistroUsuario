/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebatecnica.registrousuario.beans;

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
public class TransaccionesTest {
    
    public TransaccionesTest() {
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
     * Test of getMaquina method, of class Transacciones.
     */
    @Test
    public void testGetMaquina() {
        System.out.println("getMaquina");
        Transacciones instance = new Transacciones();
        String expResult = "";
        String result = instance.getMaquina();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaquina method, of class Transacciones.
     */
    @Test
    public void testSetMaquina() {
        System.out.println("setMaquina");
        String maquina = "";
        Transacciones instance = new Transacciones();
        instance.setMaquina(maquina);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class Transacciones.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        Transacciones instance = new Transacciones();
        String expResult = "";
        String result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class Transacciones.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        String hora = "";
        Transacciones instance = new Transacciones();
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
