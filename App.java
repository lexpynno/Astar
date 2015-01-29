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
        AstarAlgoritmi a = new AstarAlgoritmi();
        Piste p = a.Astar(new Piste(10, 10, null), new Piste(-20, 40, null));
        System.out.println(p);
    }

}
