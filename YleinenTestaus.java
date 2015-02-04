
package astar;

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
public class YleinenTestaus {

    AstarAlgoritmi a;
    Piste p;

    public YleinenTestaus() {
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
        p = a.Astar(new Piste(10, 10, null), new Piste(-20, 40, null));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void AstarinLuontiEiTyhja() {
        assertNotNull(p);
    }

    @Test
    public void tunnistaaPisteenSamaksi() {
        Piste piste = new Piste(1, 4, null);
        assertEquals(piste, new Piste(1, 4, null));
    }

    @Test
    public void ajoToimii() {
        assertEquals(p, a.Astar(new Piste(10, 10, null), new Piste(-20, 40, null)));
    }

    @Test
    public void naapuriPisteetHalutunlaiset() {
        Lista naapurit = new Lista(p.Naapurit());
        assertEquals(new Piste(p.getX() + 1, p.getY(), p), naapurit.get(0));
        assertEquals(new Piste(p.getX(), p.getY() - 1, p), naapurit.get(1));
        assertEquals(new Piste(p.getX() + 1, p.getY() + 1, p), naapurit.get(2));
        assertEquals(new Piste(p.getX() - 1, p.getY(), p), naapurit.get(3));

    }
}
