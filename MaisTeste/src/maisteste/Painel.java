package maisteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Painel extends JPanel implements Runnable, KeyListener{

    private Movimentos dir;
    private Thread animacao;
    private Quadrado Q;
    private Obstaculos Ob;

    public Painel() {
        this.setBackground(Color.BLACK);
        this.setSize(500, 500);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        this.Q = new Quadrado(this.getPreferredSize());
        this.Ob = new Obstaculos();
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        this.starGame();
    }
    
    public void starGame(){
        if(this.animacao == null){
            this.animacao = new Thread(this);
            this.animacao.start();
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
    
    private void gameUpDate(){
        /*if(Q.getI() == 0){
            this.Q.move(dir);
            this.dir = Movimentos.STOPED;
        }else
            this.Q.moveUp(dir);*/
        if(Q.getI() == 0){
            this.Q.move(dir);
            this.dir = Movimentos.STOPED;
        }else if(Ob.colidirUp(Q.getQuaX(), Q.getQuaY())){
            this.Q.setI(0);
        }else if(Ob.colidirDown(Q.getQuaX(), Q.getQuaY())){
            this.Q.setQuaVy(0);
            this.Q.setI(0);
        }else if(Ob.colidirLeft(Q.getQuaX(), Q.getQuaY())){
            this.Q.setI(0);
        }else if(Ob.colidirRigth(Q.getQuaX(), Q.getQuaY())){
            this.Q.setI(0);
        }else
            this.Q.moveUp(dir);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Q.draw(g);
        Ob.draw(g);
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.darkGray);
        g1.fillRect(0, 460, 1560, 700);
        this.setBackground(Color.GRAY);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        /*if(ke.getKeyCode() == KeyEvent.VK_UP){
            this.dir = Movimentos.UP;
        }else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            this.dir = Movimentos.LEFT;
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.dir = Movimentos.RIGTH;
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            this.dir = Movimentos.DOWN;
        }*/
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            if(Q.getI() == 0)
                this.dir = Movimentos.UP;
            //}else
              //  Q.setI(0);
        }else if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            this.dir = Movimentos.LEFT;
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.dir = Movimentos.RIGTH;
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN){
            this.dir = Movimentos.DOWN;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}
    
}
