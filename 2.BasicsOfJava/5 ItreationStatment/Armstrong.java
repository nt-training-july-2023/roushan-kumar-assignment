import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println("--:Armstrong Number:--");

        int n;
        int temp;
        int sum=0;
        int digit=0;
        System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        temp=n;

        while (temp>0) {
            digit = temp%10;
            temp /=10;
            sum +=digit*digit*digit;
        }

        if(sum==n)
        {

            System.out.println("Armstrong number");
            
        }
        else{
            System.out.println("Not an armstrong number");
        }

        return ;
        

    }
}
