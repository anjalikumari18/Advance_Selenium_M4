package ObjRepository;

 import java.io.IOException;
 import java.time.Duration;

 import org.apache.poi.EncryptedDocumentException;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
 import org.testng.Reporter;
 import org.testng.annotations.Listeners;
 import org.testng.annotations.Test;

 import BaseClass.BaseClass;
 import GenericUtility.ExcelUtility;
 import GenericUtility.JavaUtility;
 import GenericUtility.PropertyFileUtility;
 import ListenerUtility.ListenerImplementationClass;
 import ObjectRepository.CampaignPage;
 import ObjectRepository.HomePage;
 import ObjectRepository.LoginPage;
 import WebDriverUtility.WebDriverUtility;
 @Listeners(ListenerImplementationClass.class)
 public class CreateCampaignTest extends BaseClass {

	@Test(groups = "smoke")
	public void CreateCpgnTest() throws EncryptedDocumentException, IOException {

		HomePage hp = new HomePage(driver);
		hp.clickonCampaignbtn();

		JavaUtility jutil = new JavaUtility();
		int r = jutil.getRandomNumber();

		ExcelUtility eutil = new ExcelUtility();
		String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(targetsize + r);

		CampaignPage cp = new CampaignPage(driver);
		cp.enterCmpname(cname + r);
		cp.entertargetsize(targetsize);

		cp.clickOnCreateCampaignBtn();

		// Verification
		WebElement message = cp.getCpntoastmsg();
		wutil.waitForVisibilityOfWebelement(driver, message);
		String msg = message.getText();
		Boolean status=msg.contains(cname);
		
		//Hard Assert
		
		Assert.assertEquals(status, false, "Failed to create Campaign"+cname);
		Reporter.log("Successfully created the campaign"+cname, true);
		

	}

}















/*if (msg.contains(cname)) {
System.out.println("Successfully Created the campaign " + cname);
} else {
System.out.println("Failed to Create the campaign " + cname);
}*/
