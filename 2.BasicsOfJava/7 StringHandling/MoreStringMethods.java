/**
 * MoreStringMethods
 */
public class MoreStringMethods {

    public static void main(String[] args) {
        
        String txt = "Hello World";
        //to Uppercase method
        System.out.println(txt);
        System.out.println("To uppercase : "+ txt.toUpperCase());

        //to lowercase method
        System.out.println("To lowercase : "+txt.toLowerCase());

        //trim method
        String str = "       Hello Everyone!       ";
        System.out.println("str: "+str);
        System.out.println("After trim str:" +str.trim());


        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = "world";
        //compareTo method

        System.out.println();
        System.out.println("str1 :"+str1);
        System.out.println("str2 :"+str2);
        System.out.println("str3 :"+str3);
        System.out.println("str1 compareTo str2 "+ str1.compareTo(str2)); // Returns 0 because they are equal
        System.out.println("str1 compareTo str3 "+ str1.compareTo(str3)); // Returns < 0 because they are not equal
        System.out.println();


        System.out.println(str1.equals(str2)); // Returns true because they are equal
        System.out.println(str1.equals(str3)); // false

    }
}