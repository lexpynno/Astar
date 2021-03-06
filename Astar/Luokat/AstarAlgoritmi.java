/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

import java.util.ArrayList;

/**
 * Sisaltaa Astar hakualgoritmin ja tuntee Vertailijan luokan edustajan. Keon
 * ominaisuuksia kayttaen loytaa lyhyimman reitin annetusta pisteesta maaliin.
 *
 * @author Leo
 */
public class AstarAlgoritmi {

    private AstarVertailija vertailija;

    /**
     * Varsinainen Astar hakualgoritmi, joka palauttaa viimeisen pisteen jos se
     * vastaa maalia ja sita kautta koko pisteketjun alusta loppuun. Palauttaa
     * null jos maalia ei loydy
     *
     * @param alku
     * @param loppu
     * @return
     */
    public Piste Astar(Piste alku, Piste loppu) {
        this.vertailija = new AstarVertailija(loppu);
        Keko<Piste> tutkittavat = new Keko<>(vertailija);

        tutkittavat.add(alku);
        Lista<Piste> kasitellyt = new Lista<>();

        while (!tutkittavat.isEmpty()) {
            Piste piste = tutkittavat.poll();
            if (!kasitellyt.contains(piste)) {
                kasitellyt.add(piste);
                if (piste.equals(loppu)) {
                    return piste;
                } else {
                    Lista<Piste> naapurit = new Lista(piste.Naapurit());

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
