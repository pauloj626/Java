package areadeumcirculo;

import java.util.Scanner;

public class AreaDeUmCirculo {

    public static void main(String[] args) {
	    Scanner raio = new Scanner (System.in);
	    double r = (double)raio.nextDouble();
	    double A;
	    A = r*r;
	    A = A * (double)3.14159;
	    System.out.printf("A=%.4f\n", A);
    }
    
}
