package ques1;

interface ReplaceVovel{
	void replace(String word);
}
//Write a Java program to implement a lambda expression to replace vowels with ‘#’ in a given string.
public class Question1 {
 public static void main(String[] args) {
	 
	System.out.println("Replace vowels with ‘#’ in a given string.");
	ReplaceVovel rv = (word)->{
		{
			System.out.println("word : "+word);
			for(int i=0;i<word.length();i++)
			{
				if(word.charAt(i)=='a')
				{
					word =word.replace("a", "#");
				}
				else if(word.charAt(i)=='e')
				{
					word =word.replace("e", "#");
				}
				else if(word.charAt(i)=='i')
				{
					word =word.replace("i", "#");
				}
				else if(word.charAt(i)=='o')
				{
					word =word.replace("o", "#");
				}
				else if(word.charAt(i)=='u')
				{
					word =word.replace("u", "#");
				}
			}
			System.out.println("After replacing vowels with ‘#’ : "+word);
		}
	};
	rv.replace("aeroplane");
	System.out.println();
	rv.replace("apple");
	System.out.println();
	rv.replace("education");
}
}
