package gravidade;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class SistemaPainel extends JPanel implements Runnable {

    private SistemaPlanetario solar;
    private Thread anima;

    public SistemaPainel() {
        this.setBackground(Color.WHITE);
        this.setSize(1000, 720);
        this.setFocusable(true);
        this.requestFocus();
        this.solar = new SistemaPlanetario();
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
            this.sistemUpDate();
            this.repaint();
            try{
                Thread.sleep(30);
            }catch(InterruptedException e){
            }
        }
    }
    
    public void sistemUpDate(){
        this.solar.atualizaSistema();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        this.solar.drawSistema(g);
    }
}
