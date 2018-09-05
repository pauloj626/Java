package rabisco;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JComponent;

public class ComponenteParaRabiscos extends JComponent 
        implements MouseListener,  MouseMotionListener, KeyListener {
    
    private ArrayList<Point> pontos;
    private int size = 8;
    private int halfsize = size/2;
    private Color cor;
    
    
    public ComponenteParaRabiscos(Color cor) {
        this.cor = cor;
        this.pontos = new ArrayList<Point>(1024);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(false);//não conheço
        this.requestFocus();//não conheço
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        //não conheço
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.setColor(this.cor);
        for(Point p: this.pontos){
            g2D.fillOval(p.x-this.halfsize, p.y-this.halfsize, size, size);
        }
    }
    
    
    @Override
    public void mousePressed(MouseEvent me) {
        this.pontos.add(me.getPoint());
        this.repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent me) {
        this.pontos.add(me.getPoint());
        this.repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        this.requestFocus();
    }
    
//******************NÂO USADOS*********************
    @Override                                   //*
    public void mouseClicked(MouseEvent me) {}  //*
    @Override                                   //*
    public void mouseReleased(MouseEvent me) {} //*
    @Override                                   //*
    public void mouseExited(MouseEvent me) {}   //*
    @Override                                   //*
    public void mouseMoved(MouseEvent me) {}    //*
//*************************************************
    
    @Override
    public void keyPressed(KeyEvent ke) {
        //System.out.println(ke.getKeyCode());
        if(ke.getKeyCode() == KeyEvent.VK_C){
            this.pontos.clear();
            this.repaint();
        }
    }
    
//******************NÃO USADOS******************    
    @Override                                //*
    public void keyTyped(KeyEvent ke) {}     //*
    @Override                                //*
    public void keyReleased(KeyEvent ke) {}  //*
//**********************************************    


}
