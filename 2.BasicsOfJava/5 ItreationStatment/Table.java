import java.util.Scanner;
public class Table {
    public static void main(String args[]) {
        int number=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number for table.");
        number =  sc.nextInt();
        System.out.println("Table of :"+number);
        for(int i=1;i<=10;i++)
        {
           System.out.println(number+" * "+i+" = "+(number*i) ); 
        }

    }
}
