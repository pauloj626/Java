package pacmanteste;

import java.awt.Color;
import java.awt.Graphics;

public class ComeCome {
    private int cx, cy;
    private int vx, vy;
    private int a;
    private Movimentos dir;
    
    public ComeCome(){
        this.cx = 300;
        this.cy = 350;
        this.vx = 5;
        this.vy = 5;
        this.a = 0;
    }
    
    public void move(Movimentos mov, boolean colid){
        if(mov == null || mov == Movimentos.STOPED || !colid){
        }else if(mov == Movimentos.LEFT && this.cx >= 0){
            this.cx -= this.vx;
            if(this.cx < 0 && this.cy >= 355 && this.cy <= 370)
                this.cx = 650;
        }else if(mov == Movimentos.RIGTH && this.cx < 650){
            this.cx += this.vx;
            if(this.cx >= 650 && this.cy < 355 && this.cy > 370)
                this.cx = 650;
            else if(this.cx == 650 && this.cy >= 355 && this.cy <= 370)
                this.cx = 0;
        }else if(mov == Movimentos.DOWN && this.cy < 620){
            this.cy += this.vy;
            if(this.cy >= 620)
                this.cy = 620;
        }else if(mov == Movimentos.UP && this.cy > 0){
            this.cy -= this.vy;
        }
        
        this.dir = mov;
        
        if(this.a < 30)
            this.setA(this.getA()+1);
        else
            this.setA(0);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.yellow);
        if(this.dir == Movimentos.LEFT){
            if(a < 8){
                g.fillArc(this.cx, this.cy, 50, 50, 0, 360);
            }else if(a < 15 || (a >= 22 && a < 30)){
                g.fillArc(this.cx, this.cy, 50, 50, 225, 270);
            }else{
                g.fillArc(this.cx, this.cy, 50, 50, 240, 240);
            }
        }else if(this.dir == Movimentos.RIGTH){
            if(a < 8){
                g.fillArc(this.cx, this.cy, 50, 50, 0, 360);
            }else if(a < 15 || (a >= 22 && a < 30)){
                g.fillArc(this.cx, this.cy, 50, 50, 45, 270);
            }else{
                g.fillArc(this.cx, this.cy, 50, 50, 60, 240);
            }
        }else if(this.dir == Movimentos.UP){
            if(a < 8){
                g.fillArc(this.cx, this.cy, 50, 50, 0, 360);
            }else if(a < 15 || (a >= 22 && a < 30)){
                g.fillArc(this.cx, this.cy, 50, 50, 135, 270);
            }else{
                g.fillArc(this.cx, this.cy, 50, 50, 150, 240);
            }
        }else if(this.dir == Movimentos.DOWN){
            if(a < 8){
                g.fillArc(this.cx, this.cy, 50, 50, 0, 360);
            }else if(a < 15 || (a >= 22 && a < 30)){
                    g.fillArc(this.cx, this.cy, 50, 50, 315, 270);
            }else{
                g.fillArc(this.cx, this.cy, 50, 50, 330, 240);
            }
        }else {
            g.fillArc(this.cx, this.cy, 50, 50, 225, 270);
        }
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
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

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Movimentos getDir() {
        return dir;
    }

    public void setDir(Movimentos dir) {
        this.dir = dir;
    }
    
}
