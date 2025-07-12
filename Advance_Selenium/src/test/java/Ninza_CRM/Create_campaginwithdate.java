package Ninza_CRM;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_campaginwithdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8098/");
		
		//To generate random integer
		Random random=new Random();
		int randominteger = random.nextInt(300);
		System.out.println(randominteger);
		
		
		//Input the username
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		//input the password
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		//click on sign in button
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		
		//enter the campaign name
		driver.findElement(By.name("campaignName")).sendKeys("Save Girl Child_"+randominteger);
		
		//enter the target size
		WebElement targettextfield = driver.findElement(By.name("targetSize"));
		targettextfield.clear();
		targettextfield.sendKeys("400");
		
		//calendar
		
		//capture the current system date
	    Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");  //used to format the date
	    String currentdate=sdf.format(date);
	    System.out.println(currentdate);
		
		//capture the current system date 30 days after
        Calendar cal =sdf.getCalendar();
	    cal.add(Calendar.DAY_OF_MONTH,40); 
        String expectedDate1 = sdf.format(cal.getTime());
        System.out.println(expectedDate1);
    
	    WebElement calendar=driver.findElement(By.name("expectedCloseDate"));
	    calendar.sendKeys(expectedDate1);

	    driver.findElement(By.xpath("//button[contains(text(),'Create Campaign')]")).click();

	    

	}

}
