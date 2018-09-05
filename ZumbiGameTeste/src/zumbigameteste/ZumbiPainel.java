package zumbigameteste;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ZumbiPainel extends JPanel implements Runnable, KeyListener{

    private Player player;
    private ArrayList<Zumbi> zumbi;
    private Tiro tiro;
    private Thread anima;
    private Mov dir;
    //variavel de controle de tiros e controle de zumbi
    private int a;
    private int tempZumbi; // tempo de espera para aparecer zumbi
    private int numZumbi;
    
    public ZumbiPainel(){
        this.setBackground(Color.WHITE);
        this.setSize(800, 720);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(this);
        this.player = new Player();
        this.zumbi = new ArrayList();
        this.zumbi.add(new Zumbi());
        this.numZumbi = 1;
        this.tempZumbi = 0;
        this.tiro = new Tiro();
        this.a = 0;
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
            this.repaint();
            this.gameUpDate();
            
            try{
                Thread.sleep(50);
                this.tempZumbi++;
            }catch(InterruptedException e){
                
            }
        }
    }
    
    public void gameUpDate(){
        this.player.move(this.dir);
        for(int i = 0; i < this.numZumbi; i++){
            this.zumbi.get(i).move(this.player.getPosX(), this.player.getPosY());
            //Se o Player morrer é apresentado uma mensagem
            if(this.player.matouPlayer(this.zumbi.get(i).getPosX(), this.zumbi.get(i).getPosX())){
                JOptionPane.showMessageDialog(null, "Você Morreu, o Jogo será reiniciado");
                this.restart();
            }
            
        }
        if(this.tempZumbi >= 40){
            this.zumbi.add(new Zumbi());
            this.numZumbi++;
            this.tempZumbi = 0;
        }
        if(a == 1){
            //if(this.zumbi.morreuZumbi(this.tiro.getPosX(), this.tiro.getPosY())){
              //  this.zumbi = new Zumbi();
            //}
            this.tiro.move();
            if(this.tiro.saiuDaTela()){
                this.a = 0;
                this.tiro.setAtivo(false);
            }
        }
    }
    
    public void restart(){
        this.zumbi.clear();
        this.numZumbi = 1;
        this.zumbi.add(new Zumbi());
        this.player = new Player();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.player.draw(g);
        this.zumbi.forEach((zumb) -> {zumb.draw(g);});
        this.tiro.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            this.dir = Mov.LEFT;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.dir = Mov.RIGHT;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN ){
            this.dir = Mov.DOWN;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_UP){
            this.dir = Mov.UP;
            this.tiro.setDir(this.dir);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_LEFT){
            this.dir = Mov.LEFT;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
            this.dir = Mov.RIGHT;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_DOWN ){
            this.dir = Mov.DOWN;
            this.tiro.setDir(this.dir);
        }else if(ke.getKeyCode() == KeyEvent.VK_UP){
            this.dir = Mov.UP;
            this.tiro.setDir(this.dir);
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        this.player.setDir(Mov.STOPED);
    }
    
    
}
