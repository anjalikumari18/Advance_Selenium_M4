package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingDatafromPropertiesfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Step 1: Get the java representation object of the physical file
		
		FileInputStream fis=new FileInputStream("File address");
		
		//Step 2: Create Object of Properties file
		
		Properties prop=new Properties();
		
		//Step 3: Load all the keys
		
		prop.load(fis);
		
		//By taking help of the keys, read the data
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		String url = prop.getProperty("url");
		System.out.println(url);
		String username = prop.getProperty("username");	
		System.out.println(username);
		String password = prop.getProperty("password");
		System.out.println(password);

	}

}
