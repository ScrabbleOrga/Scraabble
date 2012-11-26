/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;
import ClientScrabble.Connexion.ProtocoleClient;
import commun.*;
import java.util.HashSet;

/**
 *  
 * @author Administrateur
 * Classe permettant l'échange avec le model
 */

public class GAB {
    private ProtocoleClient protocole;
    private Joueur MonJoueur;
    private ListeCases MonPlateau;
    
    public GAB(String adrIP, int port) {
       protocole = new ProtocoleClient(adrIP, port);  
       MonPlateau.getInstance();
       while(true){
        
        }
       
    }
    
    public void setNom(String nom){
        MonJoueur.setNom(nom);
    }
    
    
    
    
}
