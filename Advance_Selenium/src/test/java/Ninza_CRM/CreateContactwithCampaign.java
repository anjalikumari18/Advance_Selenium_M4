package Ninza_CRM;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactwithCampaign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://49.249.28.218:8098/");
		
		Random random=new Random();
		int randominteger=random.nextInt(300);
		System.out.println(randominteger);
		
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
		//driver.findElement(By.xpath("//button[@type=\"button\"])[2]")).click();
		
		driver.findElement(By.name("organizationName")).sendKeys("Org1");
		driver.findElement(By.name("title")).sendKeys("Contactmine"+randominteger);
		driver.findElement(By.name("contactName")).sendKeys("Sita");
		driver.findElement(By.name("mobile")).sendKeys("9876543210");
	
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		
	    for(String id:childwindow)
		{
			driver.switchTo().window(id);
			break;
		}
		
		driver.findElement(By.xpath("(//button[@class=\"select-btn\"])[2]")).click(); 
		driver.switchTo().window(parentwindow);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

}
