/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * Laskee ja palauttaa pisteen etaisyyden haluttuun pisteeseen
     *
     * @param maali
     * @return
     */
    public int getAndSetEtaisyysMaaliin(Piste maali) {
        int palautus = Math.abs(this.getX() - maali.getX());
        palautus += Math.abs(this.getY() - maali.getY());
        return palautus;
    }

    public Piste(int x, int y, Piste edellinen) {
        this.y = y;
        this.x = x;
        this.edellinen = edellinen;
    }

    @Override
    public String toString() {
        return "Piste{" + "y=" + y + ", x=" + x + ", etaisyysMaaliin=" + etaisyysMaaliin + "  " + edellinen + '}';
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Luo ja palauttaa pisteen naapurit
     *
     * @return
     */
    public ArrayList<Piste> Naapurit() {
        ArrayList<Piste> palautus = new ArrayList<Piste>();
        palautus.add(new Piste(y + 1, x, this));
        palautus.add(new Piste(y, x - 1, this));
        palautus.add(new Piste(y, x + 1, this));
        palautus.add(new Piste(y - 1, x, this));
        return palautus;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.y;
        hash = 29 * hash + this.x;
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
