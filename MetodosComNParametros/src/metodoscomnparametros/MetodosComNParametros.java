package metodoscomnparametros;

public class MetodosComNParametros {

    static int somaNumeros(int ... numeros){
        int sum = 0;
        for(int n : numeros)
            sum+=n;
        
        return sum;
        
    }
    
    public static void main(String[] args) {
        /*
        int[] arr = {1,2,3,4,5,6,7};
        
        int S = somaNumeros(arr);
        
        System.out.println(S);
        */
        
        MetodosComNParametros Obj;
        Obj = new MetodosComNParametros();
        
        int S = Obj.somaNumeros(1,2,3,4,5,6);
        
        System.out.println(S);
        
    }
    
}
