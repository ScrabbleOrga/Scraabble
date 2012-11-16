package ServerScrabble.Ctrl;

import ServerScrabble.connexion.ProtocoleSrv;
import commun.*;
//import ServerScrabble.connexionmodel.BanqueFactory;

class ThreadCtrl extends Thread {

    //private IBanque banque;
    private ProtocoleSrv proto;
    Message demande;

    public ThreadCtrl(ProtocoleSrv p) {
        proto = p;
  //      banque = BanqueFactory.getBanque();
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
//            case Message.OP_D:
//                depot();
//                break;
            default:
        }
    }//fin traiterClient

    private void traiter_err(ExceptionScrabble e) {
        Message reponse = null;
        switch (e.getErreur()) {
            case JOUEUR_EXISTE:
                reponse = new Message(Message.M_JOUEXIST,"",0);
                break;
        }
        proto.respond(reponse);
    }


/*    private void depot() {
        String nomClient = demande.getNom();
        double montant = demande.getMontant();
        aff(nomClient + " fait un dépot");
        try {
 //           int new_solde = (int) banque.depot(nomClient, montant);
 //           Message reponse = new Message(Message.M_OK, nomClient, new_solde);
//            proto.respond(reponse);
        } catch (ExceptionScrabble e) {
            traiter_err(e);
        }
    }
*/
    private void aff(String msg) {
        System.out.println("SERVEUR : "+msg);
    }
}//fin classe	

