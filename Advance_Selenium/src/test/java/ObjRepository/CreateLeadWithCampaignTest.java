package ObjRepository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;

import ObjectRepository.HomePage;
import ObjectRepository.LeadPage;



public class CreateLeadWithCampaignTest extends BaseClass {

	@Test(groups = "smoke")
	public  void createLeadWithCpgnTest()  throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub

	
		
		JavaUtility jutil=new JavaUtility();
		int r=jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
      
		HomePage hp=new HomePage(driver);
		hp.clickOnLeadsbtn();
		
		LeadPage ldp=new LeadPage(driver);
		ldp.clickOnCreateLeadBtn();
		
		String leadname = eutil.getDataFromExcel("Lead", 1, 0);
		String company = eutil.getDataFromExcel("Lead", 1, 1);
		String leadsource = eutil.getDataFromExcel("Lead", 1, 2);
		String industry = eutil.getDataFromExcel("Lead", 1, 3);
		String leadstatus = eutil.getDataFromExcel("Lead", 1, 4);
		String phoneno=eutil.getDataFromExcel("Lead", 1, 5);
		String rating=eutil.getDataFromExcel("Lead", 1, 6);

		
		ldp.getLeadNametf().sendKeys(leadname+r);
		ldp.getLeadSourcetf().sendKeys(leadsource+r);
		ldp.getCompanytf().sendKeys(company+r);
		ldp.getIndustrytf().sendKeys(industry+r);
		ldp.getLeadStatustf().sendKeys(leadstatus+r);
		ldp.getPhonetf().sendKeys(phoneno+r);
		ldp.getRating().sendKeys(rating+r);
		ldp.getAddCpgnBtn().click();
		
        wutil.toSwitchToWindow(driver);	
        ldp.getSelectbtn().click();
        wutil.toSwitchToParent(driver);
        
        ldp.getCreateLeadSubmitButton().click();
        
        //Verification
  		WebElement message1 =driver.findElement(By.xpath("//div[contains(text(), 'Lead ')]"));
  		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
  		wait.until(ExpectedConditions.visibilityOf(message1));
  		
  		String msg1 = message1.getText();
  		boolean status = msg1.contains(leadname);
  		
  		//Soft Assert implementation
  		
  		SoftAssert soft=new SoftAssert();
  		soft.assertEquals(status, false, "Failed to create the lead"+leadname);
  		soft.assertAll();
  		
  		
        
	}

}










/*  if(msg1.contains(leadname)) {
	 System.out.println("Successfully Created the campaign "+leadname);	 
}else {
	 System.out.println("Failed to Create the campaign "+leadname);
}*/
