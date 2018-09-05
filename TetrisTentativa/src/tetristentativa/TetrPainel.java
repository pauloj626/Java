package tetristentativa;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class TetrPainel extends JPanel implements Runnable, KeyListener{
    private Blocos Bl;
    private Movimentos dir;
    private Thread animacao;
    private int a;

    public TetrPainel() {
        this.setBackground(Color.BLACK);
        this.setSize(420, 680);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        Bl = new Blocos();
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
            this.dir = Movimentos.STOPED;
            this.repaint();
            try{
                this.a = this.Bl.getbY();
                Thread.sleep(500);
            }catch(InterruptedException e){
                
            }
        }
    }
    
    public void gameUpDate(){
        this.Bl.move(dir);
        if(a == this.Bl.getbY())
            this.Bl = new Blocos();
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case KeyEvent.VK_LEFT:
                this.dir = Movimentos.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                this.dir = Movimentos.RIGTH;
                break;
            case KeyEvent.VK_UP:
                this.dir = Movimentos.UP;
                break;
            case KeyEvent.VK_DOWN:
                this.dir = Movimentos.DOWN;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        this.Bl.draw(g);
    }
}
