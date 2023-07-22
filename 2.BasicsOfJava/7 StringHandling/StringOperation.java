public class StringOperation {
    public static void main(String[] args) {
        String str1="hello world ";
        String str2="Earth is beautifull ";

        //length of string 
        System.out.println("lenght of string str1: "+ str1.length());
        System.out.println("lenght of string str2: "+ str2.length());

        //string concatinatiom
        String str3 = str1+str2;
        System.out.println("str1 + str2 :" + str3);

        System.out.println("string str1:"+str1);
        System.out.println("string str2:"+str2);

        //Postion of character 
        System.out.println("char at 4 prosition in string str1 : "+str1.charAt(3));
        System.out.println("char at 3 prosition in string str2 : "+str2.charAt(2));

        //Check if a String starts with a given character or String

        System.out.println("str1 start with \"a\" :"+str1.startsWith("a", 0));
        System.out.println("str1 start with \"hel\" :"+str1.startsWith("hel", 0));

        //Find index of a given character or string from a String.
        System.out.println("index of \'h\' in str1 is  "+ str1.indexOf("h", 0));
        System.out.println("index of \'world\' in str1 is  "+ str1.indexOf("world", 0));

        //Replace a character from a String
        str1=str1.replace('l', 'i');
        System.out.println(str1);


    }
}
