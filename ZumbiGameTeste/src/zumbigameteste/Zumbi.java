package zumbigameteste;

import java.awt.Color;
import java.awt.Graphics;

public class Zumbi {
    
    private int posX, posY;
    private int vel; // em modulo a velocidade do zumbi cresce de forma linear.
    private double ac; // aceleração do zumbi.
    //duas variaveis abaixo somente para teste
    private final int largura = 20, altura = 40;
    
    public Zumbi(){
        this.posX = (int)((int)1000/Math.random())%1000;
        this.posY = (int)((int)700/Math.random())%700;
        this.vel = 5;
        this.ac = 0;
    }
    
    public void move(int x, int y){
        int cX = x - this.posX; // componentes do vetores
        int cY = y - this.posY;
        
        this.posX += ((int)(this.vel*cX/(Math.hypot(cX, cY))));
        this.posY += ((int)(this.vel*cY/(Math.hypot(cX, cY))));
        
        this.vel += (int) this.ac;//3 - (int) Math.round(Math.pow(1+1/(double)this.ac, (double)this.ac));
        this.ac += 0.001;
    }
    
    public boolean morreuZumbi(int x, int y){
        return (x >= this.posX && x <= (this.posX-5) && y >= this.posY && y <= (this.posY-10));
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
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
    
    
}
