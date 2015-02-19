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
     * Pisteiden koordinaatteja voi halutessaan muuttaa. Ensimmainen arvo on X
     * ja toinen Y. Ensimmainen piste on alku ja toien loppu.
     *
     * Lisaksi voi kokeilla, joko djikstran algoritmia, Bread first -algoritmia
     * tai Astaria. Vai yksi niista voi olla kerrallaan kommentoimattomana.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long aikaAlussa = System.currentTimeMillis();
        BFS b = new BFS();
        AstarAlgoritmi a = new AstarAlgoritmi();
        Djikstra d = new Djikstra();

//        Piste p = b.BFS(new Piste(0, 0, null), new Piste(50, 50, null));
//        Piste p = a.Astar(new Piste(0, 0, null), new Piste(50, 50, null));
        Piste p = d.Djikstra(new Piste(0, 0, null), new Piste(0, 1000, null));

        System.out.println(p);
        long aikaLopussa = System.currentTimeMillis();
        System.out.println("Aikaa kului: " + (aikaLopussa - aikaAlussa) + " millisekunttia");
    }

}
