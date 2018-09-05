package jogodacombrinhateste;

import java.awt.Graphics;
import java.util.ArrayList;

public class Cobra {
    private ArrayList<PartCobra> cobra;
    private int N;
    
    public Cobra(){
        this.N = 3;
        this.cobra = new ArrayList<>();
        this.cobra.add(new PartCobra(200, 200, Mov.STOPED));
        this.cobra.add(new PartCobra(200, 200, Mov.STOPED));
        this.cobra.add(new PartCobra(200, 200, Mov.STOPED));
    }
    
    public void move(Mov dir){
        if(dir == null){
        }else {
            for(int i = N-1; i > 0; i--)
                this.cobra.get(i).move(this.cobra.get(i-1).getDir());
            this.cobra.get(0).move(dir);
        }
    }
    
    public void addNewPartCobra(){
        Mov dir = this.cobra.get(N-1).getDir();
        int px = this.cobra.get(N-1).getX();
        int py = this.cobra.get(N-1).getY();
        
        if(dir == Mov.DOWN){
            this.cobra.add(new PartCobra(px,py-40,Mov.STOPED));
        }else if(dir == Mov.UP){
            this.cobra.add(new PartCobra(px,py+40,Mov.STOPED));
        }else if(dir == Mov.LEFT){
            this.cobra.add(new PartCobra(px+40,py,Mov.STOPED));
        }else if(dir == Mov.RIGHT){
            this.cobra.add(new PartCobra(px-40,py,Mov.STOPED));
        }
        
        this.N++;
    }
    
    public boolean morreu(){
        int a = this.cobra.get(0).getX();
        int b = this.cobra.get(0).getY();
        
        if(a < 20 || a >= 760 || b < 20 || b >= 680)
            return true;
        else{
            for(int i = 1; i < N; i++){
                if(a == this.cobra.get(i).getX() && b == this.cobra.get(i).getY()){
                    return true;
                }
            }
            return false;
        }
    }
    
    public void draw(Graphics g){
        cobra.forEach((partcobra) -> {
            partcobra.draw(g);
        });
    }
    
    public Mov getDir(){
        return this.cobra.get(0).getDir();
    }
    
    public int getpX(){
        return this.cobra.get(0).getX();
    }
    
    public int getpY(){
        return this.cobra.get(0).getY();
    }
}
