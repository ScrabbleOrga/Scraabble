package ServerScrabble.Ctrl;

import ServerScrabble.connexion.ProtocoleSrv;
import ServerScrabble.Model.Scrabble;
import commun.*;
//import ServerScrabble.connexionmodel.BanqueFactory;

class ThreadCtrl extends Thread {
    private Scrabble Scrabble;
    //private IBanque banque;
    private ProtocoleSrv proto;
    Message demande;

    public ThreadCtrl(ProtocoleSrv p) {
        proto = p;
    }

    @Override
    public void run() {
        demande = proto.wait_message();
        traiter_msg();
    }

    private void traiter_msg() {
        if (demande == null) {
            aff("Problème de protocole");
            return;
        }
        switch (demande.getCode()) {
            case 1:
                this.Scrabble = new Scrabble();
                break;
            default:
        }
    }//fin traiterClient

    private void traiter_err(ExceptionScrabble e) {
        Message reponse = null;
        switch (e.getErreur()) {
            case JOUEUR_EXISTE:
                reponse = new Message("Erreur");
                break;
        }
        proto.respond(reponse);
    }

    private void aff(String msg) {
        System.out.println("SERVEUR : "+msg);
    }

    
}//fin classe	

