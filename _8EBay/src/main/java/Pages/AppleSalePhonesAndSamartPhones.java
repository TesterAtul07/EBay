package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleSalePhonesAndSamartPhones {
	
	@FindBy (xpath = "(//li[@class='carousel__snap-point'])[1]")
	private WebElement targetProduct;
	
	
	private WebDriver driver;
	
	public AppleSalePhonesAndSamartPhones(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void clickOnTargetProduct() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(targetProduct).click().build().perform();
		Thread.sleep(500);

	}
}
