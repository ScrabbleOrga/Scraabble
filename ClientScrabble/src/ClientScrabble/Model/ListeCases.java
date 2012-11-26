/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;

/**
 *
 * @author Vince
 */
public class ListeCases {
    private Case[][] Plateau; 

    private ListeCases() {
        remplirPlateau();
    }
    private void remplirPlateau(){
        this.Plateau = new Case[15][15];
        for (int i =0; i<=15;i++){
            for(int j=0;i<=15;i++){
                Plateau[i][j] =  new Case(i,j);
            }
        }
    }     
    public Case[][] getInstance(){
        if ((Plateau instanceof Case[][])==false){
            remplirPlateau();
        }
        return this.Plateau;
    }
    public String toString(){
        for (int i=0;i<=15;i++){
            for (int j=0;j<=15;j++){
                System.out.print("[]");
            }
            System.out.println("");;
        }
        return "";
    }
}

