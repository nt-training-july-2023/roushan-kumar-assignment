import java.util.Scanner;

public class LargestNumber {
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

    int maxValue = Integer.MIN_VALUE;

    for(int i=0;i<n;i++)
    {
        if(maxValue<array[i])
        {
            maxValue=array[i];
        }
    }
    System.out.print("\nLargest Number : "+maxValue);
    float avg= 0.0f;
    for(int i=0;i<n;i++)
    {
        avg = avg + (float)array[i]/n;
    }
    System.out.print("\nAvg : "+avg);
    sc.close();
   } 
}
