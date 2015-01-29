package astar;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Javan ArrayListin toimintoja simuloiva taulukko.
 *
 * @author Leo
 */
public class Lista<E> implements Iterable<E> {

    private int koko;
    private int taulukonKoko;
    private Object[] taulukko;

    public Lista() {
        taulukonKoko = 10;
        taulukko = new Object[taulukonKoko];
        koko = 0;
    }

    public int getKoko() {
        return koko;
    }

    public int getTaulukonKoko() {
        return taulukonKoko;
    }

    public E get(int i) {
        return (E) (taulukko[i]);
    }

    /**
     * Lisaa taulukkoon elementin ja kutsuu tarvittaessa kasvata taulukkoa
     * metodia.
     *
     * @param lisattava elementti
     */
    public void add(E lisattava) {
        if (this.koko == this.taulukonKoko) {
            kasvataTaulukkoa();
        }
        this.taulukko[koko] = lisattava;
        koko++;
    }

    /**
     * Kun taulukko tayttyy, metodi luo uuden kaksi kertaa suuremman taulukon ja
     * kopio vanhat elementit uuteen.
     *
     */
    public void kasvataTaulukkoa() {
        Object[] uusiTaulukko = new Object[taulukonKoko * 2];
        System.arraycopy(taulukko, 0, uusiTaulukko, 0, taulukonKoko);
        this.taulukko = uusiTaulukko;
        this.taulukonKoko = taulukonKoko * 2;
    }

    /**
     * Poistaa alkion listasta ja vahentaa sen jalkeen tulevien alkioden
     * indeksista muutoksen (1)
     *
     * @param i
     */
    public void poisto(int i) {
        int siirrot = koko - i - 1;
        koko--;
        if (siirrot > 0) {
            System.arraycopy(taulukko, i + 1, taulukko, i, siirrot);
        }
    }

    public boolean contains(Object o) {
        E otus;
        try {
            otus = (E) o;
        } catch (Exception e) {
            return false;
        }
        for (int i = 0; i < koko; i++) {
            if (((E) taulukko[i]).equals(otus)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return koko == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Osoitin();
    }

    public class Osoitin implements Iterator<E> {

        private int indeksi;
        private int viimeksiPalautettu;

        @Override
        public boolean hasNext() {
            return indeksi < koko;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) taulukko[viimeksiPalautettu = indeksi++];
        }

        @Override
        public void remove() {
            Lista.this.poisto(viimeksiPalautettu);
            indeksi = viimeksiPalautettu;
            viimeksiPalautettu = -1;
        }
    }
}
