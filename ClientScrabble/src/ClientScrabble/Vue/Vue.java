package ClientScrabble.Vue;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import  ClientScrabble.ctrl.ControleurClient;
import ClientScrabble.vue.MaConsole;
/**
 *
 * @author Vince
 */
  public class Vue {

    private ControleurClient ctrl;

    public Vue(ControleurClient ctrl) {
        this.ctrl = ctrl;
    }

    public void EcranInitial() {
        String nom = MaConsole.readLine("Nom du joueur : ");
        System.out.println("\nBienvenue dans votre jeu de scraable."+ nom + "\n");
        
    }
    public void affSuite(String msg) {
        System.out.print(msg);
    }  
    public void affLine(String msg){
        System.out.println(msg);
    }
}
