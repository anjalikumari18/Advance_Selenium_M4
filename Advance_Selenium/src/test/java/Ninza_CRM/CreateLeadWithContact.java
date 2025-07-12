package Ninza_CRM;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateLeadWithContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("http://49.249.28.218:8098/");
		
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	    driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
	    
		driver.findElement(By.linkText("Contacts")).click();
		//click on create contact button
		driver.findElement(By.xpath("//span[contains(text(),'Create Contact')]")).click();
		driver.findElement(By.xpath("(//button[@type=\"button\"])[2]")).click();
		
		driver.findElement(By.name("organizationName")).sendKeys("QSP");
		driver.findElement(By.name("title")).sendKeys("change you need");
		driver.findElement(By.name("contactName")).sendKeys("QSP Head");
		driver.findElement(By.name("mobile")).sendKeys("778293483902");
		
		
		//Get the parent window id
		String parentid = driver.getWindowHandle();
		//Get both the parent window handle and child window handle
		Set<String> allwindowid = driver.getWindowHandles();
		allwindowid.remove(parentid);
		
		for(String id:allwindowid) {
			driver.switchTo().window(id);
			break;
		}
		
		//Inside child window
		//click on the select button
		driver.findElement(By.xpath("(//button[@class=\"select-btn\"])[2]")).click();
		//driver control back to the parent window
		driver.switchTo().window(parentid);
		//click on create contact
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
