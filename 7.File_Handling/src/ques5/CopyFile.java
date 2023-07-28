package ques5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
	public static void main(String[] args) {
		File inFile = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques5\\in.txt");
		File outFile = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques5\\out.txt");
		
		if(!inFile.exists())
		{
			System.out.println("File is not availabe");
			return ;
		}
		BufferedReader bufferReader = null;
		BufferedWriter bufferedWriter = null;
		try 
		{
			bufferReader = new BufferedReader(new FileReader(inFile));
			bufferedWriter = new BufferedWriter(new FileWriter(outFile));
			String s = bufferReader.readLine();
			
			while(s!=null)
			{
				
				System.out.println(s);
				bufferedWriter.write(s);
				bufferedWriter.newLine();
				s=bufferReader.readLine();
			}
			
			bufferReader.close();
			bufferedWriter.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
