import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
       String s="";
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a Number: ");
        s=sc.nextLine();
       int len = s.length();
       int flag =0;
       for(int i=0,j=len-1;i<len/2;i++,j--)
       {
            if(s.charAt(i)!=s.charAt(j))
            {
                System.out.println("Not Palindrome");
                flag=1;
                break;
            }
       }

       if(flag==0)
       {
        System.out.println("Palindrome");
       }




    }
}
