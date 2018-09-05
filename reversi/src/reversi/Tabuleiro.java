package reversi;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel{
    private Peça[][] tabuleiro;
    
    public Tabuleiro(){
        this.setLayout(new GridLayout(8,8));
        tabuleiro = new Peça[8][8];
        for(int i = 0; i < tabuleiro.length ; i++)
            for(int j = 0; j < tabuleiro.length; j++)
            {
                tabuleiro[i][j] = new Peça();
                this.add(this.tabuleiro[i][j]);
            }
        this.tabuleiro[3][3].setEstado(Estado.BRANCO);
        this.tabuleiro[3][4].setEstado(Estado.PRETO);
        this.tabuleiro[4][3].setEstado(Estado.PRETO);
        this.tabuleiro[4][4].setEstado(Estado.BRANCO);
    }
    
}
