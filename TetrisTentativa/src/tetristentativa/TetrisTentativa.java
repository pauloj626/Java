package tetristentativa;

import javax.swing.JFrame;

public class TetrisTentativa {

    public static void main(String[] args) {
        TetrPainel t = new TetrPainel();
        JFrame fr = new JFrame("Tetriz tentativa");
        fr.getContentPane().add(t);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(410, 670);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
    
}
