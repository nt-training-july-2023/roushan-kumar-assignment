import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        int number=0;
        int reverseNumber=0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        number = sc.nextInt();
        System.out.println("Number : "+number);
        while(number>0)
        {
            reverseNumber = reverseNumber*10+number%10;
            number/=10;
        }
        System.out.println("Reverse Number : "+reverseNumber);


    }
}
