/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Leo
 */
public class AstarAlgoritmi {

    private Vertailija vertailija;
/**
 * Varsinainen Astar hakualgoritmi, joka palauttaa viimeisen pisteen jos se vastaa maalia.
 * Palauttaa null jos maalia ei löydy 
 * 
 * @param alku
 * @param loppu
 * @return 
 */
    public Piste Astar(Piste alku, Piste loppu) {
        this.vertailija = new Vertailija(loppu);
        PriorityQueue<Piste> tutkittavat = new PriorityQueue<Piste>(alku.getAndSetEtaisyysMaaliin(loppu),
                vertailija);

        tutkittavat.add(alku);
        ArrayList<Piste> kasitellyt = new ArrayList<>();

        while (!tutkittavat.isEmpty()) {
            Piste piste = tutkittavat.poll();
            if (!kasitellyt.contains(piste)) {
                kasitellyt.add(piste);
                if (piste.equals(loppu)) {
                    return piste;
                } else {
                    ArrayList<Piste> naapurit = piste.Naapurit();

                    for (Piste p : naapurit) {
                        if (!kasitellyt.contains(p)) {
                            tutkittavat.add(p);
                        }
                    }
                }
            }

        }
        return null;
    }
}
