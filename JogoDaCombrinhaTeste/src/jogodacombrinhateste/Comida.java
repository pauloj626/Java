package jogodacombrinhateste;

import java.awt.Color;
import java.awt.Graphics;

public class Comida {
    private int x, y;
    
    public Comida(){
        this.x = ((int) (100 / (Math.random()))%18);
        this.y = ((int) (100 / (Math.random()))%16);
    }
    
    public boolean foiComida(int x, int y){
        return (40*(this.x+1) == x)&&(40*(this.y+1) == y);
    }
    
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(40*(this.x+1), 40*(this.y+1), 40, 40);
        g.setColor(Color.RED);
        g.drawRect(40*(this.x+1), 40*(this.y+1), 40, 40);
    }
}
