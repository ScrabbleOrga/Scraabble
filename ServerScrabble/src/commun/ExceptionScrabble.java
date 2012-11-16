/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package commun;

/**
 *
 * @author Administrateur
 */
public class ExceptionScrabble extends Exception{

    public ExceptionScrabble(typeErreur err) {
        this.err = err;
    }

    public typeErreur getErreur() {
        return err;
    }
    
    public enum typeErreur {CONN_KO,JOUEUR_EXISTE, JOUEUR_EXISTE_PAS, AUTRE};
    private typeErreur err;
}
