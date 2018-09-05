package zumbigameteste;

import javax.swing.JFrame;

public class ZumbiGameTeste {

    public static void main(String[] args) {
        ZumbiPainel zumbipainel = new ZumbiPainel();
        JFrame frame = new JFrame();
        frame.getContentPane().add(zumbipainel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1040, 740);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
