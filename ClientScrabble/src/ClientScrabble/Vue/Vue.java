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

    public void menuInitial() {
        System.out.println("\nBONJOUR.\n");
        ctrl.choixInitial(MaConsole.readInt("Votre choix : "));
    }
    public void aff(String msg) {
        System.out.println(msg);
    }  
}
