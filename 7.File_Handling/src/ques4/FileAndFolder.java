package ques4;

import java.io.File;

//List of fill and folder Of directory
public class FileAndFolder {
	
	public static void main(String[] args) {
		File f  = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques4");
		String[] s=f.list();
		
		for(String x : s)
		{
			System.out.println(x);
		
			File f2 = new File(f,x);
			if(f2.list()!=null) {
				String subFolderOrFile[] = f2.list(); 
				
				for(String x2 : subFolderOrFile ) {
					
					System.out.print(" ->");
					System.out.println(x2);
				}
			}
			

		}
	}

}
