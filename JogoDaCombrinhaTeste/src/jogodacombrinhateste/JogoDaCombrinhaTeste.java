package jogodacombrinhateste;

import javax.swing.JFrame;

public class JogoDaCombrinhaTeste {

    public static void main(String[] args) {
        CobraPainel cobrapainel = new CobraPainel();
        JFrame frame = new JFrame();
        frame.getContentPane().add(cobrapainel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 720);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
}
