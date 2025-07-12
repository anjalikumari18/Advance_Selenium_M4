package TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelperAttribute_DependsOnMethods {
    @Test(enabled = true)
	public void createAccount() {
		Reporter.log("Account created successfully",true);
	}
	@Test(dependsOnMethods = "createAccount", enabled =true)
	public void EditAccount() {
		Reporter.log("Account edited successfully",true);
	}
	@Test(dependsOnMethods = "createAccount")
	public void DeleteAccount() {
		Reporter.log("Account deleted successfully",true);
	}
	
	
	
	
	
}
