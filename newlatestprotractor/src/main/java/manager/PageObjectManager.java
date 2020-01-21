package manager;

import org.openqa.selenium.WebDriver;

import pageObject.DepartmentPage;
import pageObject.LoginPage;
import pageObject.UserProfilePage;

public class PageObjectManager 
{
	
	private WebDriver driver;
	private  LoginPage loginPage;
	private  UserProfilePage userProfilePage;
	private  DepartmentPage departmentPage;
	

	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LoginPage getLoginPageObject() 
	{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	
	public UserProfilePage getUserProfilePageObject() 
	{
		return (userProfilePage == null ) ? userProfilePage =  new UserProfilePage(driver) : userProfilePage;
	}
	
	public DepartmentPage getDepartmentPageObject() 
	{
		return (departmentPage == null ) ? departmentPage =  new DepartmentPage(driver) : departmentPage;
	}

}
