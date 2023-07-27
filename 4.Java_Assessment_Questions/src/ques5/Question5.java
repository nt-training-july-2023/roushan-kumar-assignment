package ques5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question5 {
	public static void main(String[] args) throws IOException {
		File f = new File("D:\\NucleusTeq-Traning\\4.Java_Assessment_Questions\\src\\ques5","Input.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		FileWriter fw = new FileWriter(f,true);
		char ch[] = {'q','w','e','r','t','y'};
		fw.write(ch);
		fw.close();
		
		File f2 = new File("D:\\NucleusTeq-Traning\\4.Java_Assessment_Questions\\src\\ques5","Output.txt");
		if(!f2.exists())
		{
			f2.createNewFile();
		}
		FileReader fr = new FileReader(f);
		FileWriter fw2 = new FileWriter(f2);
		int c = fr.read();
		
		while(c!=-1)
		{
			//System.out.println((char)c);
			fw2.write(c);
			c = fr.read();
		}
		fw2.close();
		fr.close();
	}
}
