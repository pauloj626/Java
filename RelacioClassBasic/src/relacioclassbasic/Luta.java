package relacioclassbasic;

import java.util.Random;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;
    
    public void marcarLuta(Lutador l1, Lutador l2){
        if((l1.getCategoria().equals(l2.getCategoria())) && !l1.equals(l2)){
            this.aprovada = true;
            this.desafiante = l2;
            this.desafiado = l1;
        }else{
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }
    
    public void lutar(){
        if(aprovada){
            this.desafiado.apresentar();
            System.out.println("");
            this.desafiante.apresentar();
            Random k = new Random();
            int j = k.nextInt(3);
            switch(j){
                case 0:
                    System.out.println("Empate");
                    this.desafiado.empartarLuta();
                    this.desafiante.empartarLuta();
                    break;
                case 1:
                    System.out.println(this.desafiado.getNome());
                    this.desafiado.ganharLuta();
                    this.desafiante.perderLuta();
                    break;
                case 2:
                    System.out.println(this.desafiante.getNome());
                    this.desafiado.perderLuta();
                    this.desafiante.ganharLuta();
                    break;
                
            }
            
        }else{
            System.out.println("Não aprovada");
        }
    }

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }
    
    
    
}
