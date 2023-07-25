package propertiesClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestApp {
	public static void main(String[] args) throws IOException {
		Properties  p = new Properties();
		FileInputStream fis = new FileInputStream("D:\\NucleusTeq-Traning\\3.Opps\\src\\propertiesClass\\app.properties");
		p.load(fis);
		//p.setProperty("user", "roushan");
		//p.setProperty("password", "123");
		//System.out.println(p);
		
		if(p.getProperty("user").equals("roushan"))
			System.out.println("Hello Roushan");
		
		p.setProperty("url", "www.google.com");
		FileOutputStream fos = new FileOutputStream("D:\\NucleusTeq-Traning\\3.Opps\\src\\propertiesClass\\app.properties");
		p.store(fos, "user and password by Roushan Kumar");
		
	}
}
