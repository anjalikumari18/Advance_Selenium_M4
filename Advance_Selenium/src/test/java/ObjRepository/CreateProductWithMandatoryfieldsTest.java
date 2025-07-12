package ObjRepository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.HomePage;
import ObjectRepository.ProductPage;
import WebDriverUtility.WebDriverUtility;


public class CreateProductWithMandatoryfieldsTest extends BaseClass{

	@Test(groups = "regression")
	public void createProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub	
		
		ExcelUtility eutil=new ExcelUtility();
		WebDriverUtility wutil2=new WebDriverUtility();
		JavaUtility jp=new JavaUtility();
		int r = jp.getRandomNumber();	   
		
		ProductPage pp=new ProductPage(driver);

		HomePage hp=new HomePage(driver);
		hp.getProductsbtn().click();
		hp.getCreateProdbtn().click();
		
		String Productname = eutil.getDataFromExcel("Product",1, 2);
		String quantityval = eutil.getDataFromExcel("Product", 1, 5);
		String priceval = eutil.getDataFromExcel("Product", 1, 6);

		
		pp.getProductnametf().sendKeys(Productname+r);
		WebElement categorydropdown=pp.getProductCategoryDD();
		//Dropdown 1
		Select drop1=new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		WebElement quantity=pp.getQuantityTF();
		quantity.clear();
		quantity.sendKeys(quantityval);
		WebElement Price = pp.getPricetf();
		Price.clear();
		Price.sendKeys(priceval);
		//DropDown 2
		WebElement vendordropdown=pp.getVendorIdDD();
		Select drop2=new Select(vendordropdown);
		drop2.selectByValue("VID_007");

		pp.getCreateProductBtn().click();

		//Verification
		WebElement message = pp.getToastmsgProd();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(message));
		
		String msg = message.getText();
		 if(msg.contains(Productname)) {
			 System.out.println("Successfully Created the product "+Productname);	 
		 }else {
			 System.out.println("Failed to Create the product "+Productname);
		 }	 

	}
	
	

}
