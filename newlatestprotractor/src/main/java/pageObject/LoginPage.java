package pageObject;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import manager.FileReaderManager;

public class LoginPage 
{

	private WebDriver driver;
	public LoginPage(WebDriver driver)
	{	
		this.setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-secondary-outline-sm mar-right-8 mar-left-8']")
	WebElement openloginpopup;
	
	@FindBy(id="signin_email")
	WebElement emailidfield;
	
	@FindBy(id="signin_password")
	WebElement passwordfield;
	
	@FindBy(id="signin-submit")
	WebElement signinbutton;
	 
	@FindBy(xpath="//p[@class='ng-binding']")
	WebElement dashboardtitleline;
     
	public void openLoginPopup() throws IOException 
	{
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
		openloginpopup.click();
	}
	
	public void enterEmailAddress(String email) 
	{
		emailidfield.sendKeys(email);
	}
	
	public void enterPassword(String pasword) 
	{
		passwordfield.sendKeys(pasword);
	}
	
	public void clickOnSignInButton() 
	{
		signinbutton.click();
	}
	
	public void verifyDashbaordPageDisplayOrNot() throws InterruptedException 
	{
		Thread.sleep(500);
		String exp_message = "Here is some info to help you having a good overview of your work";
		String expectedtitle = dashboardtitleline.getText();
		 Assert.assertEquals(expectedtitle, exp_message );
	}
	
	public void userGetLoginToApplication(String email,String pasword) 
	{
		
		enterEmailAddress(email);
		enterPassword(pasword);
		clickOnSignInButton();	
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
    
 	
}
