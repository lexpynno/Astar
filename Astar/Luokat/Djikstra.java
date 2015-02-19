
package astar;

import java.util.ArrayList;

/**
 * Sisaltaa Djikstra hakualgoritmin ja tuntee Vertailijan luokan edustajan. Keon
 * ominaisuuksia kayttaen loytaa lyhyimman reitin annetusta pisteesta maaliin.
 *
 * @author Leo
 */
public class Djikstra {

    private DjikstraVertailija vertailija;

    /**
     * Varsinainen Djikstra hakualgoritmi, joka palauttaa viimeisen pisteen jos se
     * vastaa maalia ja sita kautta koko pisteketjun alusta loppuun. Palauttaa
     * null jos maalia ei loydy
     *
     * @param alku
     * @param loppu
     * @return
     */
    public Piste Djikstra(Piste alku, Piste loppu) {
        this.vertailija = new DjikstraVertailija(loppu);
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