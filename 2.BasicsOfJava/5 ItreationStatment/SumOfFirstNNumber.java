import java.util.Scanner;

public class SumOfFirstNNumber {
    public static void main(String args[]) {
        int number;
        int sum=0;
        System.out.println("Enter n number.");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        for(int i=1;i<=number;i++)
        {
            sum+=i;
        }
        System.out.println("Sum of first n number: "+sum);

    }
}
