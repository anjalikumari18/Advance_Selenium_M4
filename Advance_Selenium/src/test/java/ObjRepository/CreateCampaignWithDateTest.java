package ObjRepository;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebDriverUtility.WebDriverUtility;

public class CreateCampaignWithDateTest extends BaseClass {

	@Test(groups = "regression")
	public void createCampwithDateTest() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		JavaUtility jutil = new JavaUtility();
		int r = jutil.getRandomNumber();

		ExcelUtility eutil = new ExcelUtility();
		String cname = eutil.getDataFromExcel("Sheet1", 1, 0);
		String targetsize = eutil.getDataFromExcel("Sheet1", 1, 1);
		System.out.println(targetsize + r);

		// click on Campaign button
		HomePage hp = new HomePage(driver);
		hp.clickonCampaignbtn();

		CampaignPage cp = new CampaignPage(driver);
		cp.enterCmpname(cname + r);
		cp.entertargetsize(targetsize);

		String reqdate = jutil.getRequiredDateddMMYYYY(10);

		cp.getCdate().sendKeys(reqdate);
		;

		cp.clickOnCreateCampaignBtn();

		// Verification
		WebElement message = cp.getCpntoastmsg();
		wutil.waitForVisibilityOfWebelement(driver, message);
		String msg = message.getText();
		if (msg.contains(cname)) {
			System.out.println("Successfully Created the campaign " + cname);
		} else {
			System.out.println("Failed to Create the campaign " + cname);
		}

	}

}
