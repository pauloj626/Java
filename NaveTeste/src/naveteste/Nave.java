package naveteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Nave extends JPanel{
    
    private int naveX = 325, naveY = 600;
    private int[] tiroX = {-10, -20, -30};
    private int[] tiroY = {-10, -20, -30};
    private int posEneX = 300, posEneY = 300;
    
    private ImageIcon Icon = new ImageIcon(getClass().getResource("spiderman3.gif"));
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        
        Graphics2D nave = (Graphics2D) g;
        nave.setColor(Color.WHITE);
        nave.fillRect(naveX+20, naveY, 10, 10);
        nave.fillRect(naveX+10, naveY+10, 30, 10);
        nave.fillRect(naveX+10, naveY+20, 30, 10);
        nave.fillRect(naveX, naveY+30, 20, 10);
        nave.fillRect(naveX+30, naveY+30, 20, 10);
        
        Graphics2D[] Tr;
        Tr = new Graphics2D[3];
        for(int i = 0; i < 3; i++){
            Tr[i] = (Graphics2D) g;
            Tr[i].fillOval(tiroX[i], tiroY[i], 10, 10);
        }
        
        Graphics2D enemigo = (Graphics2D) g;
        enemigo.drawImage(Icon.getImage(), posEneX, posEneY, this);
        /*enemigo.setColor(Color.GREEN);
        enemigo.fillRect(posEneX+0,posEneY+0, 10, 20);
        enemigo.fillRect(posEneX+70,posEneY+0, 10, 20);
        enemigo.fillRect(posEneX+10, posEneY+20, 10, 10);
        enemigo.fillRect(posEneX+60, posEneY+20, 10, 10);
        enemigo.fillRect(posEneX+20, posEneY+0, 40, 50);
        enemigo.fillRect(posEneX+10, posEneY+50, 10, 10);
        enemigo.fillRect(posEneX+60, posEneY+50, 10, 10);
        enemigo.fillRect(posEneX+0, posEneY+60, 10, 10);
        enemigo.fillRect(posEneX+70, posEneY+60, 10, 10);
        enemigo.fillRect(posEneX+30, posEneY+50, 20, 10);
        enemigo.fillRect(posEneX+20, posEneY+60, 10, 10);
        enemigo.fillRect(posEneX+50, posEneY+60, 10, 10);*/
        
        
    }

    public int getPosEneX() {
        return posEneX;
    }

    public void setPosEneX(int posEneX) {
        this.posEneX = posEneX;
    }

    public int getPosEneY() {
        return posEneY;
    }

    public void setPosEneY(int posEneY) {
        this.posEneY = posEneY;
    }
    
    

    public int getTiroX1() {
        return tiroX[0];
    }
    
    public int getTiroX2() {
        return tiroX[1];
    }
    
    public int getTiroX3() {
        return tiroX[2];
    }
    
    public int[] getTiroX() {
        return tiroX;
    }

    public void setTiroX(int[] tiroX) {
        this.tiroX = tiroX;
    }
    
    public void setTiroX1(int tiroX) {
        this.tiroX[0] = tiroX;
    }
    
    public void setTiroX2(int tiroX) {
        this.tiroX[1] = tiroX;
    }
    
    public void setTiroX3(int tiroX) {
        this.tiroX[2] = tiroX;
    }
    
    public int[] getTiroY() {
        return tiroY;
    }
    
    public int getTiroY1() {
        return tiroY[0];
    }
    
    public int getTiroY2() {
        return tiroY[1];
    }
    
    public int getTiroY3() {
        return tiroY[2];
    }

    public void setTiroY(int[] tiroY) {
        this.tiroY = tiroY;
    }
    
    public void setTiroY1(int tiroY) {
        this.tiroY[0] = tiroY;
    }
    
    public void setTiroY2(int tiroY) {
        this.tiroY[1] = tiroY;
    }
    
    public void setTiroY3(int tiroY) {
        this.tiroY[2] = tiroY;
    }

    public int getNaveX() {
        return naveX;
    }

    public void setNaveX(int naveX) {
        this.naveX = naveX;
    }

    public int getNaveY() {
        return naveY;
    }

    public void setNaveY(int naveY) {
        this.naveY = naveY;
    }

    
    
}
