package ClientScrabble.ctrl;

import ClientScrabble.Model.GAB;
import ClientScrabble.Vue.Vue;
import commun.ExceptionScrabble;
//import utils.Util;

public class ControleurClient {

    private Vue vue;
    private GAB gab;
    private static String adrIP = "localhost";
    private static int port = 8189;

    public static void main(String[] args) {
        ControleurClient ctrlClient = new ControleurClient(args);
        ctrlClient.affInit();
    }
    
    //***************  Lancement du pgm client ***********************
    public ControleurClient(String[] args) {
        switch (args.length) {
            case 1:
                adrIP = args[0];
                break;
            case 2:
                adrIP = args[0];
                port = Integer.valueOf(args[1].trim()).intValue();
                break;
        }
       vue = new Vue(this);
       gab = new GAB(adrIP, port);
    }
    
    public void affInit() {
        vue.menuInitial();
    }

    public void choixInitial(Integer choix) {
        switch (choix) {
            default:
                vue.aff("Mauvais choix");
                vue.menuInitial();
                break;
        }
    }

    
    //********************* Méthodes privées ************************

    private void traiter_exception(ExceptionScrabble e) {
        switch (e.getErreur()) {
            case JOUEUR_EXISTE:
                vue.aff("Cher " + gab.getNomClient() + ", Vous avez deja joué au jeu");
                vue.menuInitial();
                break;
            case JOUEUR_EXISTE_PAS:
                vue.aff("Cher " + gab.getNomClient() + ", Vous n'avez jamais joué au jeu !");
                vue.menuInitial();
                break;
            case AUTRE:
                vue.aff("Problème inconnu !");
                break;
        }
    }
}
