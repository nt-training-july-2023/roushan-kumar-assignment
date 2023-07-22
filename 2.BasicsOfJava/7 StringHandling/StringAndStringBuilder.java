public class StringAndStringBuilder {

    public static void concateString(String s1)
    {
        s1 = s1 + "world";
    }
    public static void concateStringBuilder(StringBuilder s1)
    {
        s1.append("world");
    }

    public static void main(String args[]) {
        String s1 = "hello ";
        StringBuilder s2 = new StringBuilder(s1);

        concateString(s1);
        //string can not change;
        System.out.println("String : "+s1);

        concateStringBuilder(s2);
        //string change
        System.out.println("StringBuilder : "+s2);


    }
}
