package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	@FindBy (xpath = "//input[@autocomplete='username']")
	private WebElement userNameFeild;
	
	@FindBy (xpath = "//button[text()='Continue']")
	private WebElement continueButton;
	
	@FindBy (xpath = "//input[@type='password']")
	private WebElement passwordFeild;
	
	@FindBy (xpath = "//button[text()='Sign in']")
	private WebElement signInButton;
	
	
	private WebDriver driver;
	private Actions actions;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnUserNameFeild()
	{
		actions.moveToElement(userNameFeild).click().build().perform();
		//sendKeys(userName).build().perform();
		//Thread.sleep(1000);
	}

	public void sendDataIntoUserNameFeild(String userName) throws InterruptedException
	{
		actions.moveToElement(userNameFeild).sendKeys(userName).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnPasswordFeild()
	{
		actions.moveToElement(passwordFeild).click().build().perform();
	}
	
	public void sendDataIntoPasswordFeild(String password) throws InterruptedException
	{
		actions.moveToElement(passwordFeild).sendKeys(password).build().perform();
		Thread.sleep(1000);
	}
	
	public void clickOnSignInButton() throws InterruptedException
	{
		actions.moveToElement(signInButton).click().build().perform();
		Thread.sleep(1000);

	}
}
