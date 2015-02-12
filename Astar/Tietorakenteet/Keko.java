package astar;

import java.util.Comparator;

/**
 * Itse rakennettu kekorakenne hakualgoritmia varten. Keko saa vertailijan ja
 * sisaltaa listan, joka on sen varsinainen sisainen rakenne.
 *
 * @author Leo
 */
public class Keko<E> {

    private int listanKoko;
    private int size;
    private final Comparator<? super E> vertailija;
    private Object[] lista;

    /**
     *
     * @param vertailija
     */
    public Keko(Comparator<? super E> vertailija) {
        this.vertailija = vertailija;
        this.listanKoko = 10;
        this.lista = new Object[listanKoko];
    }

    /**
     * Palauttaa keon minimialkion(elementin) ja palauttaa kekorakenteen heapify
     * komennolla.
     *
     */
    public E poll() {
        if (size == 0) {
            return null;
        }
        E min = (E) (lista[0]);
        lista[0] = lista[size - 1];
        size--;
        heapify(0);
        return min;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Lisaa elementin kekoon ja kasvattaa keon sisaista listaa mikali sen koko
     * ylittyy.
     *
     * @param lisattava
     */
    public void add(E lisattava) {
        size++;
        if (size == listanKoko) {
            Object[] uusiTaulukko = new Object[2 * listanKoko];
            System.arraycopy(lista, 0, uusiTaulukko, 0, listanKoko);
            listanKoko = 2 * listanKoko;
            lista = uusiTaulukko;
        }
        int i = size - 1;
        lista[i] = lisattava;
        while (i > 0 && (larger(i, parent(i)) == i)) {
            swap(i, parent(i));
            i = parent(i);
        }
        lista[i] = lisattava;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int righthild(int index) {
        return 2 * index + 1;
    }

    /**
     * vaihta kahden alkion paikkaa listassa.
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Object temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
    }

    /**
     * palauttaa parametreina annetuista luvuista suuremman.
     *
     * @param i
     * @param j
     * @return
     */
    private int larger(int i, int j) {
        if (vertailija == null) {
            if (((Comparable<? super E>) (lista[i])).compareTo((E) (lista[j])) < 0) {
                return i;
            } else {
                return j;
            }
        } else {
            if (vertailija.compare((E) lista[i], (E) lista[j]) < 0) {
                return i;
            } else {
                return j;
            }
        }
    }

    /**
     * Palauttaa keon rakenteen sisaiseen taulukkoon vertailemalla haluttuja
     * elementteja ja vaihtamalla niiden paikkaa tarvittaessa.
     *
     * @param i
     */
    private void heapify(int i) {
        int right = righthild(i);
        int left = leftChild(i);
        if (right < size - 1) {
            int largest = larger(left, right);
            if (larger(largest, i) == largest) {
                swap(i, largest);
                heapify(largest);
            }
        } else if (left == size && (larger(left, i) == left)) {
            swap(i, left);
        }
    }

}
