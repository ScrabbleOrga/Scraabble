/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;

import java.io.*;
import java.util.List;.util.ArrayList;
import java


/**
 *
 * @author Vince
 */
public class Dictionnaire{
    // File d'entré
    private String sPath;
    private List Contenu = new ArrayList();
    File sFile = new File("c:\\Dico.txt");
    
    public Dictionnaire() {
        ReadFile();
        System.out.println(Contenu.contains("vincent"));
    }
    
    private void ReadFile() {   
    try {
      BufferedReader input =  new BufferedReader(new FileReader(sFile));
      try {
        String line = null;
        
        while (( line = input.readLine()) != null){
            Contenu.add(line);
        }
      }
      finally {
        input.close();
      }
    }
    catch (IOException ex){
      ex.printStackTrace();
    }
    }
}
