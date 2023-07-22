import java.util.Scanner;

public class AddTwoMatrix {
    public static void main(String[] args) {
        int row,col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column on Matrix.");
        row = sc.nextInt();
        col = sc.nextInt();

        int matrix1[][] = new int[row][col];
        int matrix2[][] = new int[row][col];
        int sum[][] = new int[row][col];

        //first matrix
        System.out.println("Enter  Matrix1.");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                matrix1[i][j]=sc.nextInt();
            }
        }

        //second Matrix
        System.out.println("Enter  Matrix1.");
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                matrix2[i][j]=sc.nextInt();
            }
        }

        //sum of Matrix
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                sum[i][j]=matrix1[i][j]+matrix2[i][j];
            }
        }

        //print Matrix
        System.out.println("sum of Matrix");
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print( sum[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
        return;
    }
}
