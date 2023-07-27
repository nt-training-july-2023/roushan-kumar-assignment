package ques8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Question8 {
	
	public void readFile(String Path,String fileName) throws IOException
	{
		File f = new File(Path,fileName);
		if(!f.exists())
		{
			System.out.println("File not found");
			return ;
		}
		//fileReader for read file
		FileReader fr = new FileReader(f);
		try {
			
			int c = fr.read();
			while(c!=-1)
			{
				//print one character;
				System.out.print((char)c);
				//read next character;
				c = fr.read();
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		finally {
			fr.close();
		}
	}
	
	public static void main(String[] args) {
		String fileName;
		String Path;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Filename :");
		fileName = sc.nextLine();
		System.out.println(" File Path :");
		Path = sc.next();
		
		Question8 q  = new Question8();
		
		//Reading file 
		try {
			q.readFile(Path, fileName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			sc.close();
		}
		sc.close();
		System.out.println("Done");
	}
}
