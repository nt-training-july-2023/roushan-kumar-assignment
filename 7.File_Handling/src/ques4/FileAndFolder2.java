package ques4;

import java.io.File;

//List of fill and folder Of directory
public class FileAndFolder2 {
	
	private static void PrintFileAndFolder(File[] file, int index, int level) {
		
		if(file.length==index)
		{
			return ;
		}
		for (int i = 0; i < level; i++)
            System.out.print("\t");
		
		if(file[index].isFile())
		{
			System.out.println("->"+file[index].getName());
		}
		else if(file[index].isDirectory())
		{
			System.out.println("[ "+file[index].getName()+" ]");
			PrintFileAndFolder(file[index].listFiles(),0,level+1);
		}
		
		PrintFileAndFolder(file,index+1,level);
		
		
	}
	public static void main(String[] args) {
		File f  = new File("D:\\NucleusTeq-Traning\\7.File_Handling\\src\\ques4");
	    
		if(f.exists() && f.isDirectory()) {
			
			File[] arr =f.listFiles();
			System.out.println(f);
		
		PrintFileAndFolder(arr,0,0);
		}
		
	}

	

}
