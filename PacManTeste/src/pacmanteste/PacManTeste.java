package pacmanteste;

import javax.swing.JFrame;

public class PacManTeste {

    public static void main(String[] args) {
        PacPainel pacpanel = new PacPainel();
        JFrame frame = new JFrame();
        frame.getContentPane().add(pacpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(710, 705);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
