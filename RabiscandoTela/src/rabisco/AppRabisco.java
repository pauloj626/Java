package rabisco;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class AppRabisco extends JFrame{
    public AppRabisco(){
        ComponenteParaRabiscos c = new ComponenteParaRabiscos(new Color(50, 120, 250));
        Container cp = this.getContentPane();
        cp.add(c);
        this.setSize(400,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args){
        new AppRabisco();
    }
    
}
