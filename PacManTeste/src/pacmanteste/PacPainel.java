package pacmanteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class PacPainel extends JPanel implements Runnable, KeyListener {

    private Movimentos dir;
    private Thread anima;
    private ComeCome C;
    private Cenario cenario;
    private Comida[][] comida;
    
    public PacPainel(){
        this.setBackground(Color.BLACK);
        this.setSize(700, 700);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        this.cenario = new Cenario();
        this.C = new ComeCome();
        this.comida = new Comida[13][13];
        for(int i = 0; i < 13; i++)
            for(int j = 0; j < 13; j++){
                if(j < 6)
                    this.comida[i][j] = new Comida(55*i+10, 55*j+10);
                else //if(j == 6)
                    //this.comida[i][j] = new Comida(55*i+10+5, 55*j+10);
                //else
                    this.comida[i][j] = new Comida(700-70*i+20, 700-50*(j-5)-20);
            }
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        this.starGame();
    }
    
    public void starGame(){
        if(this.anima == null){
            this.anima = new Thread(this);
            this.anima.start();
        }
    }
    
    @Override
    public void run() {
        while(true){
            this.gameUpDate();
            this.repaint();
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void gameUpDate(){
        this.C.move(dir, this.cenario.colid(this.C.getCx(), this.C.getCy(), this.dir));
        for(int i = 0; i < 13; i++)    
            for(int j = 0; j < 13; j++)
                this.comida[i][j].foiComida(this.C.getCx(), this.C.getCy());
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i = 0; i < 13; i++)
            for(int j = 0; j < 13; j++)
                this.comida[i][j].draw(g);
        this.cenario.draw(g);
        this.C.draw(g);
        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            this.dir = Movimentos.LEFT;
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.dir = Movimentos.RIGTH;
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            this.dir = Movimentos.DOWN;
        }else if(ke.getKeyCode() == KeyEvent.VK_UP){
            this.dir = Movimentos.UP;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}
