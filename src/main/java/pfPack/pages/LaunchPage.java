package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LaunchPage extends BasePage {

	
	//Below constructor is used to pass the driver and test report throughout the pages from BaseTest
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		
		this.driver=driver;
		this.eTest=eTest;
	}
	
	@FindBy(className="zh-customers")
	public WebElement Customer;
	@FindBy(className="zh-support")
	public WebElement Support;
	@FindBy(className="zh-login")
	public WebElement SignIn;
	@FindBy(className="zh-signup")
	public WebElement SignUp;
	
	//Reusable methods for Launch Page
	
	public boolean doLaunch(String URL) {
		
		driver.get(URL);
		eTest.log(LogStatus.INFO, URL+" is Launched");
		SignIn.click();
		eTest.log(LogStatus.INFO, "Sign in Button is clicked");
		LoginPage loginPage= new LoginPage(driver,eTest);
		PageFactory.initElements(driver, loginPage);
		
		boolean displayStatus=loginPage.doLogin(Constants.USERNAME,Constants.PASSWORD);
		if(displayStatus) {
			return true;
		}
		else
			return false;
	}
	
	
}
