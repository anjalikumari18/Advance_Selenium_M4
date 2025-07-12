package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_Priority {

	@Test(priority = -4)
	public void Flipkart() {
		Reporter.log("Flipkart executed", true);
	}
	
	@Test(priority = 0)
	public void Myntra() {
		Reporter.log("Myntra executed", true);
	}
	
	@Test(priority = 3)
	public void Amazon() {
		Reporter.log("Amazon executed", true);
	}
	
	@Test(priority = 7)
	public void Ebay() {
		Reporter.log("Ebay executed", true);
	}
	
	@Test(priority = 3)
	public void Ajio() {
		Reporter.log("Ajio executed", true);
	}
	
	@Test(priority = 1)
	public void Nyka() {
		Reporter.log("Nyka executed", true);
	}
	
	
}
