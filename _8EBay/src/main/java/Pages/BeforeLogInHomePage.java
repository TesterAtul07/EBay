package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BeforeLogInHomePage {
	
	@FindBy (xpath = "//button[@class='gh-control ghn-b gh-eb-li-a']")
	private WebElement notificationIcon;
	
	@FindBy (xpath = "//span[text()='sign-in']")
	private WebElement signInLink;
	
	private WebDriver driver;
	private Actions actions;
	
	public BeforeLogInHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnSingInLink() throws InterruptedException
	{
		actions.moveToElement(notificationIcon).perform();
		actions.moveToElement(notificationIcon).moveToElement(signInLink).click().build().perform();
		Thread.sleep(1000);
		
	}
	

}
