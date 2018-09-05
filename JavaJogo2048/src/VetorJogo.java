public class VetorJogo {
    int[] vec1 = new int[4];
    //boolean T;
    
    void seqVector(){
        
      if((vec1[3]==vec1[2]) || vec1[2] == 0) {
          vec1[2] = vec1[3]+vec1[2];
          vec1[3] = (int) ((int) 2*((int)(Math.random()*11)%2));
      }else if(vec1[3] == 0){
          vec1[3] = (int) ((int) 2*((int)(Math.random()*11)%2));
      }
      
      if((vec1[2] == vec1[1]) || vec1[1] == 0){
          vec1[1] = vec1[1]+vec1[2]; 
          vec1[2] = vec1[3];
          vec1[3] = (int) ((int) 2*((int)(Math.random()*11)%2));
      }else if (vec1[2] == 0){
          vec1[2] = vec1[3]; 
          vec1[3] = (int) ((int) 2*((int)(Math.random()*11)%2));
      }
      
      if((vec1[1] == vec1[0]) || vec1[0] == 0){
          vec1[0] = vec1[0]+vec1[1]; 
          vec1[1] = vec1[2];
          vec1[2] = vec1[3];
          vec1[3] = (int) ((int) 2*((int)(Math.random()*11)%2));
      }
      
    }
    
    /*
    void checkIgualdade (){
        int i;
        for(i = 0; i < 4; i++){
            if((vec1[i] != vec2[i])&&(vec2[i] != 0)){
                break;
            }
        }
        T = (i == 3);
    }
    
    void vetorJuncao(){
        if(T){
            for(int j = 0; j < 4; j++ )
                vecResol[j] = vec1[j]*vec2[j]; 
        }
    } */
}
