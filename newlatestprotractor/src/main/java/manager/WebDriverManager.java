package manager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager 
{
	private static WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	private static final String IEXPLORE_DRIVER_PROPERTY = "webdriver.iexplore.driver";

	public WebDriverManager() throws IOException
	{
		
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType =  FileReaderManager.getInstance().getConfigFileReader().getEnvironmentType();
		
	}
	
	public static  WebDriver getDriver() throws IOException
	{
		if(driver==null) driver = createDriver();
		return driver;
	}

	private static WebDriver createDriver() throws IOException 
	{
		switch (environmentType) 
		{
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private static WebDriver createRemoteDriver() 
	{
		// TODO Auto-generated method stub
		return driver;
	}

	private static WebDriver createLocalDriver() throws IOException 
	{
		String getdriverpath = FileReaderManager.getInstance().getConfigFileReader().getDriverPath();
		switch(driverType)
		{
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, getdriverpath);
			driver =  new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FIREFOX_DRIVER_PROPERTY, getdriverpath);
			driver =new FirefoxDriver();
			break;
		case INTERNETEXPLORER:
			System.setProperty(IEXPLORE_DRIVER_PROPERTY, getdriverpath);
			driver = new InternetExplorerDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
}
