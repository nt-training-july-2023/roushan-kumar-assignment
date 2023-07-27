package ques4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question4 {

	public static void main(String[] args) throws IOException {
		File f = new File("D:\\NucleusTeq-Traning\\4.Java_Assessment_Questions\\src\\ques4","user1.txt");
		
		try {
			if(!f.exists())
			{
				f.createNewFile();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			f.setReadOnly();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println();
		
		FileWriter fw =null;
		
		char ch[] = {'h','e','l','l','o'};
		//f.setWritable(true);
		try {
			fw = new FileWriter(f,true);
			fw.write(ch);
			fw.flush();
			fw.close();
		} catch (Exception e) {
			System.out.println("Read Only Exception");
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		finally {
			//fw.close();
		}
		
		
		//System.out.println(f.getAbsolutePath());
		FileReader fr=null;
		try {
			fr = new FileReader(f);
			int c =  fr.read();
			
			while(c!=-1)
			{
				System.out.print((char)c);
				c=fr.read();
			}
			fr.close();
		} catch (Exception e) {
			
		}
		finally {
			fr.close();
		}
		
		
	}
}
