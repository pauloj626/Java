package tetristentativa;

import java.awt.Color;
import java.awt.Graphics;

public class Bloco3 {
    private int bx, by;
    private int nrot;
    
    public Bloco3(){
        this.bx = 0;
        this.by = 0;
        this.nrot = 0;        
    }
    
    public void move(Movimentos mov){
        if(mov == null || mov == Movimentos.STOPED){
        }else if(mov == Movimentos.LEFT && this.bx >= 30){
            this.bx -= 30;
        }else if(mov == Movimentos.RIGTH){
            if(this.nrot%2 == 1 && this.bx <= 300){
                this.bx += 30;
            }else if(this.nrot%2 == 0 && this.bx <= 270)
                this.bx += 30;
        }else if(mov == Movimentos.UP){
            if(this.nrot == 3)
                this.nrot = 0;
            else
                this.nrot++;
        }else if(mov == Movimentos.DOWN){
            if(this.nrot == 0)
                this.nrot = 3;
            else
                this.nrot--;
        }
        if((this.nrot%2 == 0 && this.by <= 540)||(this.nrot%2 == 1 && this.by <= 510)){
           this.by += 30;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        if(this.nrot == 0){
            g.fillRect(bx, by+30, 90, 30);
            g.fillRect(bx+30, by, 30, 30);
        }else if(this.nrot == 1){
            g.fillRect(bx, by, 30, 90);
            g.fillRect(bx+30, by+30, 30, 30);
        }else if(this.nrot == 2){
            g.fillRect(bx, by, 90, 30);
            g.fillRect(bx+30, by+30, 30, 30);
        }else if(this.nrot == 3){
            g.fillRect(bx+30, by, 30, 90);
            g.fillRect(bx, by+30, 30, 30);
        }
    }

    public int getBy() {
        return by;
    }
    
    
    
    
}
