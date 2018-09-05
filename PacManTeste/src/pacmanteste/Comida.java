package pacmanteste;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.net.URL;

public class Comida {
    private int cx, cy;
    private boolean ativa;
    private int a, b;
    private final URL urlComendo;
    private final URL urlAnd1; 
    private final URL urlAnd2;
    private final AudioClip Come;
    private final AudioClip And1;
    private final AudioClip And2;
    
    public Comida(int x, int y){
        this.urlComendo = getClass().getResource("Com.wav");
        this.urlAnd1 = getClass().getResource("And1.wav");
        this.urlAnd2 = getClass().getResource("And2.wav");
        this.Come = Applet.newAudioClip(urlComendo);
        this.And1 = Applet.newAudioClip(urlAnd1);
        this.And2 = Applet.newAudioClip(urlAnd2);
        this.cx = x;
        this.cy = y;
        ativa = true;
        this.a = 0;
        this.b = 0;
    }
    
    public void foiComida(int x, int y){
        if(this.a < 21)
            this.a += 1;
        else
            this.a = 0;
        
        if(this.cx >= x && this.cx <= x+25 && this.cy >= y && this.cy <= y+25 && this.ativa){
            this.ativa = false;
            //this.And1.stop();
            //this.And2.stop();
            this.Come.play();
        }/*else{
            if(this.b == 0){
                this.And2.stop();
                this.Come.stop();
                this.And1.play();
            }else if(this.b == 30){
                this.And1.stop();
                this.Come.stop();
                this.And2.play();
                this.b = -1;
            }
        }this.b += 1;/*/
        
    }
    
    public void draw(Graphics g){
        if(this.a < 7)
            g.setColor(Color.WHITE);
        else if(this.a < 14)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.BLUE);
        if(this.ativa)
            g.fillOval(this.cx, this.cy, 20, 20);
    }
}
