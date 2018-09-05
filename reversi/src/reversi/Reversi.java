package reversi;

import javax.swing.JFrame;

public class Reversi extends JFrame{
    
    public Reversi(){
        super("Reversi");
        this.getContentPane().add(new Tabuleiro());
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        Reversi reversi = new Reversi();
    }
    
}
