
public class DataTypesDemo {
    public static void main(String arg[]) {
        byte b = 127;
        byte bMin = -128;

        short s = 32767;
        short sMin = -32768;

        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;

        long longNumber = 99999999999999l;
        float fl = 999.0f;
        double dou = 999.09d;
        char ch = 'c';
        boolean bool = true;

        System.out.println("byte b: " + b);
        System.out.println("byte bMin: " + bMin);
        System.out.println("short s: " + s);
        System.out.println("short sMin: " + sMin);
        System.out.println("int intMax: " + intMax);
        System.out.println("int intMin: " + intMin);
        System.out.println("long longNumber: " + longNumber);
        System.out.println("float fl: " + fl);
        System.out.println("double dou: " + dou);
        System.out.println("char ch: " + ch);
        System.out.println("boolean bool: " + bool);

        b = 12;
        bMin = -125;

        s = 3276;
        sMin = -3276;

        intMax = Integer.MAX_VALUE;
        intMin = Integer.MIN_VALUE;

        longNumber = 9955558421499l;
        fl = 98749.01f;
        dou = 6548.00249d;
        ch = 'h';
        bool = false;
        System.out.println();
        System.out.println("After some modify");
        System.out.println();
        System.out.println("byte b: " + b);
        System.out.println("byte bMin: " + bMin);
        System.out.println("short s: " + s);
        System.out.println("short sMin: " + sMin);
        System.out.println("int intMax: " + intMax);
        System.out.println("int intMin: " + intMin);
        System.out.println("long longNumber: " + longNumber);
        System.out.println("float fl: " + fl);
        System.out.println("double dou: " + dou);
        System.out.println("char ch: " + ch);
        System.out.println("boolean bool: " + bool);

    }
}
