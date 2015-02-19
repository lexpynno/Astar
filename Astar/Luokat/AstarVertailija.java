package astar;

import java.util.Comparator;

/**
 * Prioriteetti jonoon tarvittava olio, joka vertailee keon sisaisia
 * elementteja. Tuntee maalipisteen, johon etaisyysarvio kustakin pisteesta
 * lasketaan.
 *
 * @author Leo
 */
public class AstarVertailija implements Comparator<Piste> {

    private final Piste maali;

    public AstarVertailija(Piste maali) {
        this.maali = maali;
    }

    /**
     * Vertailee kahta pistetta ja palauttaa arvon, jota kaytetaan keon
     * rakenteen yllapidossa ja sita kautta nopeassa haussa. Ei laske edellisten pisteiden maaraa.
     *
     * @param eka
     * @param toka
     * @return
     */
    @Override
    public int compare(Piste eka, Piste toka) {
        return eka.getAndSetEtaisyysMaaliin(maali) - toka.getAndSetEtaisyysMaaliin(maali);
    }
}
