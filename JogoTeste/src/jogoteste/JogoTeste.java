package jogoteste;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class JogoTeste extends JFrame implements ActionListener{

    Grafico gr = new Grafico();
        
    Timer time;
    
    public void Janela(){
        this.setTitle("Joao Paulo");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(gr);
        this.time = new Timer(2, this);
        this.time.start();
    }
    
    public static void main(String[] args) {
        JogoTeste a = new JogoTeste();
        a.Janela();
        a.control();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        jogar();
        maquina();
    }
    
    public void maquina(){
        gr.setYy(gr.getBy()-50);
    }
    
    public void jogar(){
        gr.setBx(gr.getBx()+gr.getVx());
        gr.setBy(gr.getBy()+gr.getVy());
        
        if(gr.getBx() > 705 && gr.getBx() < 710 && gr.getBy() > gr.getYy() && gr.getYy() < gr.getYy()+100)
            gr.setVx(-1*gr.getVx());
        if(gr.getBx() < 40 && gr.getBx() > 30 && gr.getBy() > gr.getPy() && gr.getBy() < gr.getPy()+100)
            gr.setVx(-1*gr.getVx());
        if(gr.getBy() > 500 || gr.getBy() <= 40)
            gr.setVy(-1*gr.getVy());
        if(gr.getBx() < -40 ||gr.getBx() > 1000){
            gr.setVx(2);
            gr.setVy(gr.getVx());
            gr.setBx(100+(int)((int)1000/Math.random())%200);
        }
        
        gr.repaint();
    }
    
    public void control(){
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_DOWN && gr.getPy() < 420)
                    gr.setPy(gr.getPy()+30);
                else if(ke.getKeyCode() == KeyEvent.VK_UP && gr.getPy() > 40)
                    gr.setPy(gr.getPy()-30);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if(ke.getKeyCode() == KeyEvent.VK_DOWN && gr.getPy() < 420)
                    gr.setPy(gr.getPy()+30);
                else if(ke.getKeyCode() == KeyEvent.VK_UP && gr.getPy() > 40)
                    gr.setPy(gr.getPy()-30);
                    
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                
            }
        });
    }
    
}
