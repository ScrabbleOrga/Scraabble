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
        ctrlClient.Init(); 
    }
    public void Init(){
        vue.EcranInitial();
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
}
