package _8EBayTestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Browser;
import EBayUtility.Utilities;
import Pages.AfterLogInHomePage;
import Pages.ApplePage;
import Pages.AppleSalePhonesAndSamartPhones;
import Pages.BeforeLogInHomePage;
import Pages.SignInPage;
import Pages.TargetProductPage;
import Pages.TiredOfPasswordPage;

public class TestClass extends Browser {
	
	private WebDriver driver;
	private AfterLogInHomePage afterLogInHomePage;
	private ApplePage applePage;
	private AppleSalePhonesAndSamartPhones  appleSalePhonesAndSamartPhones;
	private BeforeLogInHomePage beforeLogInHomePage;
	private SignInPage signInPage;
	private TargetProductPage targetProductPage;
	private TiredOfPasswordPage tiredOfPasswordPage;
	private String TestID;
	
	
	@BeforeTest
	public void beforeLaunchBrowser(String browsername)
	{
		 if(browsername.equals("chrome"))
			{
			  driver = launchChrome();
			}
			
			if(browsername.equals("firefox"))
			{
				driver = launchFireFox();	
			}
			
			if(browsername.equals("microsoftEdge"))
			{
				driver = launchEdge();
			}
			
							
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	}
	
	@BeforeClass
	public void creatingPOMObject()
	{
		afterLogInHomePage = new AfterLogInHomePage(driver);
		applePage = new ApplePage(driver);
		appleSalePhonesAndSamartPhones = new AppleSalePhonesAndSamartPhones(driver);
		beforeLogInHomePage = new BeforeLogInHomePage(driver);
		signInPage = new SignInPage(driver);
		targetProductPage = new TargetProductPage(driver);
		tiredOfPasswordPage = new TiredOfPasswordPage(driver);
	}
	
	@BeforeMethod
	public void launchBrowser() throws InterruptedException
	{
		driver.get("");
		beforeLogInHomePage.clickOnSingInLink();
		signInPage.clickOnUserNameFeild();
		signInPage.sendDataIntoUserNameFeild("");
		signInPage.clickOnPasswordFeild();
		signInPage.sendDataIntoPasswordFeild("");
		signInPage.clickOnSignInButton();
		tiredOfPasswordPage.clickOnMayBeLaterButton();	
	}
	
	
	
	@Test
	public void VerifyElectronicsTabAndItsFunctionality() throws InterruptedException
	{
		TestID = "EB001";
		AfterLogInHomePage afterLogInHomePage = new AfterLogInHomePage(driver);
		afterLogInHomePage.clickOnAppleTab();
		ApplePage applePage = new ApplePage(driver);
		applePage.clickOnAppleSalePhonesAndSmartPhones();
		AppleSalePhonesAndSamartPhones appleSalePhonesAndSamartPhones = new AppleSalePhonesAndSamartPhones(driver);
		appleSalePhonesAndSamartPhones.clickOnTargetProduct();
		TargetProductPage targetProductPage = new TargetProductPage(driver);
		targetProductPage.getTargetProductName();	
	}
	
	@AfterMethod
	public void ScreenshotOfFailedTests(ITestResult result) throws IOException
	{
		
		if(ITestResult.FAILURE == result.getStatus())
		{
		  Utilities.captureScreenshot(driver, "test-output//FailedTestScreenshot", TestID);
	     }
		
		
	}
	
	
	@AfterClass
	public void clearingPOMObject()
	{
		afterLogInHomePage = null;
		applePage = null;
		appleSalePhonesAndSamartPhones = null;
		beforeLogInHomePage = null;
		signInPage = null;
		targetProductPage = null;
		tiredOfPasswordPage = null;

	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
		System.gc();
	}
}
