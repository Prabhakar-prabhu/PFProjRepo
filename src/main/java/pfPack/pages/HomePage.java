package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pfPack.base.BasePage;

public class HomePage extends BasePage {
	
	
	
	public HomePage(WebDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;

	}
	@FindBy(css="[class^=_logo-calendar]")
	public WebElement Calendar;
	@FindBy(css="[class^=_logo-chat]")
	public WebElement Cliq;
	@FindBy(css="[class^=_logo-crm]")
	public WebElement CRM;
	@FindBy(css="[class^=_logo-mail]")
	public WebElement Mail;
	@FindBy(css="[class^=_logo-salesiq]")
	public WebElement SalesIq;
	
	//Reusable Methods
	
	public boolean isElementDisplayed() {
		
		return(isElementPresent(CRM));
		
		
	}
	

}
