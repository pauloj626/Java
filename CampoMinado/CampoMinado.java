package campominado;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CampoMinado extends JFrame{

    int[][] MB = new int[7][6];
    {
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                MB[i][j] = 0;
    }
    
    int[][] MN = new int[7][6];
    {
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                MN[i][j] = 0;
    }
    
    boolean[][] MTF = new boolean[7][6];
    {
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                MTF[i][j] = true;
    }
    
    ImageIcon[] Icon = new ImageIcon[11];
        {
            for(int i = 0; i < 10; i++)
                Icon[i] = new ImageIcon(getClass().getResource(Integer.toString(i)+".jpg"));
            Icon[10] = new ImageIcon(getClass().getResource("Inicio.jpg"));
        }
        
    JLabel[][] lblIcon = new JLabel[7][6];
        {
            for(int i = 0; i < 7; i++)
                for(int j = 0; j < 6; j++)
                    lblIcon[i][j] = new JLabel(Icon[10]);
        }
    
    JButton btnRest = new JButton("RESTART");
        
    
    
    public CampoMinado(){
        janela();
        initIcon();
        JOptionPane.showMessageDialog(null, "Para iniciar o Jogo click em restart");
        clickLabel();
    }
        
    public void clickLabel(){
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent me) {
                //System.out.println(me.getX());
                mostBomb(posClick(me.getX(), me.getY()));
            }
            public void mousePressed(MouseEvent me) {}
            public void mouseReleased(MouseEvent me) {}
            public void mouseEntered(MouseEvent me) {}
            public void mouseExited(MouseEvent me) {}
        });
    }
    
    public void mostBomb(int[] v){
        if(MB[v[0]][v[1]] == 1){
            lblIcon[v[0]][v[1]].setIcon(Icon[9]);
            JOptionPane.showMessageDialog(null, "Vc perdeu, click em restart se deseja um novo jogo");
        }else if(MN[v[0]][v[1]] != 0){
            lblIcon[v[0]][v[1]].setIcon(Icon[MN[v[0]][v[1]]]);
            MTF[v[0]][v[1]] = false;
        }else
            mostNum(v[0], v[1]);
    }
    
    public void mostNum(int i, int j){
        if(MB[i][j] == 0){
            lblIcon[i][j].setIcon(Icon[MN[i][j]]);
            if(MTF[i][j]){
                MTF[i][j] = false;
                if((i == 0)&&(j == 0)){
                    for(int k = 0; k < 2; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[k][w] != 0)
                                MTF[k][w] = false;
                            mostNum(k, w);}
                }else if((i == 0)&&(j == 5)){
                    for(int k = 0; k < 2; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[k][5-w] != 0)
                                MTF[k][5-w] = false;
                            mostNum(k, (5-w));}
                }else if((i == 6)&&(j == 0)){
                    for(int k = 0; k < 2; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[6-k][w] != 0)
                                MTF[6-k][w] = false;
                            mostNum(6-k, w);}
                }else if((i == 6)&&(j == 5)){
                    for(int k = 0; k < 2; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[6-k][5-w] != 0)
                                MTF[6-k][5-w] = false;
                            mostNum(6-k, 5-w);}
                }else if(i == 0){
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[w][j+1-k] != 0)
                                MTF[w][j+1-k] = false;
                            mostNum(w, j+1-k);}
                }else if(i == 6){
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[6-w][j+1-k] != 0)
                                MTF[w][j+1-k] = false;
                            mostNum(6-w, j+1-k);}
                }else if(j == 0){
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[i+1-k][w] != 0)
                                MTF[i+1-k][w] = false;
                            mostNum(i+1-k, w);}
                }else if(j == 5){
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 2; w++){
                            if(MN[i+1-k][5-w] != 0)
                                MTF[i+1-k][5-w] = false;
                            mostNum(i+1-k, 5-w);}
                }else{
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 3; w++){
                            if(MN[i+1-k][j+1-w] != 0)
                                MTF[i+1-k][j+1-w] = false;
                            mostNum(i+1-k,j+1-w);
                        }
                }
            }
        }
    }
    
    public void numMB(){
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++){
                if((i == 0)&&(j == 0))
                    MN[i][j] = MB[0][0]+MB[0][1]+MB[1][0]+MB[1][1];
                else if((i == 0)&&(j == 5))
                    MN[i][j] = MB[1][5]+MB[1][4]+MB[0][4]+MB[0][5];
                else if((i == 6)&&(j == 0))
                    MN[i][j] = MB[i][j]+MB[6][1]+MB[5][1]+MB[5][0];
                else if((i == 6)&&(j == 5))
                    MN[i][j] = MB[i][j]+MB[6][4]+MB[5][5]+MB[5][4];
                else if(i == 0)
                    MN[i][j] = MB[0][j]+MB[0][j-1]+MB[0][j+1]+MB[1][j]+MB[1][j-1]+MB[1][j+1];
                else if(i == 6)
                    MN[i][j] = MB[6][j]+MB[6][j-1]+MB[6][j+1]+MB[5][j]+MB[5][j-1]+MB[5][j+1];
                else if(j == 0)
                    MN[i][j] = MB[i][0]+MB[i-1][0]+MB[i+1][0]+MB[i][1]+MB[i-1][1]+MB[i+1][1];
                else if(j == 5)
                    MN[i][j] = MB[i][5]+MB[i-1][5]+MB[i+1][5]+MB[i][4]+MB[i-1][4]+MB[i+1][4];
                else{
                    for(int k = 0; k < 3; k++)
                        for(int w = 0; w < 3; w++){
                            MN[i][j]+=MB[i+1-k][j+1-w];
                        }
                }
            }
    }
    
    public int[] posClick(int x, int y){
        int[] v = new int[2];
        v[0] = (int) Math.floor(x/90);
        v[1] = (int) Math.floor(y/90);
        return v;
    }
    
    public void initIcon(){
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                lblIcon[i][j].setBounds(90*i,90*j , 90, 90);
        btnRest.setBounds(650+10, 90, 100, 50);
        btnRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestActionPerformed(evt);
            }
        });
        
    }
    
    public void btnRestActionPerformed(java.awt.event.ActionEvent evt){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 6; j++){
                MB[i][j] = 0;
                MN[i][j] = 0;
                MTF[i][j] = true;
                lblIcon[i][j].setIcon(Icon[10]);
            }
        }
        int a, b;
        int k = 0;
        while(k < 6){
            a = ((int)(((int)7/(Math.random()))%7));
            b = ((int)(((int)6/(Math.random()))%6));
            if(MB[a][b] == 0){
                MB[a][b] = 1;
                MTF[a][b] = false;
                k += 1;
            }
        }
        numMB();
    }
        
    public void janela(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650+150, 580);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setVisible(true);
        setLayout(null);
        add(btnRest);
        for(int i = 0; i < 7; i++)
            for(int j = 0; j < 6; j++)
                add(lblIcon[i][j]);
    }    
    
    public static void main(String[] args) {
        CampoMinado campoMinado = new CampoMinado();
        System.out.println(campoMinado.lblIcon.length);
    }
    
}
