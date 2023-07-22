import java.util.Scanner;

public class PyramidPattern {
    public static void main(String args[]) {
        int n;
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
