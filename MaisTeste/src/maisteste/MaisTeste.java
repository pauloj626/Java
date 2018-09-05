package maisteste;

import javax.swing.JFrame;

public class MaisTeste {

    public static void main(String[] args){
        Painel k = new Painel();
        JFrame frame = new JFrame();
        frame.getContentPane().add(k);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1560, 700);
        frame.setVisible(true);
    }
    
}
