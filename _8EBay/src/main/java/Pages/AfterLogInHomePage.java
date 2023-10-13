package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterLogInHomePage {
	
	@FindBy (xpath = "(//a[text()='Electronics'])[2]")
	private WebElement electronicsTab;
	
	@FindBy (xpath = "(//a[@class='hl-cat-nav__js-link'])[8]")
	private WebElement appleTab;
	
	private WebDriver driver;
	private Actions actions;
	
	public AfterLogInHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnAppleTab() throws InterruptedException
	{
		actions.moveToElement(electronicsTab).build().perform();
		Thread.sleep(500);
		
		actions.moveToElement(appleTab).click().build().perform();
		Thread.sleep(500);
	}
	
	

}
