package astar;

/**
 *
 * @author Leo
 */
public class App {

    /**
     *
     * Luo ohjelman tarvitsemat oliot ja tulostaa polun lopusta alkuun.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long aikaAlussa = System.currentTimeMillis();
        AstarAlgoritmi a = new AstarAlgoritmi();

        Piste p = a.Astar(new Piste(0, 0, null), new Piste(200, 300, null));
// Pisteiden koordinaatteja voi halutessaan muuttaa. Ensimmainen arvo on X ja toinen Y.
// Ensimmainen piste on alku ja toien loppu.

        System.out.println(p);
        long aikaLopussa = System.currentTimeMillis();
        System.out.println("Aikaa kului: " + (aikaLopussa - aikaAlussa) + " millisekunttia");
    }

}
