package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage 
{
	private  WebDriver driver;
	public UserProfilePage(WebDriver driver)
	{	this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@class='btn btnDropDown username ng-binding']/span")
	WebElement profilenamelocate;
	
	@FindBy(xpath="//a[contains(text(),'LOGOUT')]")
	WebElement logoutbutton;
	
	
	public void openProfilePopup() 
	{
		profilenamelocate.click();	
	}
	
	public void clickOnLogoutButton() 
	{
		logoutbutton.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
