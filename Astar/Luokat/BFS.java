/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 * Bread-First-Search -Algorithm eli algoritmi, joka etsii leveys-suunnassa
 * maalipisteen alkupisteesta lahtien.
 *
 * @author Leo
 */
public class BFS {

    Lista tutkittavat = new Lista();
    Lista kasitellyt = new Lista();

    /**
     * Varsinainen BFS hakualgoritmi, joka palauttaa viimeisen pisteen jos se
     * vastaa maalia ja sita kautta koko pisteketjun. Palauttaa null jos maalia
     * ei loydy
     *
     * @param alku
     * @param maali
     * @return
     */
    public Piste BFS(Piste alku, Piste maali) {

        if (alku.equals(maali)) {
            return alku;
        }
        tutkittavat.add(alku);

        while (!tutkittavat.isEmpty()) {
            Piste piste = (Piste) tutkittavat.get(0);
            tutkittavat.poisto(0);
            if (!kasitellyt.contains(piste)) {
                kasitellyt.add(piste);
                if (piste.equals(maali)) {
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
