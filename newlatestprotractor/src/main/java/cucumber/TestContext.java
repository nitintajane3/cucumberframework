package cucumber;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import manager.PageObjectManager;
import manager.WebDriverManager;

public class TestContext 
{
  private WebDriverManager webdrivermanager;
  private PageObjectManager pageobjectmanager;

  public TestContext() throws IOException
  {
	  webdrivermanager = new WebDriverManager();
	  pageobjectmanager = new PageObjectManager(WebDriverManager.getDriver());
  }
  
  public WebDriverManager getWebDriverManager() 
  {
	  return webdrivermanager;
	  }
	  
	  public PageObjectManager getPageObjectManager() 
	  {
	  return pageobjectmanager;
	  }
}
