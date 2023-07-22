import java.util.Scanner;

public class AreaOfTrangle {
    public static void main(String[] args) {
        float base;
        float height;
        float area=0.0f;
        float half = 0.5f;
        Scanner scanner = new Scanner(System.in);
        base = scanner.nextFloat();
        height = scanner.nextFloat();

        area = base*height*half;
        System.out.println(area);
        

        scanner.close();
    }
}
