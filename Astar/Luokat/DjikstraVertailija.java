package astar;

import astar.Piste;
import java.util.Comparator;

/**
 * Prioriteetti jonoon tarvittava olio, joka vertailee keon sisaisia
 * elementteja. Tuntee maalipisteen, johon etaisyysarvio kustakin pisteesta
 * lasketaan.
 *
 * @author Leo
 */
public class DjikstraVertailija implements Comparator<Piste> {

    private final Piste maali;

    public DjikstraVertailija(Piste maali) {
        this.maali = maali;
    }

    /**
     * Vertailee kahta pistetta ja palauttaa arvon, jota kaytetaan keon
     * rakenteen yllapidossa ja sita kautta nopeassa haussa. Erona Astarin
     * vertailijaan on edellisten pisteiden mukaan lasku.
     *
     * @param eka
     * @param toka
     * @return
     */
    @Override
    public int compare(Piste eka, Piste toka) {
        return (eka.getAndSetEtaisyysMaaliin(maali) + eka.getEdellistenMaara()) - (toka.getAndSetEtaisyysMaaliin(maali) + toka.getEdellistenMaara());
    }
}
