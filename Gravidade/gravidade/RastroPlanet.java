package gravidade;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class RastroPlanet {
    private ArrayList<Point> pontos;
    private Color massa;
    private int raio;
    
    public RastroPlanet(Planeta A){
        this.pontos = new ArrayList<> ();
        int massa = (int) A.getMassa();
        this.raio = (int) A.getRaio();
        if(massa <= 50)
            this.massa = Color.GRAY;
        else if(massa <= 100)
            this.massa = Color.BLUE;
        else
            this.massa = Color.RED;
    }
    
    public void addRastroPlanet(Planeta A){
        Point p = new Point();
        p.x = (int) A.getPosX();
        p.y = (int) A.getPosY();
        this.pontos.add(p);
        if(this.pontos.size() > 100)
            this.pontos.remove(0);
    }
    
    public void drawRastro(Graphics g){
        g.setColor(this.massa);
        this.pontos.forEach((p) -> {
            g.fillOval(p.x-this.raio, p.y-this.raio, 2*raio, 2*raio);
        });
    }
}
