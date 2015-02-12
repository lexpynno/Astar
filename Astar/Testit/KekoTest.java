package astar;

import static junit.framework.Assert.*;
import org.junit.*;

/**
 *
 * @author Leo
 */
public class KekoTest {

    private Keko keko;
    private Keko keko2;

    @Before
    public void setUp() {
        keko = new Keko<>(new Vertailija(new Piste(2, 2, null)));
        keko2 = new Keko(null);
    }

    @Test
    public void kekoToimiiPisteilla() {
        Piste alku = new Piste(0, 0, null);
        Piste keski = new Piste(1, 0, alku);
        Piste lahinMaalia = new Piste(1, 1, keski);
        Piste kauin = new Piste(5, 4, lahinMaalia);
        Piste maali = new Piste(2, 2, kauin);
        keko.add(alku);

        keko.add(lahinMaalia);        keko.add(keski);
        keko.add(kauin);
        keko.add(maali);
        assertEquals(maali, keko.poll());
        assertEquals(lahinMaalia, keko.poll());
        assertEquals(keski, keko.poll());
        assertEquals(alku, keko.poll());
        assertEquals(kauin, keko.poll());
        assertNull(keko.poll());
    }

    @Test
    public void kekoToimiiMiinusPisteilla() {
        Piste alku = new Piste(0, 0, null);
        Piste keski = new Piste(-1, 0, alku);
        Piste lahin = new Piste(1, 1, keski);
        Piste kauin = new Piste(-5, -4, lahin);
        Piste maali = new Piste(2, 2, kauin);
        keko.add(alku);
        keko.add(keski);
        keko.add(lahin);
        keko.add(kauin);
        keko.add(maali);
        assertEquals(maali, keko.poll());
        assertEquals(lahin, keko.poll());
        assertEquals(keski, keko.poll());
        assertEquals(alku, keko.poll());
        assertEquals(kauin, keko.poll());
        assertNull(keko.poll());
    }

    @Test
    public void kekoPollToimiiPisteella() {
        Piste p = new Piste(1, 2, null);
        keko.add(p);
        assertEquals(p, keko.poll());
    }

    @Test
    public void kekoPollToimiiIntegerilla() {
        int p = 1;
        keko2.add(p);
        assertEquals(p, keko2.poll());
    }

    @Test
    public void kekoPollToimiiStringilla() {
        String p = "Kekkonen";
        keko2.add(p);
        assertEquals(p, keko2.poll());
    }

    @Test
    public void isEmptyPalauttaaTrueKunKekoTyhja() {
        assertEquals(true, keko.isEmpty());
    }

    @Test
    public void isEmptyPalauttaaFalseKunKekossaAlkioita() {
        keko.add(this);
        assertEquals(false, keko.isEmpty());
    }
}
