package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtility.PropertyFileUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.LoginPage;
import WebDriverUtility.WebDriverUtility;

    public class BaseClass {
	
	public WebDriver driver;
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sDriver=null; //for listners
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void configBS() {
		Reporter.log("Establish the DB connectivity",true);
	}
	
	@BeforeTest(groups ={"smoke","regression"} )
	public void configBT() {
		Reporter.log("Pre-condition",true);
	}
	
	//@Parameters("Browser") //For cross browser parallel execution
	@BeforeClass(groups = {"smoke","regression"})
	
	public void configBC(/*String brow*/) throws IOException {
		Reporter.log("Launching the browser", true);
		//String BROWSER=brow; //CBPT
		String BROWSER = putil.getDataFromPropertiesFile("browser");
		String URL=putil.getDataFromPropertiesFile("url");
		
		//CROSS BROWSER TESTING 
	
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		sDriver=driver; //for listeners

		//Launching the url
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws IOException {
		String USERNAME=putil.getDataFromPropertiesFile("username");
		String PASSWORD=putil.getDataFromPropertiesFile("password");

	       LoginPage lp=new LoginPage(driver);
	       lp.logintoNCRM(USERNAME, PASSWORD);
			Reporter.log("Logged in to NCRM", true);

	}

	@AfterMethod(groups = {"smoke","regression"})
	public void configAM() throws InterruptedException {
		 CampaignPage cp=new CampaignPage(driver);
		  cp.logout();
		Reporter.log("Logged out successfully", true);
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void configAC() {
		 driver.close();
		Reporter.log("Browser closed", true);
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void configAT() {
		Reporter.log("Post-condition", true);
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void configAS() {
		Reporter.log("Disconnect DB", true);
	}
}
