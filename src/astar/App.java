/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astar;

/**
 *
 * @author Leo
 */
public class App {

    /**
     * 
     * Ohjelman kaynnistys
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AstarAlgoritmi a = new AstarAlgoritmi();
        Piste p = a.Astar(new Piste(2,2, null), new Piste(10, 10, null));
        System.out.println(p);
    }
    
}
