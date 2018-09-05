package gravidade;

import java.awt.Color;
import java.awt.Graphics;

public class Planeta {
    private double  posX, posY; /*posição*/
    private double vX, vY; /*velocidade*/
    private double aX, aY; /*aceleração*/
    private double massa; /*Massa do corpo*/
    private double raio; /*raio do planeta*/
    
    /*Variáveis para metodos númericos
    private double paX = 0, paY = 0; /posições anteriores
    private double aaX = 0, aaY = 0; /acelerações anteriores*/
    
    public Planeta(double x, double y, double vX, double vY, double M){
        this.posX = x;
        this.posY = y;
        this.vX = vX;
        this.vY = vY;
        this.aX = 0;
        this.aY = 0;
        this.massa = M;
        this.raio = 20*(1-Math.exp(-Math.pow(M,0.1)/5));
    }
    
    /*public void movePlaneta(){
        this.paX = this.posX;
        this.paY = this.posY;
        this.aaX = this.aX;
        this.aaY = this.aY;
        this.vX += this.aX;
        this.vY += this.aY;
        this.posX += this.vX;
        this.posY += this.vY;
    }
    
    public void moveComCorrecao(){
        this.vX += (this.aX-this.aaX)/2;
        this.vY += (this.aY-this.aaY)/2;
        this.posX = this.paX+this.vX-(this.aX+this.aaX)/4;
        this.posY = this.paY+this.vY-(this.aY+this.aaY)/4;
    }*/
    
    public void movePlaneta(){
        this.vX += this.aX/2;
        this.vY += this.aY/2;
        this.posX += this.vX;
        this.posY += this.vY;
    }
    
    public void draw(Graphics g){
        if(this.massa <= 50)
            g.setColor(Color.GRAY);
        else if(this.massa <= 500)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.RED);
        g.fillOval((int)((int)this.posX - (int)this.raio),(int)( (int)this.posY -(int)this.raio),(int) (2*this.raio), (int) (2*this.raio));
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getaX() {
        return aX;
    }

    public void setaX(double aX) {
        this.aX = aX;
    }

    public double getaY() {
        return aY;
    }

    public void setaY(double aY) {
        this.aY = aY;
    }

    public double getMassa() {
        return massa;
    }

    public double getRaio() {
        return raio;
    }
}
