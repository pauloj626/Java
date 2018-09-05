package tetristentativa;

import java.awt.Color;
import java.awt.Graphics;

public class Bloco2 {
    private int bx, by;
    
    public Bloco2(){
        bx = 90;
        by = 0;
    }
    
    public void move(Movimentos mov){
        if(mov == null || mov == Movimentos.STOPED){
        }else if(mov == Movimentos.LEFT && this.bx >= 30){
            this.bx -= 30;
        }else if(mov == Movimentos.RIGTH && this.bx <= 300){
            this.bx += 30;
        }
        if(this.by <= 540){
            this.by += 30;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(this.bx, this.by, 60, 60);
    }

    public int getBy() {
        return by;
    }
    
    
    
}
