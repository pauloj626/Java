package jogodacombrinhateste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class CobraPainel extends JPanel implements Runnable ,KeyListener{
    private Cobra C;
    private Comida food;
    private Thread anima;
    private Mov dir;

    public CobraPainel() {
        this.setBackground(Color.WHITE);
        this.setSize(800, 720);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        this.food = new Comida();
        this.C = new Cobra();
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        this.startGame();
    }
    
    public void startGame(){
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
                Thread.sleep(100);
            }catch(InterruptedException e){
            }
        }
    }
    
    public void gameUpDate(){
        if(this.C.morreu()){
            //this.dir = Mov.STOPED;
            this.C = new Cobra();
        }else if(this.food.foiComida(this.C.getpX() , this.C.getpY())){
            this.C.addNewPartCobra();
            this.food = new Comida();
        }
        this.C.move(this.dir);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.food.draw(g);
        this.C.draw(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, 793, 690);
        g.drawRect(1, 1, 791, 688);
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT && this.C.getDir() != Mov.RIGHT){
            this.dir = Mov.LEFT;
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT && this.C.getDir() != Mov.LEFT){
            this.dir = Mov.RIGHT;
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN && this.C.getDir() != Mov.UP){
            this.dir = Mov.DOWN;
        }else if(ke.getKeyCode() == KeyEvent.VK_UP && this.C.getDir() != Mov.DOWN){
            this.dir = Mov.UP;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
