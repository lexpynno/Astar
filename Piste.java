package astar;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Leo
 */
public class Piste {

    private int y;
    private int x;
    private int etaisyysMaaliin;
    private Piste edellinen;

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Piste getEdellinen() {
        return edellinen;
    }

    /**
     * Laskee ja palauttaa pisteen etaisyyden linnuntieta haluttuun pisteeseen
     *
     * @param maali
     * @return etaisyysMaaliin
     *
     */
    public int getAndSetEtaisyysMaaliin(Piste maali) {
//        int palautus = Math.max(Math.abs(y - maali.getY()), Math.abs(x - maali.getX()));
//        etaisyysMaaliin = palautus;
        double palautus = Math.pow(this.getX() - maali.getX(), 2)
                + Math.pow(this.getY() - maali.getY(), 2);
        palautus = Math.sqrt(palautus);
        etaisyysMaaliin = (int) palautus;
        return etaisyysMaaliin;
    }

    public Piste(int x, int y, Piste edellinen) {
        this.x = x;
        this.y = y;
        this.edellinen = edellinen;
    }

    @Override
    public String toString() {
        return "Piste" + " x = " + x + ", y = " + y + ", etaisyysMaaliin = " 
                + etaisyysMaaliin + "\n" + edellinen;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Luo ja palauttaa Listan naapuripisteita
     *
     * @return
     */
    public ArrayList<Piste> Naapurit() {
        ArrayList<Piste> palautus = new ArrayList<>();
        palautus.add(new Piste(x + 1, y, this));
        palautus.add(new Piste(x, y - 1, this));
        palautus.add(new Piste(x, y + 1, this));
        palautus.add(new Piste(x - 1, y, this));
        return palautus;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.y;
        hash = 97 * hash + this.x;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piste other = (Piste) obj;
        if (this.y != other.y) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        return true;
    }

}
