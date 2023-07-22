//package ItreationStatment;

import java.util.Scanner;

public class Factorial {
    
    public static void main(String args[]) {
        
        int number=0;
        int fact=1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number:");
        number = sc.nextInt();
        if(number==0){
         System.out.print("Factorial of "+number+"is: 1");
         return ;
        }
        for(int i=1;i<=number;i++)
        {
            fact = fact*i;
        }
        System.out.print("Factorial of "+number+" is : "+fact);
    }

    
}
