package zumbigameteste;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int posX, posY;
    private int vx, vy;
    private Mov dir;
    
    //para teste colocarei essas duas variaveis abaixo
    //é o valor da largura e da altura do player.
    private final int largura = 20;
    private final int altura = 40;
    
    public Player(){
        this.posX = 500;
        this.posY = 350;
        this.dir = Mov.STOPED;
        this.vx = 20;
        this.vy = 20;
    }
    
    public void move(Mov dir){
        if(dir == null || dir == Mov.STOPED){
        }else if(dir == Mov.LEFT && this.posX >= 0){
            this.posX -= this.vx;
        }else if(dir == Mov.RIGHT && this.posX <= (1000-this.largura)){
            this.posX += this.vx;
        }else if(dir == Mov.UP && this.posY >= 0){
            this.posY -= this.vy;
        }else if(dir == Mov.DOWN && this.posY <= (700-this.altura)){
            this.posY += this.vy;
        }
    }
    
    public boolean matouPlayer(int x, int y){
        return (this.posX >= x-10 && this.posX <= x+20 && this.posY >= y-20 && this.posY <= y+40);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(this.posX, this.posY, this.largura, this.altura);
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

    public int getVx() {
        return vx;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Mov getDir() {
        return dir;
    }

    public void setDir(Mov dir) {
        this.dir = dir;
    }

}
