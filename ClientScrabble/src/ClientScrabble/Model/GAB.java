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
 * Classe permettant l'échange avec le model
 */

public class GAB {
    private String nomClient;
    private ProtocoleClient protocole;
    private Dictionnaire MonDico;
    
    public GAB(String adrIP, int port) {
        protocole = new ProtocoleClient(adrIP, port);
        MonDico = new Dictionnaire();
    }

    public String getNomClient() {
        return nomClient;
    }
    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }
}
