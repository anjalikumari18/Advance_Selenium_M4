package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver; //this indicates pointing towards updated address

     PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name = "productName")
	private WebElement productnametf;
	
	@FindBy(name = "quantity")
	private WebElement quantityTF;
	
	@FindBy(name = "price")
	private WebElement pricetf;
	
	@FindBy(name = "productCategory")
	private WebElement productCategoryDD;
	
	@FindBy(name = "vendorId")
	private WebElement vendorIdDD;
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement createProductBtn;
	
	@FindBy(xpath = "//div[contains(text(), 'Product')]")
	private WebElement ToastmsgProd;
	

	public WebElement getToastmsgProd() {
		return ToastmsgProd;
	}


	public WebElement getProductnametf() {
		return productnametf;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getQuantityTF() {
		return quantityTF;
	}

	public WebElement getPricetf() {
		return pricetf;
	}

	public WebElement getProductCategoryDD() {
		return productCategoryDD;
	}

	public WebElement getVendorIdDD() {
		return vendorIdDD;
	}

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}
	
	
	
	
	
}
