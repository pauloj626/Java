package reversi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;

public class Peça extends JButton {
    private static int tamanho = 64;
    private Estado estado;
    
    public Peça(){
        super();
        estado = Estado.VAZIO;
    }
    
    @Override
    public Dimension getMaximumSize() { return getPreferredSize(); }
    @Override
    public Dimension getMinimumSize() { return getPreferredSize(); }
    @Override
    public Dimension getPreferredSize() { return new Dimension(tamanho,tamanho); }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        //não preenchemos butões vazios
        if(this.estado != Estado.VAZIO){
            if(this.estado == Estado.BRANCO)
                g2D.setColor(Color.WHITE);
            else if(this.estado == Estado.PRETO)
                g2D.setColor(Color.BLACK);
            g2D.fillOval(6, 6, this.getWidth()-12, this.getHeight()-12);
        }
        //pintando borda da peça independente do estado
        g2D.setColor(Color.GRAY);
        g2D.drawOval(6, 6, this.getWidth()-12, this.getHeight()-12);
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
}
