/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;
import ClientScrabble.Connexion.ProtocoleClient;
import commun.*;

/**
 *
 * @author Administrateur
 */
public class GAB {

    public GAB(String adrIP, int port) {
        protocole = new ProtocoleClient(adrIP, port);
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void ouvrirCompte(String nom) throws ExceptionScrabble {
        nomClient = nom;
        Message reponse = protocole.send_message(Message.OP_I, nom, 0);
        traiter_rep(reponse);
    }

    public void fermerCompte() throws ExceptionScrabble {
        Message reponse = protocole.send_message(Message.OP_U, nomClient, 0);
        traiter_rep(reponse);
    }

    public void deconnexion() throws ExceptionScrabble {
        
        Message reponse = protocole.send_message(Message.OP_DEC, nomClient, 0);
        traiter_rep(reponse);    
         
    }

    public double getSolde() {
        return solde;
    }

    private boolean traiter_rep(Message reponse) throws ExceptionScrabble {
        if (reponse == null) throw new ExceptionScrabble(ExceptionScrabble.typeErreur.CONN_KO);
        if (reponse.getCode() == Message.M_OK) return true;
        throw traiter_err(reponse.getCode());
    }

    private ExceptionScrabble traiter_err(int err) {
        switch (err) {
            case Message.M_JOUEXIST:
                return new ExceptionScrabble(ExceptionScrabble.typeErreur.JOUEUR_EXISTE);
            case Message.M_JOUNOTEXIST:
                return new ExceptionScrabble(ExceptionScrabble.typeErreur.JOUEUR_EXISTE_PAS);
            case Protocole.CONN_KO:
                return new ExceptionScrabble(ExceptionScrabble.typeErreur.CONN_KO);
            default:
                return new ExceptionScrabble(ExceptionScrabble.typeErreur.AUTRE);
        }
    }
    
    private String nomClient;
    private double solde = 0;
    private ProtocoleClient protocole;
}
