package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDT_CreateContactwithCampaign {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\ninzacrm.properties.txt");

		//Create an object of properties class
		Properties prop=new Properties();
		
		//load all the keys in properties file
		prop.load(fis);
		
		//Extract the value using key name
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println(url);
		
		//cross browser testing
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.linkText("Contacts")).click();
		
		FileInputStream fis1=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contact");
		Row r = sh.getRow(1);
		Cell cellval1 = r.getCell(0);
		Cell cellval2 = r.getCell(1);
		Cell cellval3 = r.getCell(2);
		Cell cellval4 = r.getCell(3);
		
		String organisation = cellval1.getStringCellValue();
		String title = cellval2.getStringCellValue();
		String contactname = cellval3.getStringCellValue();
		String mobileno = cellval4.getStringCellValue();
		
		driver.findElement(By.xpath("//span[contains(text(),'Create Contact')]")).click();
		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
		
		driver.findElement(By.name("organizationName")).sendKeys(organisation);
		driver.findElement(By.name("title")).sendKeys(title);
		driver.findElement(By.name("contactName")).sendKeys(contactname);
		driver.findElement(By.name("mobile")).sendKeys(mobileno);
		
		String parentid = driver.getWindowHandle();
		Set<String> allwindowid = driver.getWindowHandles();
		allwindowid.remove(parentid);
		
		for(String id:allwindowid) {
			driver.switchTo().window(id);
			break;
		}
		
		driver.findElement(By.xpath("(//button[@class=\"select-btn\"])[2]")).click();
		
		driver.switchTo().window(parentid);


		Actions as=new Actions(driver);
		WebElement createc=driver.findElement(By.xpath("//button[text()='Create Contact']"));
		as.moveToElement(createc).click().perform();

		
	}

}
