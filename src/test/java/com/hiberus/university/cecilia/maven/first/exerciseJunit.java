package com.hiberus.university.cecilia.maven.first;

import org.junit.*;

public class exerciseJunit {

    @BeforeClass

    public static void setUpClass(){
        System.out.println("BEFORE CLASS");
    }
    @Before
    public void setUp(){
        System.out.println("BEFORE");
    }

    @Ignore
    @Test
    public void test1(){
        System.out.println("TEST IGNORADO");
    }

    @Test
    public void test2(){
        System.out.println("TEST2");
    }

    @Test
    public void test3(){
        System.out.println("TEST3");
    }

    @After
    public void tearDown(){
        System.out.println("AFTER");
    }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("AFTER CLASS");
    }
}
