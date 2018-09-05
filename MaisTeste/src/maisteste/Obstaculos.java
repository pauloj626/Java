package maisteste;

import java.awt.Color;
import java.awt.Graphics;

public class Obstaculos {
    
    public boolean colidirUp(int x, int y){
        return (x > 275 && x < 475 && y >= 45 && y <= 55);
    }
    
    public boolean colidirDown(int x, int y){
        return (x > 275 && x < 475 && y >= 105 && y <= 95);
    }
    
    public boolean colidirLeft(int x, int y){
        return (x >= 245 && x <= 255 && y < 120 && y > 70);
    }
    
    public boolean colidirRigth(int x, int y){
        return (x >= 595 && x <= 505 && y < 120 && y > 70);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(300, 100, 200, 50);
    }
}
