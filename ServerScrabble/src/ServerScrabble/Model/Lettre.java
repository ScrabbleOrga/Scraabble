/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerScrabble.Model;

public class Lettre{
                
    char lettreChar;
    int  lettreValue;     
    Lettre()
        {
            this.lettreChar=' ';
            this.lettreValue=0;
        }
    Lettre (char lettreChar,int lettreValue)
        {
            this.lettreChar=lettreChar;
            this.lettreValue=lettreValue;
        }
    void changeCharValue(char lettreChar, int lettreValue)
        {
        this.lettreChar=lettreChar;
        this.lettreValue=lettreValue;
        }  
    void changeChar(char lettreChar)
        {
        this.lettreChar=lettreChar;
        }      
    void changeValue(int lettreValue)
        {
        this.lettreValue=lettreValue;
        }   
    int getValue()
        {
        return this.lettreValue;
        }   
    char getChar()
                {
        return this.lettreChar;
                }  
    public String toString() {
        return "Lettre=" +this.lettreChar+",Valeur=" +this.lettreValue;
        }    
    public boolean equals(Object obj){
        return (this.lettreChar == ((Lettre)obj).lettreChar);
      }

    
}
