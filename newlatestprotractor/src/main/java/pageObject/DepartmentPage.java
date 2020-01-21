package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepartmentPage 
{

   private WebDriver  driver;
	
	public DepartmentPage(WebDriver  driver)
	{
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'DEPARTMENTS')]")
	WebElement  departmentlink;
	
	@FindBy(xpath="//span[@class='pageMainHeaderTitle ng-binding']")
	WebElement departmentpagetitle;
	
	public void clickOnDeparmentLnk() 
	{
		departmentlink.click();
	}
	
	public void verifyDepartmentPageOpenOrNot() 
	{
		String expectedname = "DEPARTMENTS";
		Assert.assertEquals(expectedname, departmentpagetitle.getText());
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
}
