package naveteste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class NaveTeste extends JFrame implements ActionListener{

    Nave a = new Nave();
    Timer time;
    int nTr = 1;
    int[] kx = new int[3];
    {
        for(int i = 0; i < 3; i++)
            kx[i] = -10;
    }
    int[] ky = new int[3];
    {
        for(int i = 0; i < 3; i++)
            ky[i] = -10;
    }
    
    public void naveTest(){
        this.setTitle("Joao Paulo");
        this.setSize(700, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(a);
        this.time = new Timer(2, this);
        this.time.start();
    }
    
    public static void main(String[] args){
        NaveTeste naveTeste = new NaveTeste();
        naveTeste.naveTest();
        naveTeste.controle();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JogoTiro();
        Ene();
        a.repaint();
    }
    
    public void Ene(){
        if(a.getTiroX1() > a.getPosEneX() && (a.getTiroX1() < (a.getPosEneX()+70)) && (a.getPosEneY()+70 > a.getTiroY1()) && (a.getPosEneY() < a.getTiroX1())){
            a.setTiroX1(-100);
            a.setTiroY1(-100);
            System.out.println(a.getPosEneX()+"\n"+a.getPosEneY());
            a.setPosEneX(100+(int)((int)10000/(Math.random()))%521);
            a.setPosEneY((int)((int)10000/(Math.random()))%440);
            System.out.println(a.getPosEneX()+"\n"+a.getPosEneY());
        }
    }
    
    public void JogoTiro(){
        if(nTr == 1){
            a.setTiroY1(a.getTiroY1()-2);
        }else if(nTr == 3 && a.getTiroY1() > 0){
            a.setTiroY2(a.getTiroY2()-2);
            a.setTiroY1(a.getTiroY1()-2);
        }else if(a.getTiroY1() < 0){
            a.setTiroY2(a.getTiroY2()-2);
            a.setTiroY1(a.getTiroY1()-2);
            a.setTiroY3(a.getTiroY3()-2);
        }
        
        
        
    }

    public void controle(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                    a.setNaveX(a.getNaveX()-10);
                }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                    a.setNaveX(a.getNaveX()+10);
                }else if(ke.getKeyCode() == KeyEvent.VK_UP && a.getTiroY1() < 0){ nTr = 1;
                    if(nTr == 1){
                        a.setTiroX1(a.getNaveX()+20);
                        a.setTiroY1(a.getNaveY());
                        nTr = 1;
                    }else if(nTr == 2){
                        a.setTiroX2(a.getNaveX()+20);
                        a.setTiroY2(a.getNaveY());
                        nTr++;
                    }else{
                        a.setTiroX2(a.getNaveX()+20);
                        a.setTiroY2(a.getNaveY());
                        nTr = 1;
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                    a.setNaveX(a.getNaveX()-10);
                }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                    a.setNaveX(a.getNaveX()+10);
                }else if(ke.getKeyCode() == KeyEvent.VK_UP && a.getTiroY1() < 0){ nTr = 1;
                    if(nTr == 1){
                        a.setTiroX1(a.getNaveX()+20);
                        a.setTiroY1(a.getNaveY());
                        nTr = 1;
                    }else if(nTr == 2){
                        a.setTiroX2(a.getNaveX()+20);
                        a.setTiroY2(a.getNaveY());
                        nTr++;
                    }else if(nTr == 3){
                        a.setTiroX2(a.getNaveX()+20);
                        a.setTiroY2(a.getNaveY());
                        nTr = 1;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
    }
    
}
