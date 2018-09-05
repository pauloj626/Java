package gravidade;

import java.awt.Graphics;
import java.util.ArrayList;

public class SistemaPlanetario {
    private ArrayList<Planeta> sisPlan;
    private int N; /*Números de planetas*/
    //private RastroPlanet rastro;
    
    public SistemaPlanetario(){
        this.sisPlan = new ArrayList<>();
        this.sisPlan.add(new Planeta(450, 350, 0, -11, 200000));
        this.sisPlan.add(new Planeta(400, 350, 0, 0, 50000));
        this.sisPlan.add(new Planeta(950, 350, 0, 10, 200000));
        this.sisPlan.add(new Planeta(600, 100, 0, 0, 100));
//        this.sisPlan.add(new Planeta(180, 350, 0, 0, 30));
//       this.sisPlan.add(new Planeta(550, 350, 0, 0, 20));
        this.N = this.sisPlan.size();
        //this.rastro = new RastroPlanet(this.sisPlan.get(1));
    }
    
    public void move(){
        this.sisPlan.forEach((planeta) -> planeta.movePlaneta());
    }
    
    /*public void moveComCorrecao(){
        this.sisPlan.forEach((planeta) -> planeta.moveComCorrecao());
    }*/
    
    /*distância de A para B*/
    public double distancia(Planeta A, Planeta B){
        return (Math.sqrt(Math.pow((A.getPosX()-B.getPosX()), 2) + Math.pow((A.getPosY()-B.getPosY()), 2)));
    }
    
    /*retorna a componente X*/
    public double compX(Planeta A, Planeta B){
        return (A.getPosX()-B.getPosX())/(this.distancia(A, B));
    }
    
    /*retorna a componente Y*/
    public double compY(Planeta A, Planeta B){
        return (A.getPosY()-B.getPosY())/(this.distancia(A, B));
    }
    
    /*calcula a aceleração*/
    public void calcAcelera(){
        double ax, ay;
        double M;
        double sen, cos;
        double d;
        for(int i = 0; i < this.N; i++){
            ax = 0;
            ay = 0;
            for(int j = 0; j < this.N; j++){
                M = this.sisPlan.get(j).getMassa();
                cos = this.compX(this.sisPlan.get(j), this.sisPlan.get(i));
                sen = this.compY(this.sisPlan.get(j), this.sisPlan.get(i));
                d = this.distancia(this.sisPlan.get(i), this.sisPlan.get(j));
                if(j != i){
                    ax += (M*cos/Math.pow(d, 2));
                    ay += (M*sen/Math.pow(d, 2));
                }
            }
            this.sisPlan.get(i).setaX(ax);
            this.sisPlan.get(i).setaY(ay);
        }
    }
    
    public void atualizaSistema(){
        this.calcAcelera();
        this.move();
        /*this.calcAcelera();
        this.moveComCorrecao();
        this.rastro.addRastroPlanet(this.sisPlan.get(1));*/
    }
    
    public void drawSistema(Graphics g){
        this.sisPlan.forEach((planeta) -> planeta.draw(g));
        //this.rastro.drawRastro(g);
    }
}
