package javaapplicationlivro29;

import java.util.Scanner;

public class JavaApplicationLivro29 {

    public static void main(String[] args) {
        Scanner tecla = new Scanner(System.in);
        int yearIn = tecla.nextInt();
        int monthIn = tecla.nextInt();
        
        for(int i = 0; i < 8; i++ )
            System.out.println(2*((int)(((int)1/(Math.random()))%3)));

        
        System.out.println(monthIn + "/" + yearIn + "has"
                            + countDays(monthIn, yearIn) + "days");
    }
    
    static int countDays (int month, int year){
        int count = -1;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0)
                    count = 29;
                else
                    count = 28;
                if ((year % 100 == 0)&&(year % 400 != 0))
                    count = 28;
        }
        return count;
    }
    
}
