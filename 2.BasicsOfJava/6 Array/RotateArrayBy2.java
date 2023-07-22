import java.util.Scanner;

public class RotateArrayBy2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array.");
        n= sc.nextInt();
        int array[] = new int[n];
        for(int i=0;i<n;i++)
        {
            array[i] = sc.nextInt();
        }
        System.out.println("Elements of Array");
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }
        System.out.println("\nReverse right by 2 position.");
        //Reverse array
        for(int i=0,j=n-1;i<n/2;i++,j--)
        {
            int temp=array[i];
              array[i]=array[j];
              array[j]=temp;  
        }
        //Reverse array first 2 element;
        for(int i=0,j=2-1;i<2/2;i++,j--)
        {
            int temp=array[i];
              array[i]=array[j];
              array[j]=temp;  
        }
        //Reverse array after 2 element;
        for(int i=2,j=n-1;i<(n-2)/2+2;i++,j--)
        {
            int temp=array[i];
              array[i]=array[j];
              array[j]=temp;  
        }
        // print array
        for(int i=0;i<n;i++)
        {
            System.out.print(array[i]+" ");
        }


        sc.close();
    }
    
}
