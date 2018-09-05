package jogodacombrinhateste;

import java.awt.Color;
import java.awt.Graphics;

public class PartCobra {
    private int x, y;
    private int vx, vy;
    private Mov dir;
    
    public PartCobra(int x, int y, Mov dir){
        this.x = x;
        this.y = y;
        this.vx = 40;
        this.vy = 40;
        this.dir = dir;
    }
    
    public void move(Mov dir){
        if(dir == null || dir == Mov.STOPED){
            return;
        }
        if(dir == Mov.DOWN && this.dir != Mov.UP){
            this.y += this.vy;
        }else if(dir == Mov.UP && this.dir != Mov.DOWN){
            this.y -= this.vy;
        }else if(dir == Mov.LEFT && this.dir != Mov.RIGHT){
            this.x -= this.vx;
        }else if(dir == Mov.RIGHT && this.dir != Mov.LEFT){
            this.x += this.vx;
        }
        this.dir = dir;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(this.x, this.y, 40, 40);
        g.setColor(Color.BLUE);
        g.drawRect(this.x, this.y, 40, 40);
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