package tetristentativa;

import java.awt.Graphics;


public class Blocos {
    public Bloco1 b1;
    public Bloco2 b2;
    public Bloco3 b3;
    public int i;
    
    public Blocos(){
        i = (int)((int)100/Math.random())%3;
        if(i == 0)
            b1 = new Bloco1();
        else if(i == 1)
            b2 = new Bloco2();
        else if(i == 2)
            b3 = new Bloco3();
    }
    
    public void move(Movimentos dir){
        switch (i) {
            case 0:
                b1.move(dir);
                break;
            case 1:
                b2.move(dir);
                break;
            case 2:
                b3.move(dir);
                break;
            default:
                break;
        }
    }
    
    public void draw(Graphics g){
        switch(i){
            case 0:
                b1.draw(g);
                break;
            case 1:
                b2.draw(g);
                break;
            case 2:
                b3.draw(g);
                break;
            default:
                break;
        }
    }
    
    public int getbY(){
        switch (i) {
            case 0:
                return b1.getBy();
            case 1:
                return b2.getBy();
            case 2:
                return b3.getBy();
            default:
                return 0;
        }
    }
    
    
    
}
