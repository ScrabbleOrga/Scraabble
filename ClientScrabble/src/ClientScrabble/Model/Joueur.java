/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;
import ClientScrabble.Connexion.ProtocoleClient;
/**
 *
 * @author Vince
 */
public class Joueur {
    private ProtocoleClient ptrcl;
   
    public Joueur(String addIp,int port) {
        ProtocoleClient ptrcl = new ProtocoleClient(addIp, port);
    }
    

}
