/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientScrabble.Model;

import java.util.Set;

/**
 *
 * @author Vince
 */
public class Case {
       private int x;
       private int y;
       private int point;
       
    public Case(int x, int y) {
        this.x = x;
        this.y = y;
        EvalPoint();
    }
    private void EvalPoint(){
      this.point = 1;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getPoint() {
        return point;
    }
    
}
