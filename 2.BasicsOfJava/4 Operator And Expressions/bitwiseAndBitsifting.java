public class bitwiseAndBitsifting {
    public static void main(String[] args) {
        int val1 = 3;
        int val2 = 2;
        int val3 =0;

        System.out.println("val1: "+val1);
        System.out.println("val2: "+val2);
        System.out.println("val3: "+val3);

        //AND
        System.out.println("val1 & val2 = " + (val1 & val2));

        //OR
        System.out.println("val1 | val2 = " + (val1 | val2) );

        //XOR
        System.out.println("val1 ^ val2 = " + (val1 ^ val2) );
        
        //Binary Complement Operator
        System.out.println("~val1 = " + ~val1 );

        //Binary Left Shift Operator
        val3 = val1 <<  3;
        System.out.println("val1 << 3 = " + val3 );

        //Binary Right Shift Operator
        val3 = val1 >>  1;
        System.out.println("val1 >> 1  = " + val3 );

        //Shift right zero fill operator
        val3 = val1 >>> 2;
        System.out.println("val1 >>> 2 = " + val3 );
    }
}
