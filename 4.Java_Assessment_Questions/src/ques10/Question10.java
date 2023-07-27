package ques10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question10 {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		String password = null;
		
		System.out.println("Enter Your Password");
		Scanner sc = new Scanner(System.in);
		password = sc.nextLine();
		
		String regex1 ="^(?=.*[0-9])(?=\\S+$).{8,}$";
		String regex2 ="^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
		String regex3 ="^(?=\\S+$).{8,20}$";
		
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(password);
		
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(password);
		
		Pattern p3 = Pattern.compile(regex3);
		Matcher m3 = p3.matcher(password);
		try {
//			System.out.println(m1.matches());
//			System.out.println(m2.matches());
//			System.out.println(m3.matches());
			if(!m3.matches())
			{
				throw new InvalidPasswordException("least 8 lenght password");
			}
			else if(!m2.matches())
			{
				throw new InvalidPasswordException("least 1 character");
			}
			else if(!m1.matches())
			{
				throw new InvalidPasswordException("least 1 digit");
			}
			else
			{
				System.out.println("Your password is valid"+password);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		sc.close();
	}
}
