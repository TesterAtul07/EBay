package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TiredOfPasswordPage {

	@FindBy (xpath = "//button[text()='Turn on']")
	private WebElement turnOnButton;
	
	@FindBy (xpath = "//button[text()='Maybe later']")
	private WebElement mayBeLaterButton;
	
	private WebDriver driver;
	private Actions actions;
	
	public TiredOfPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnMayBeLaterButton() throws InterruptedException
	{
		boolean result = turnOnButton.isDisplayed();
		
		if(result==true)
		{
		    actions.moveToElement(mayBeLaterButton).click().build().perform();
		    Thread.sleep(500);
		}
		else
		{
              System.out.println();
		}
	}
}
