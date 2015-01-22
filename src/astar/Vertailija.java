/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.Comparator;

/**
 *
 * @author Leo
 */
public class Vertailija implements Comparator<Piste> {

    private final Piste maali;

    public Vertailija(Piste maali) {
        this.maali = maali;
    }
    
    @Override
    public int compare(Piste eka, Piste toka) {
        return eka.getAndSetEtaisyysMaaliin(maali) - toka.getAndSetEtaisyysMaaliin(maali);
    }
}
