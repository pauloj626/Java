package primeiraanimação;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PrimeiraAnimação extends JFrame{

    ImageIcon iconParede = new ImageIcon(getClass().getResource("Parede.jpg"));
    ImageIcon iconUnMove = new ImageIcon(getClass().getResource("spiderman.jpg"));
    ImageIcon iconMove = new ImageIcon(getClass().getResource("spiderman3.gif"));
    
    JLabel lblParede = new JLabel(iconParede);
    JLabel lblSpider = new JLabel(iconMove);
    
    int posX = 300;
    int posY = 300;
    
    public PrimeiraAnimação(){
        edit();
        editIcon();
        move();
    }
    
    public void move(){
        addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent ke) {
                
            }

            public void keyPressed(KeyEvent ke) {
                //System.out.println(ke.getKeyCode());
                lblSpider.setIcon(iconMove);
                if(ke.getKeyCode() == 37){
                    posX -= 10;
                }
                if(ke.getKeyCode() == 39){
                    posX += 10;
                }
                if(ke.getKeyCode() == 38){
                    posY -= 10;
                }
                if(ke.getKeyCode() == 40){
                    posY += 10;
                }
                if(ke.getKeyCode() == 85){
                    posX -= 7;
                    posY -= 7;
                }
                if(ke.getKeyCode() == 75){
                    posX += 7;
                    posY += 7;
                }
                
                lblSpider.setBounds(posX, posY, 114, 201);
            }

            public void keyReleased(KeyEvent ke) {
                 lblSpider.setIcon(iconUnMove);
            }
            
        });
    }
    
    public void editIcon(){
        lblParede.setBounds(0, 0, 940, 940);
        lblSpider.setBounds(posX, posY, 114, 201);
    }
    
    public void edit(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(940, 940);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        add(lblSpider);
        add(lblParede);
    }
    
    public static void main(String[] args) {
        new PrimeiraAnimação();
    }
    
}
