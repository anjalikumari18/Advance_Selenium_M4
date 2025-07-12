package GenericUtility;

import java.io.IOException;

public class GU_Propertyutilityimplementation {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		  
		
		PropertyFileUtility putility=new PropertyFileUtility();
		String browser = putility.getDataFromPropertiesFile("browser");
		System.out.println(browser);
		String url = putility.getDataFromPropertiesFile("url");
		System.out.println(url);
		String username = putility.getDataFromPropertiesFile("username");
		System.out.println(username);
		String password = putility.getDataFromPropertiesFile("password");
		System.out.println(password);

		
		JavaUtility jutil=new JavaUtility();
		String sysdate = jutil.getSystemDate();
		System.out.println(sysdate);
		
		String reqdate = jutil.getRequiredDateddMMYYYY(5);
		System.out.println(reqdate);
		
		ExcelUtility eutil=new ExcelUtility();
		String data = eutil.getDataFromExcel("Sheet1", 1, 0);
		System.out.println(data);
		

	}

}
