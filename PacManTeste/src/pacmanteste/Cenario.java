package pacmanteste;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Cenario {
    
    ImageIcon cen = new ImageIcon(getClass().getResource("Cenario.png"));
    
    public boolean colid(int x, int y, Movimentos dir){
        if(dir == Movimentos.LEFT){
            if((x == 155)&&(y > 5)&&(y < 155)) // colisão com 1°quadrado
                return false;
            else if((x == 645)&&(y > 5)&&(y < 155))//colisão com 2°quadrado(simetrica)
                return false;
            else if((x == 155)&&(y > 165)&&(y < 270))//colisão com 1° retangulo
                return false;
            else if((x == 645)&&(y > 165)&&(y < 270))//colisão com 2° retangulo(simetrico ao 1°)
                return false;
            else if((x == 260)&&(y < 205))//colisão com 3° retangulo
                return false;
            else if((x == 490)&&(y < 205))//colisão com 4° retangulo (simetrico ao 3°)
                return false;
            else if((x == 385)&&(y > 5)&&(y < 315))//colisão com 5° retangulo
                return false;
            else if((x == 200)&&(y > 275)&&(y < 355))//colisão com 6° retangulo. Não há colisão pela esquerda com o 7° retangulo
                return false;
            else if((x == 200)&&(y > 370)&&(y < 450))//colisão com 8° retangulo. Não há colisão pela esqurda com o 9° retangulo
                return false;
            else if((x == 300)&&(y > 420)&&(y < 600))//para o poligono 1
                return false;                        //Para o poligono 1
            else if((x == 430)&&(y > 420)&&(y <= 520))//colisão com o poligono 2
                return false;
            else if((x == 630)&&(y > 520)&&(y < 600))  //colisão com o poligono 2
                return false;
            else 
                return true;
        }else if(dir == Movimentos.RIGTH){
            if((x == 5)&&(y > 5)&&(y < 155)) //1° quadrado
                return false;
            else if((x == 495)&&(y > 5)&&(y < 155))//2°quadrado
                return false;
            else if((x == 5)&&(y > 165)&&(y < 270))//1° retangulo
                return false;
            else if((x == 495)&&(y > 165)&&(y < 270))//2° retangulo
                return false;
            else if((x == 160)&&(y < 205))//3° retangulo
                return false;
            else if((x == 390)&&(y < 205))//4° retangulo
                return false;
            else if((x == 265)&&(y > 5)&&(y < 315))//5° retangulo. Não há colisão pela direita com o 6°retangulo
                return false;
            else if((x == 450)&&(y > 275)&&(y < 355))//colisão com o 7° retangulo. Não há colisão pela direita com o 8° retangulo
                return false;
            else if((x == 450)&&(y > 370)&&(y < 450))//colisão com o 9° retangulo
                return false;
            else if((x == 220)&&(y > 420)&&(y <= 520))//colisão com o poligono 1
                return false;
            else if((x == 20)&&(y > 520)&&(y < 600))//colisão com o poligono 1
                return false;
            else if((x == 350)&&(y > 420)&&(y < 600))//para o poligono 2
                return false;
            else
                return true;
        }else if(dir == Movimentos.DOWN){
            if((x > 5)&&(x < 155)&&(y == 5))//1°quadrado
                return false;
            else if((x > 495)&&(x < 645)&&(y == 5))//2°quadrado
                return false;
            else if((x > 5)&&(x < 155)&&(y == 165))//1°retangulo
                return false;
            else if((x > 495)&&(x < 645)&&(y == 165))//2°retangulo. Não colisão por baixo no 3° e 4°retangulo
                return false;
            else if((x > 265)&&(x < 385)&&(y == 5))//5°retangulo
                return false;
            else if((x < 200)&&(y == 275))//6°retangulo
                return false;
            else if((x > 450)&&(y == 275))//7°retangulo
                return false;
            else if((x < 200)&&(y == 370))//8°retangulo
                return false;
            else if((x > 450)&&(y == 370))//9°retangulo
                return false;
            else if((x > 220)&&(x < 300)&&(y == 420)) //poligono 1
                return false;
            else if((x > 20)&&(x < 270)&&(y == 520)) //poligono 1 
                return false;
            else if((x > 350)&&(x < 430)&&(y == 420)) //poligono 1
                return false;
            else if((x > 380)&&(x < 630)&&(y == 520)) //poligono 1 
                return false;
            else
                return true;
        }else if(dir == Movimentos.UP){
            if((x > 5)&&(x < 155)&&(y == 155))//1°quadrado
                return false;
            else if((x > 495)&&(x < 645)&&(y == 155))//2°quadrado
                return false;
            else if((x > 5)&&(x < 155)&&(y == 270))//1°retangulo
                return false;
            else if((x > 495)&&(x < 645)&&(y == 275))//2°retangulo
                return false;
            else if((x > 160)&&(x < 260)&&(y == 210))//3°retangulo
                return false;
            else if((x > 390)&&(x < 490)&&(y < 210))//4°retangulo
                return false;
            else if((x > 265)&&(x < 385)&&(y == 315))//5°retangulo
                return false;
            else if((x < 200)&&(y == 355))//6°retangulo
                return false;
            else if((x > 450)&&(y == 355))//7°retangulo
                return false;
            else if((x < 200)&&(y == 450))//8°retangulo
                return false;
            else if((x > 450)&&(y == 450))//9°retangulo
                return false;
            else if((x > 20)&&(x < 300)&&(y == 600))//poligono1
                return false;
            else if((x > 350)&&(x < 630)&&(y == 600))//poligono2
                return false;
            else
                return true;
        }else{
            return true;
        }
    }
    
    public void draw(Graphics g){
        g.setColor(java.awt.Color.LIGHT_GRAY);
        //g.drawImage(cen.getImage(), -15, -20, null);
        //Desenhado cenario (posteriomente será uma unica imagem)
        g.fillRect(55, 55, 100, 100);//1°quadrado
        g.fillRect(545,55,100,100);//2°quadrado(simetrico ao 1°)
        g.fillRect(55,215,100,55);//1°retangulo
        g.fillRect(545, 215, 100, 60);//2°retangulo(simetrico ao 1°)
        g.fillRect(210, 0, 50, 210);//3°retangulo
        g.fillRect(440, 0, 50, 210);//4°retangulo(simetrico ao 3°)
        g.fillRect(315, 55, 70, 260);//5°retangulo
        g.fillRect(0, 325, 200, 30);//6°retangulo
        g.fillRect(500, 325, 200, 30);//7°retangulo (simetrico ao 6°)
        g.fillRect(0, 420, 200, 30);//8°retangulo
        g.fillRect(500, 420, 200, 30);//9°retangulo (simetrico ao 8°)
        g.fillRect(270, 470, 30, 100);//10°retangulo (faz parte do poligono1)
        g.fillRect(70, 570, 230, 30);//11°retangulo (faz parte do poligono1)
        g.fillRect(400, 470, 30, 100);//12°retangulo (faz parte do poligono2)
        g.fillRect(400, 570, 230, 30);//13°retangulo (faz parte do poligono2)
    }
}
