import java.util.Scanner;

public class rootsOfQuad {
    public static void main(String args[]) {
        int a,b,c;
        double r1=0.0,r2=0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter vale of a , b and c of quadratic");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int d = b*b - 4*a*c;

        System.out.println(d);

        if(d<0)
        {
            System.out.println("Imaginary roots");
            sc.close();
            return ;
        }

        r1 = (-b + Math.sqrt(d))/(2*(a*c));
        r2 = (-b - Math.sqrt(d))/(2*(a*c));

        System.err.println("root1 : "+r1);
        System.err.println("root2 : "+r2);
        sc.close();
        

                

    }
}
