import java.awt.*;
import java.util.*;
import javax.swing.JApplet;

public class PrimeiroApplet extends JApplet {

    private Color butterscoth = new Color(255,204,102);
    private String lastTime = " ";
    
    public void init() {
        setBackground(Color.BLACK);//butterscoth);
    }
    
    public void paint(Graphics screen){
        Graphics2D screen2D = (Graphics2D) screen;
        Font type = new Font("Monospaced", Font.BOLD, 20);
        screen2D.setFont(type);
        GregorianCalendar day = new GregorianCalendar();
        String time = day.getTime().toString();
        screen2D.setColor(Color.BLACK);
        screen2D.drawString(lastTime, 5, 25);
        screen2D.setColor(Color.BLUE);//butterscoth);
        screen2D.drawString(time, 5, 25);
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            
        }
        lastTime = time;
        repaint();
        
        
    }
    
    
}
