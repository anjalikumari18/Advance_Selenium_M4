package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import WebDriverUtility.WebDriverUtility;

public class GU_CreateCampaignwithmadatoryfieldusingutilities {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Test case 01-Navigate to Ninza CRM>> Create Campaign with mandatory field.
		
		//Reading data from Properties file utility
		PropertyFileUtility putil=new PropertyFileUtility();
		String BROWSER = putil.getDataFromPropertiesFile("browser");
		String URL = putil.getDataFromPropertiesFile("url");
		String USERNAME = putil.getDataFromPropertiesFile("username");
		String PASSWORD = putil.getDataFromPropertiesFile("password");

		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Excel utility implementation
		ExcelUtility eutil=new ExcelUtility();
		String Cpn_name=eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize=eutil.getDataFromExcel("Sheet1", 1, 1);
		
		System.out.println(Cpn_name);
		System.out.println(targetsize);
		
		//Javautility implementation
		JavaUtility jutil=new JavaUtility();
		int randominteger = jutil.getRandomNumber();
		
		
		//Input the username
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		//input the password
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		//click on sign in button
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		//enter the campaign name
		driver.findElement(By.name("campaignName")).sendKeys(Cpn_name+randominteger);
		
		//enter the target size
		WebElement targettextfield = driver.findElement(By.name("targetSize"));
		targettextfield.clear();
		targettextfield.sendKeys(targetsize+randominteger);
		
		//click on create campaign button
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		
		// Validation using WebDriver utility
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverUtility wutil=new WebDriverUtility();
		wutil.waitForVisibilityOfWebelement(driver, toastMsg);
		String msg = toastMsg.getText();
		if (msg.contains(Cpn_name+randominteger))
		System.out.println("Campaign Created");
		else
		System.out.println("Campaign Not Created");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
		
		// Logout using Webdriver utility
		WebElement userIcon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		wutil.moveToElement(driver, userIcon);
		WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		wutil.moveToElement(driver, logoutBtn);
		driver.quit();
		}
		


	}


