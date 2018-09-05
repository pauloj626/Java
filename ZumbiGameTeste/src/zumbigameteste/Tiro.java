package zumbigameteste;

import java.awt.Color;
import java.awt.Graphics;

public class Tiro {
    private int posX, posY;
    private Mov dir; // direção.
    private final int vel = 5;
    private boolean ativo;
    
    public Tiro(){
        this.ativo = false;
        this.dir = Mov.STOPED;
    }
    
    public void move(){
        if(this.ativo){
            if(this.dir == Mov.LEFT){
                this.posX -= this.vel;
            }else if(this.dir == Mov.RIGHT){
                this.posX += this.vel;
            }else if(this.dir == Mov.DOWN){
                this.posY += this.vel;
            }else if(this.dir == Mov.UP){
                this.posY -= this.vel;
            }
        }
    }
    
    public boolean saiuDaTela(){
        return (this.posX <= -10 && this.posX >= 1000 && this.posY <= -10 && this.posY >= 700);
    }
    
    public void draw(Graphics g){
        if(this.ativo){
            g.setColor(Color.yellow);
            g.fillOval(this.posX, this.posY, 10, 10);
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Mov getDir() {
        return dir;
    }

    public void setDir(Mov dir) {
        this.dir = dir;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
}
