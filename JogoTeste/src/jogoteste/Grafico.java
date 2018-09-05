package jogoteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Grafico extends JPanel{
    
    private int bx = 50, by = 50, vx = 2, vy = 2;
    private int px = 10, py = 100, yx = 750, yy = 100;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        Graphics2D boll = (Graphics2D) g;
        Graphics2D bar0 = (Graphics2D) g;
        Graphics2D bar1 = (Graphics2D) g;
        Graphics2D bar2 = (Graphics2D) g;
        Graphics2D Play = (Graphics2D) g;
        Graphics2D iyah = (Graphics2D) g;
        
        bar0.setColor(Color.WHITE);
        bar0.fillRect(40, 20, 700, 20);
        
        bar1.setColor(Color.WHITE);
        bar1.fillRect(40, 520, 700, 20);
        
        bar2.setColor(Color.WHITE);
        bar2.fillRect(400, 20, 5, 500);
        
        Play.setColor(Color.WHITE);
        Play.fillRect(px, py, 20, 100);
        
        iyah.setColor(Color.WHITE);
        iyah.fillRect(yx, yy, 20, 100);
        
        boll.setColor(Color.WHITE);
        boll.fillOval(bx, by, 15, 15);
        
    }

    public int getBx() {
        return bx;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
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

    public int getPx() {
        return px;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public int getYx() {
        return yx;
    }

    public void setYx(int yx) {
        this.yx = yx;
    }

    public int getYy() {
        return yy;
    }

    public void setYy(int yy) {
        this.yy = yy;
    }
}