package ques2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public class FilterInputStreamFilterOutputStream {
	public static void main(String[] args) throws IOException {
		
		//FileOutputStream demo;
		File file = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques2\\file.txt");
		try {
			FileOutputStream fos  = new FileOutputStream(file);
			//fos.write(65);
			//fos.write((byte)'5');
			//fos.write('5');
			String s = "Hello everyone";
			byte b[] = s.getBytes() ;
			fos.write(b);
			fos.close();
			System.out.println("Write Success");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//FilterOutputStream
		File file2 = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques2\\file2.txt");
		FileOutputStream fos2=null;
		FilterOutputStream filterOutStr=null;
		try {
			 fos2 = new FileOutputStream(file2);
			 filterOutStr = new FilterOutputStream(fos2);
			 filterOutStr.write(65);
			 fos2.close();
			 filterOutStr.close();
			 System.out.println("Write Success FilterOutputStream");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//Read file with FileInputStream
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
			int c = fileInput.read();
			while(c!=-1)
			{
				System.out.print((char)c);
				c=fileInput.read();
			}
			fileInput.close();
			
		} catch (Exception e) {
			
		}
		System.out.println();
		
		//Read file with FileInputStream and FilterInputStream
		//and BufferedInputStream
		
		System.out.println("FilterInputStream line 64");
		
		FileInputStream fileInput2 = null;
		FilterInputStream filterIn = null;
		File file3 = new  File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques2\\file3.txt");
		if(!file3.exists())
			file3.createNewFile();
		try {
			//file file.txt 
			fileInput2 = new FileInputStream(file3);
			filterIn = new BufferedInputStream(fileInput2);
			System.out.println("Available data to read. "+filterIn.available() +" in file3");
			int c = filterIn.read();
			
			while(c!=-1)
			{
				System.out.println((char)c);
				c=filterIn.read();
			}
			fileInput2.close();
			filterIn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
