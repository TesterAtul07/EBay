package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplePage {
	
	@FindBy (xpath = "//a[text()='Apple Cell Phones & Smartphones']")
	private WebElement appleSalePhonesAndSmartPhones;
	
	private WebDriver driver;
	
	public ApplePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnAppleSalePhonesAndSmartPhones() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(appleSalePhonesAndSmartPhones).click().build().perform();
		Thread.sleep(500);

	}
}
