package astar;

import java.util.Comparator;

/**
 * Prioriteetti jonoon tarvittava olio, joka vertailee keon sisaisia
 * elementteja.
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
