package ques3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question3 {
	public static void main(String[] args) throws IOException {
		File inFile = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques3\\in.txt");
		File outFile = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques3\\out.txt");
		
		BufferedReader bufferReader = null;
		List<String> arrayString = new ArrayList<String>();
		int line=0;
		try 
		{
			bufferReader = new BufferedReader(new FileReader(inFile));
			String s = bufferReader.readLine();
			
			while(s!=null)
			{
				line++;
				System.out.println(s);
				arrayString.add(s);
				s=bufferReader.readLine();
			}
			System.out.println(line);
			bufferReader.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		BufferedWriter bufferedWriter = null;
		
		try {
			
			bufferedWriter = new BufferedWriter(new FileWriter(outFile));
			
			for(int i = line-1;i>=0;i--)
			{
				bufferedWriter.write(arrayString.get(i));
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}
}
