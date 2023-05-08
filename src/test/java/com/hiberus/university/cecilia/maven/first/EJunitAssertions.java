package com.hiberus.university.cecilia.maven.first;

import org.junit.*;

public class EJunitAssertions {

    @BeforeClass

    public static void setUpClass(){

    }
    @Before
    public void setUp(){

    }


    @Test
    public void testAssertArraysEquals(){
        String[] nombresEsperados = {"java", "junit", "jboss"};
        String[] nombresActuales = {"java", "junit", "jboss"};

        Assert.assertArrayEquals("Error - no son los mismos arrays", nombresEsperados, nombresActuales);

    }

    @Test
    public void testSum(){
        Assert.assertEquals("Error, el resultado es incorrecto: ", (1 +1), 2);

    }
    @Test
    public void testAssertFalse(){
        Assert.assertFalse(false);

    }

    @After
    public void tearDown(){

    }

    @AfterClass
    public static void tearDownClass(){

    }
}
