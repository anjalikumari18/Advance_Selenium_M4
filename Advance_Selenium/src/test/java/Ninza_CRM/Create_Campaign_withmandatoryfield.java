package Ninza_CRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Create_Campaign_withmandatoryfield {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test case 01-Navigate to Ninza CRM>> Create Campaign with mandatory field.
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		
		//Input the username
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		//input the password
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//click on sign in button
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		//enter the campaign name
		driver.findElement(By.name("campaignName")).sendKeys("Save Girl Child");
		
		//enter the target size
		WebElement targettextfield = driver.findElement(By.name("targetSize"));
		targettextfield.clear();
		targettextfield.sendKeys("400");
		
		//click on create campaign button
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		

	}

}
