/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabdemo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ahmed
 */
public class MyDispatcherTest {
    
    public MyDispatcherTest() {
        System.out.println("MyDispatcherTest()");
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
     * Test of showTime method, of class MyDispatcher.
     */
    @Test
    public void testShowTime() {
        System.out.println("showTime");
       
    }

    /**
     * Test of showDate method, of class MyDispatcher.
     */
    @Test
    public void testShowDate() {
        System.out.println("showDate");

    }

    /**
     * Test of main method, of class MyDispatcher.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MyDispatcher.main(args);

    }
    
}
