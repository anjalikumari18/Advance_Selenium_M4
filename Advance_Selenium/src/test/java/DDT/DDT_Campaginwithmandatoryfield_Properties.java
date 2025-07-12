package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DDT_Campaginwithmandatoryfield_Properties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
				
		//Test case 01-Navigate to Ninza CRM>> Create Campaign with mandatory field.
		
		//Step 1: Get the java representation object of the physical file
		
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\commondata.properties.txt");
		
		//Step 2: Create Object of Properties file
		
		Properties prop=new Properties();
		
		//Step 3: Load all the keys
		
		prop.load(fis);
		
		//By taking help of the keys, read the data
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");	
	    String password = prop.getProperty("password");
	    

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


