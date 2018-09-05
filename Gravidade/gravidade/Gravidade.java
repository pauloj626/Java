package gravidade;

import java.awt.Color;
import javax.swing.JFrame;

public class Gravidade {

    public static void main(String[] args) {
        SistemaPainel S = new SistemaPainel();
        JFrame frame = new JFrame();
        frame.getContentPane().add(S);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 760);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBackground(Color.BLACK);
    }
    
}
