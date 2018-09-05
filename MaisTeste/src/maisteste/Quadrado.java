package maisteste;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Quadrado {
    private int quaX, quaY;
    private int quaVx, quaVy;
    private int gravit = 1;
    int i;
    
    public Quadrado(Dimension area){
        this.quaX = 0;
        this.quaY = 410;
        this.quaVx = 7;
        this.quaVy = 30;
        this.i = 0;
    }
    
    public void moveUp(Movimentos mov){
        if(mov == null || mov == Movimentos.STOPED) {
        } else if(mov == Movimentos.LEFT && this.quaX > 2){
            this.quaX -= this.quaVx;
        }else if(mov == Movimentos.RIGTH){
            this.quaX += this.quaVx;
        }
        this.quaY -= this.quaVy;
        this.quaVy -= this.gravit;
        if(this.quaY >= 410){
            this.quaY = 410;
            this.quaVy = 30;
            i = 0;
        }
    }
    
    public void move(Movimentos mov){
        if(mov == null || mov == Movimentos.STOPED) {
        } else if(mov == Movimentos.UP && i == 0){
            this.quaY -= this.quaVy;
            this.quaVy -= this.gravit;
            this.i = 1;
            /*this.quaX += this.quaVx;
            if(quaX != 100)
                this.quaY -= this.quaVy;
            this.quaVy -= this.gravit;
            if(this.quaY >= 410){
                this.quaVy = 30;
                i = 1;
            }*/
        }else if(mov == Movimentos.LEFT && this.quaX > 2){
            this.quaX -= 15;//this.quaVx;
        }else if(mov == Movimentos.RIGTH){// && this.quaX < 400){
            this.quaX += 15;//this.quaVx;
        }else if(mov == Movimentos.DOWN){// && this.quaY < 400){
            this.quaY += 3;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        //g.fillRect(this.quaX, this.quaY, 50, 50);
        g.fillOval(this.quaX, this.quaY, 50, 50);
    }

    public void setQuaVy(int quaVy) {
        this.quaVy = quaVy;
    }
    
    public int getQuaX() {
        return quaX;
    }

    public void setQuaX(int quaX) {
        this.quaX = quaX;
    }

    public int getQuaY() {
        return quaY;
    }

    public void setQuaY(int quaY) {
        this.quaY = quaY;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
 