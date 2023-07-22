public class Equal {
    public static void main(String[] args) {
        String s1 = "Roushan";
        String s2 = "Roushan";
        String s3 = "Kumar";
        String s4 = new String("Roushan");

        //Equals method for content comapre
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        // == operator for address compare
        System.out.println(s1==s2);
        System.out.println(s1==s4);


    }
}
