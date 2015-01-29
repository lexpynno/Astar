/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import astar.AstarAlgoritmi;
import astar.Piste;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author Leo
 */
public class Testaus {

    AstarAlgoritmi a;
    Piste p;

    public Testaus() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        a = new AstarAlgoritmi();
//        p = a.Astar(new Piste(10, 10, null), new Piste(-20, 40, null));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testaa() {
        assertNotNull(p);
    }

    @Test
    public void blaah() {
        Piste piste = new Piste(1, 4, null);
        assertEquals(piste, new Piste(1, 4, null));
    }

    @Test
    public void ajo() {
        assertEquals(p, a.Astar(new Piste(10, 10, null), new Piste(-20, 40, null)));
    }
}
