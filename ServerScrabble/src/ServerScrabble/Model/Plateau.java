/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerScrabble.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Vince
 */
public class Plateau {

    Case Plateau[][];
    public Collection<Lettre> Sac;
    public Plateau() {
        init();
    }
    
    private void init(){
        Plateau = new Case[15][15];
        construitPlateau();
    }
   
    Lettre getLettre(int x,int y){  
            return this.Plateau[x-1][y-1].Lettre;
    }
    String getCaseValue(int x,int y){
            return Plateau[x-1][y-1].Value;
    }
    void addLettre(Lettre lettre,int x,int y){
            this.Plateau[x-1][y-1].Lettre = lettre;
    }
    void removeLettre(int x,int y){
            this.Plateau[x-1][y-1].Lettre = new Lettre();
    }
    boolean verifRealisable(Lettre[] mot,int x,int y,boolean sens){
            //Verifier si le mot est dans le dictionnaire
            return false;
    }
    
    private void construitPlateau(){

       this.Plateau[0][0].Value=this.Plateau[0][7].Value=this.Plateau[0][14].Value ="motriple";
       this.Plateau[7][0].Value=this.Plateau[7][14].Value="motriple";
       this.Plateau[14][0].Value=this.Plateau[14][7].Value=this.Plateau[14][14].Value="motriple";

       // Plateau mot compte double
       this.Plateau[1][1].Value=this.Plateau[2][2].Value=this.Plateau[3][3].Value=this.Plateau[4][4].Value="motdouble";
       this.Plateau[1][13].Value=this.Plateau[2][12].Value=this.Plateau[3][11].Value="motdouble";
       this.Plateau[4][10].Value="motdouble";
       this.Plateau[13][1].Value=this.Plateau[12][2].Value=this.Plateau[11][3].Value=this.Plateau[10][4].Value="motdouble";
       this.Plateau[13][13].Value=this.Plateau[12][12].Value=this.Plateau[11][11].Value=this.Plateau[10][10].Value="motdouble";

       // Plateau lettre compte double
       this.Plateau[0][3].Value=this.Plateau[0][11].Value="lettreldouble";
       this.Plateau[2][6].Value=this.Plateau[2][8].Value="lettredouble";
       this.Plateau[3][7].Value=this.Plateau[3][14].Value="lettredouble";
       this.Plateau[6][2].Value=this.Plateau[6][6].Value=this.Plateau[6][8].Value=this.Plateau[6][12].Value="lettredouble";
       this.Plateau[3][7].Value=this.Plateau[3][7].Value=this.Plateau[3][14].Value="lettredouble";
       this.Plateau[7][3].Value=this.Plateau[7][11].Value="lettredouble";
       this.Plateau[8][2].Value=this.Plateau[8][6].Value=this.Plateau[8][8].Value=this.Plateau[8][12].Value="lettredouble";
       this.Plateau[11][0].Value=this.Plateau[11][7].Value=this.Plateau[11][14].Value="lettredouble";
       this.Plateau[12][6].Value=this.Plateau[12][8].Value="lettredouble";
       this.Plateau[14][3].Value=this.Plateau[14][11].Value="lettredouble";

       // Plateau lettre compte triple
       this.Plateau[1][5].Value=this.Plateau[1][9].Value="lettretriple";
       this.Plateau[13][5].Value=this.Plateau[13][9].Value="lettretriple";
       this.Plateau[5][1].Value=this.Plateau[5][5].Value=this.Plateau[5][9].Value=this.Plateau[5][13].Value="lettretriple";
       this.Plateau[9][1].Value=this.Plateau[9][5].Value=this.Plateau[9][9].Value=this.Plateau[9][13].Value="lettretriple";
    }
        
        /**
        * Methode permettant de v�rifier si le mot est dans le dictionnaire
        */
        
        boolean verifDico(Lettre[] mot){
            StringBuffer word = new StringBuffer();
            boolean result=false;
            for (int i=0;i<mot.length;i++){
                    word.append(mot[i].lettreChar);
            }
            File file=new File("c:\\Dico.txt");
            try {
                    BufferedReader entree =new BufferedReader(new FileReader(file));
                    try {
                            String laLigne=entree.readLine();
                            while (laLigne != null){
                                    if (laLigne.equals(word.toString())){
                                            result=true;
                                    }
                                    laLigne=entree.readLine();
                            }

                    } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
            } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

        return result;
        }
        
        
        /**
        * Methode permettant de poser le mot sur le tableaue
        */
        
        void poserMot(Lettre[] mot,boolean sens,int x,int y){
                        for (int i=0;i<mot.length;i++)
                                {
                                if (sens==false) 
                                        x++;
                                else
                                        y++;
                                this.Plateau[x-1][y-1].Lettre=mot[i];
                      
                        }
                                
                }
        

        /**
        * Methode permettant de verifier si un mot est possible
        */
        /*
        boolean verifPossible(Lettre[] mot,Joueur joueur, boolean sens,int x,int y){
                boolean result = false;
                Lettre[] motBuffer= new Lettre[mot.length];

                for (int i=0;i<mot.length;i++){
                        if (sens==false)
                                x++;
                        else
                                y++;
                        if (this.Plateau[x][y].equals(new Lettre()) == false){
                                motBuffer[i]=this.Plateau[x][y];
                        }
                        else {
                                if (mainBuffer.searchLettre(mot[i])!=0){
                                        motBuffer[i]=mainBuffer.main[i];
                                        mainBuffer.removeLettre(mot[i]);
                                }
                                else {
                                        
                                        System.out.println("Il n'y a pas la lettre "+mot[i]+" dans le chevalet");
                                        System.exit(1);
                                }
                        }               
                        
                }
                int totalExact=0;
                for (int ii=0;ii<motBuffer.length;ii++){
                        if (motBuffer[ii].equals(mot[ii])){
                                totalExact++;
                        }
                }
                
                if (totalExact==mot.length)
                        result=true;
                
                return result;
        }
        
        
        

        /**
        * Methode permettant de compter la valeur d'un mot
        */
        
        int compteMot(Lettre[] mot,boolean sens,int x, int y){
                //comptage du mot
                return 0;
                }
        
        public String toString(){
                StringBuffer PlateauBuffer =new StringBuffer();
                PlateauBuffer.append("\n");
                for (int i=0;i<15;i++){
                        for (int ii=0;ii<15;ii++){
                                Plateau[i][ii].Lettre.getChar();
                                PlateauBuffer.append(Plateau[i][ii].Lettre.getChar());
                        }
                        PlateauBuffer.append("\n");
                }
                
                return PlateauBuffer.toString();
                
        }   
}


