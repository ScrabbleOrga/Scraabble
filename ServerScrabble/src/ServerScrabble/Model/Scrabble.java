/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerScrabble.Model;

/**
 *
 * @author Vince
 */
public class Scrabble {
    Plateau MonPlateau;
    Sac MonSac;
    public Scrabble() {
        this.MonPlateau = new Plateau();
        this.MonSac = new Sac();
    }
    public String CreeListeLettre(){
        return this.MonSac.CreationListeLettre();
    } 
    public void PoserLettre(Lettre l,int x, int y){
        this.MonPlateau.addLettre(l, x, y);
    }
    public void EnleverLettre(Lettre[] l,boolean sens,int x,int y){
        this.MonPlateau.poserMot(l, sens, x, y);
    }
    public boolean verifRealisable(Lettre[] mot,boolean sens,int x,int y){
        return this.MonPlateau.verifRealisable(mot, x, y, true);
    }
    
    
}
