package relacioclassbasic;

public class RelacioClassBasic {

    public static void main(String[] args) {
        Lutador[] l = new Lutador[6];
        l[0] = new Lutador("0", "Fr",31, 1.75f, 68.9f, 11, 2, 1);
        l[1] = new Lutador("1", "Br",31, 1.68f, 57.8f, 14, 2, 3); 
        l[2] = new Lutador("2", "EUA",35, 1.65f, 80.9f, 12, 2, 1); 
        l[3] = new Lutador("3", "Aus",28, 1.93f, 81.6f, 13, 0, 2); 
        l[4] = new Lutador("4", "Br",37, 1.70f, 119.3f, 5, 4, 3); 
        l[5] = new Lutador("5", "EUA",30, 1.81f, 105.7f, 12, 2, 4); 
        
        Luta lutar = new Luta();
        
        lutar.marcarLuta(l[0], l[1]);
        
        lutar.lutar();
        
    }
    
}
