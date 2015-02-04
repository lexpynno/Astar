package astar;

import java.util.Iterator;
import static junit.framework.Assert.*;
import org.junit.*;

/**
 *
 * @author Leo
 */
public class ListaTest {

    private Lista<String> lista;
    private Lista<Object> lista2;

    @Before
    public void setUp() {
        lista = new Lista<>();
        lista2 = new Lista<>();
    }

    @Test
    public void kokoOnAlussaNolla() {
        assertEquals(0, lista.getKoko());
    }

    @Test
    public void listaOnTyhjaAlussa() {
        assertTrue(lista.isEmpty());
    }

    @Test
    public void taulukonKokoOnAlussa10() {
        assertEquals(10, lista.getTaulukonKoko());
    }

    @Test
    public void alkioidenLisaaminenKasvattaaListanKokoa() {
        lista.add("Uolevi");
        assertEquals(1, lista.getKoko());
        lista.add("Kalevi");
        assertEquals(2, lista.getKoko());
        lista.add("Matti");
        assertEquals(3, lista.getKoko());
        lista.add("Maija");
        assertEquals(4, lista.getKoko());
        lista.add("Kukko");
        assertEquals(5, lista.getKoko());
        lista.add("Kana");
        assertEquals(6, lista.getKoko());
        lista.add("V");
        assertEquals(7, lista.getKoko());
        lista.add("A");
        assertEquals(8, lista.getKoko());
        lista.add("B");
        assertEquals(9, lista.getKoko());
        lista.add("C");
        assertEquals(10, lista.getKoko());
        lista.add("Jorma");
        assertEquals(11, lista.getKoko());
        lista.add("Putin");
        assertEquals(12, lista.getKoko());
    }

    @Test
    public void listastaSaadaanSinneLisatytAlkiot() {
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("D");
        lista.add("E");
        lista.add("F");
        lista.add("G");
        lista.add("H");
        lista.add("I");
        lista.add("J");
        lista.add("K");
        lista.add("Putin");
        lista.add("Jesse");
        lista.add("Jorma");
        assertEquals("A", lista.get(0));
        assertEquals("B", lista.get(1));
        assertEquals("Jorma", lista.get(lista.getKoko() - 1));
    }

    @Test
    public void listastaSaadaanSinneLisatytAlkiot2() {
        lista2.add(2);
        lista2.add(1);
        assertEquals(2, lista2.get(0));
        assertEquals(1, lista2.get(lista2.getKoko() - 1));
    }

    @Test
    public void poistaminenIndeksinMukaanPoistaaOikeanAlkion() {
        lista.add("A");
        lista.add("B");
        lista.add("C");
        lista.add("Putin");
        lista.poisto(1);
        assertEquals(3, lista.getKoko());
        assertEquals("A", lista.get(0));
        assertEquals("C", lista.get(1));
        assertEquals("Putin", lista.get(2));
    }

    @Test
    public void containsPalauttaaTrueJosListastaLoytyyAlkio() {
        lista.add("Putin");
        assertTrue(lista.contains("Putin"));
    }

    @Test
    public void containsPalauttaaFalseKunAlkiotaEiLoydy() {
        lista.add("Putin");
        assertFalse(lista.contains("Jorma"));
    }

    @Test
    public void listanAlkiotLoydytaanJarjestyksessa() {
        String[] alkiot = {"A", "B", "C"};
        for (int i = 0; i < alkiot.length; i++) {
            lista.add(alkiot[i]);
        }
        int i = 0;
        for (String testi : lista) {
            assertEquals(alkiot[i], testi);
            i++;
        }
    }

    @Test
    public void listanAlkiotLoydytaanJarjestyksessa2() {
        Integer[] alkiot = {3, 2, 1};
        for (int i = 0; i < alkiot.length; i++) {
            lista2.add(alkiot[i]);
        }
        int i = 0;
        for (String testi : lista) {
            assertEquals(alkiot[i], testi);
            i++;
        }
    }

    @Test
    public void osoitinPoistaaAlkion() {
        lista.add("A");
        lista.add("B");
        lista.add("C");
        Iterator<String> osoitin = lista.iterator();
        while (osoitin.hasNext()) {
            String nimi = osoitin.next();
            if (nimi.equals("B")) {
                osoitin.remove();
                break;
            }
        }
        assertEquals("C", osoitin.next());
        assertEquals(2, lista.getKoko());
        assertEquals("A", lista.get(0));
        assertEquals("C", lista.get(1));
    }
}
