package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Enabled {

	@Test(priority = -4)
	public void Flipkart() {
		Reporter.log("Flipkart executed", true);
	}
	
	@Test(enabled = false)
	public void Blinkit() {
		Reporter.log("Blinkit executed", true);
	}
	
	@Test(enabled = false)
	public void Myntra() {
		Reporter.log("Myntra executed", true);
	}
	
	@Test(enabled = true)
	public void Amazon() {
		Reporter.log("Amazon executed", true);
	}
	
	@Test(enabled = false)
	public void Ebay() {
		Reporter.log("Ebay executed", true);
	}
	
	
	
}
