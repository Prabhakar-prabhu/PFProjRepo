package pfPack.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver,ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
		
		
	}
	
	@FindBy(id="login_id")
	public WebElement EmailInput;
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	@FindBy(id="password")
	public WebElement PasswordInput;
	@FindBy(id="nextbtn")
	public WebElement SignIn;
	
	//Reusable methods
	
	public boolean doLogin(String userName, String password) {
		
		EmailInput.sendKeys(userName);
		eTest.log(LogStatus.INFO,"UserName "+userName+" is Entered");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		NextButton.click();
		eTest.log(LogStatus.INFO, "NextButton is clicked");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		PasswordInput.sendKeys(password);
		eTest.log(LogStatus.INFO, "Password is provided");
		SignIn.click();
		eTest.log(LogStatus.INFO, "Sign in button is clicked");
		HomePage homePage=new HomePage(driver,eTest);
		PageFactory.initElements(driver, homePage);
		boolean displayStatus=homePage.isElementDisplayed();
		
		if(displayStatus) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
