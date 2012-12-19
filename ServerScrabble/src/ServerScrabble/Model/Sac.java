
/*
0 point : Joker ×2 (appelés en français jokers ou lettres blanches)
1 point : E ×15, A ×9, I ×8, N ×6, O ×6, R ×6, S ×6, T ×6, U ×6, L ×5
2 points : D ×3, M ×3, G ×2
3 points : B ×2, C ×2, P ×2
4 points : F ×2, H ×2, V ×2
8 points : J ×1, Q ×1
10 points : K ×1, W ×1, X ×1, Y ×1, Z ×1
*/
package ServerScrabble.Model;

import java.util.Collection;
import java.util.Random;

/**
 *
 * @author Vince
 */
public final class Sac {
    Collection<Lettre> Sac;

    public Sac() {
        construitSac();
    }
    String CreationListeLettre(){
        String s = "";
        Object[] Temp;
        for (int i = 0; i > 7; i++){
           Random r = new Random(102); 
           Temp = Sac.toArray();
           //s = s.concat((Lettre)Temp[r.nextInt()]);
        }
        return s;
    }
    void construitSac(){

        for (int i = 0; i < 15; i++) {
           Sac.add(new Lettre('E',1));
        }
        for (int i = 0; i < 9; i++) {
            Sac.add(new Lettre('A',1));
        }
        for (int i = 0; i < 6; i++) {
            Sac.add(new Lettre('N',1));
            Sac.add(new Lettre('O',1));
            Sac.add(new Lettre('R',1));
            Sac.add(new Lettre('S',1));
            Sac.add(new Lettre('T',1));
            Sac.add(new Lettre('U',1));
        }
        for (int i = 0; i < 3; i++) {
            Sac.add(new Lettre('D',2));
            Sac.add(new Lettre('M',2));
        }
        for (int i = 0; i < 2; i++) {
            Sac.add(new Lettre('G',2));
            Sac.add(new Lettre('B',3));
            Sac.add(new Lettre('C',3));
            Sac.add(new Lettre('P',3));
            Sac.add(new Lettre('F',4));
            Sac.add(new Lettre('H',4));
            Sac.add(new Lettre('V',4));
        }
        for (int i = 0; i < 1; i++) {
            Sac.add(new Lettre('J',8));
            Sac.add(new Lettre('Q',8));
            Sac.add(new Lettre('K',10));
            Sac.add(new Lettre('W',10));
            Sac.add(new Lettre('X',10));
            Sac.add(new Lettre('Y',10));
            Sac.add(new Lettre('Z',10));
        }
    }
    
}
