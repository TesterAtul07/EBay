package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TargetProductPage {
	
	@FindBy (xpath = "//h1[@class='bhp__title']")
	private WebElement targetProductName;
	
	private WebDriver driver;
	
	public TargetProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public String getTargetProductName()
	{
		String name = targetProductName.getText();
		return name;
		
	}

}
