package pfPack.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pfPack.pages.LaunchPage;
import pfPack.test.base.BaseTest;
import pfPack.util.Constants;

public class LoginTest extends BaseTest {
	
	
	@Test
	public void testLogin() {
		
		
		eTest= eReport.startTest("Login Test Started");
		eTest.log(LogStatus.INFO, "Login Test Started");
		openBroswer(Constants.BROWSER_TYPE);
		
		LaunchPage launchPage=new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchPage);
		boolean displayStatus=launchPage.doLaunch(Constants.APP_URL);
		
		if(displayStatus) {
			reportPass("Login Test is Passed and the homePage is LAunched");
		}
		else {
			reportFail("Login Test Failed");
		}
		
		
		
	}
	
	@AfterClass
	public void testClosure() {
		
		if(eReport!=null) {
			eReport.endTest(eTest);
			eReport.flush();
		}
		
		/*if(driver!=null) {
			driver.quit();
		}
		*/
	}

}
