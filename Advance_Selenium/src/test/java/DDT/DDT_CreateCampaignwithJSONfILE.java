package DDT;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT_CreateCampaignwithJSONfILE {

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		
		//Step 1: Get the java representation object of the physical file
		
				
				//By taking help of the keys, read the data
				

		//Get access of physical file using filereader
		
		FileReader fr=new FileReader("C:\\Users\\anjal\\Desktop\\DDT Files\\jsoncommondata.json");
		
		//Parse the json physical file into java file using JSONParserClass
		
		JSONParser parser=new JSONParser();
		Object object = parser.parse(fr);
		
		//Convert java object into JSONObject using downcasting
		
		JSONObject jsboj=(JSONObject)object;
		
		//Read the data using get() by passing the key
		
		String browser = jsboj.get("browser").toString();
		System.out.println(browser);
		String url = jsboj.get("url").toString();
		System.out.println(url);
		String username = jsboj.get("username").toString();
		System.out.println(username);
		String password = jsboj.get("password").toString();
		System.out.println(password);
			    

		        //cross-browser testing
		        WebDriver driver=null;
		        if(browser.equalsIgnoreCase("chrome")) {
		        	driver=new ChromeDriver();
		        }
		        else if(browser.equalsIgnoreCase("edge")) {
		        	driver=new EdgeDriver();
		        }
		        else if(browser.equalsIgnoreCase("firefox")) {
		        	driver=new FirefoxDriver();
		        }
		        else {
		        	driver=new ChromeDriver();
		        }
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				
				//Passing the url as key
				driver.get(url);
				
				//Input the username
				driver.findElement(By.id("username")).sendKeys(username);
				//input the password
				driver.findElement(By.id("inputPassword")).sendKeys(password);
				//click on sign in button
				driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
				driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				
				//enter the campaign name
				driver.findElement(By.name("campaignName")).sendKeys("Save Girl Child_318");
				
				//enter the target size
				WebElement targettextfield = driver.findElement(By.name("targetSize"));
				targettextfield.clear();
				targettextfield.sendKeys("400");
				
				//click on create campaign button
				driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();

	}

}
