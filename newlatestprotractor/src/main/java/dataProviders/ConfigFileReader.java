package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;



public class ConfigFileReader 
{

	String directorypath = System.getProperty("user.dir");
	private  Properties properties;
	private final String propertyfilepath = directorypath+"\\src\\main\\java\\configs\\configuration.properties"; 
	
	
	public ConfigFileReader() throws IOException
	{
		BufferedReader reader;
		try 
		{
			reader = new BufferedReader(new FileReader(propertyfilepath));
			properties =  new Properties();
			
			try 
			{
				properties.load(reader);
				reader.close();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("property file not found at this location : " + propertyfilepath);
		}
	}
	
	public String getDriverPath()
	{
		String getbrowsertype = properties.getProperty("browser");
		String driverpath = null;
		
		if (getbrowsertype.equalsIgnoreCase("chrome")) 
		{
			driverpath = directorypath + properties.getProperty("chromedriverpath");
			if (driverpath != null) return driverpath; 
			
		
		}else if (getbrowsertype.equalsIgnoreCase("firefox")) 
		{

			driverpath = directorypath + properties.getProperty("geckodriverpath");
			if (driverpath != null) return driverpath; 
			
			
		}else if (getbrowsertype.equalsIgnoreCase("iexplore")) 
		{
			driverpath = directorypath + properties.getProperty("driverpath");
			if (driverpath != null) return driverpath; 
			
		}else 
		{
			throw new RuntimeException("driverPath not specified in the Configuration.properties file ");
		}
		return driverpath;
		
	}
	
	public long getImplicitlyWait() 
	{
		String implicitlyWait  = properties.getProperty("implicitlywait");
		if (implicitlyWait !=null) return Long.parseLong(implicitlyWait);
		else throw  new RuntimeException("implicitly wait not specified in the Configuration.properties file ");
	}
	
	public String getApplicationUrl() 
	{
		String applicationurl = properties.getProperty("url");
		if(applicationurl != null) return applicationurl;
		else throw  new RuntimeException("Application URL  not specified in the configuration.properties file");
	}
	
	public DriverType getBrowser()
	{
		String browsername = properties.getProperty("browser");
		if(browsername==null || browsername.equals("chrome")) return DriverType.CHROME;
		if (browsername.equals("firefox")) return DriverType.FIREFOX;
		if(browsername.equals("iexplore")) return DriverType.INTERNETEXPLORER;
		else throw new RuntimeException("browser name key not get from configuration.properties file");
	}
	
	public EnvironmentType  getEnvironmentType()
	{
		String environmentname = properties.getProperty("environment");
		if(environmentname==null || environmentname.equals("local")) return EnvironmentType.LOCAL;
		if(environmentname.equals("remote")) return EnvironmentType.REMOTE;
		else throw  new RuntimeException("Environment key not got from  configuration.properties file");
	}
	
	public boolean getBrowserWindowSize()
	{
		String windowSize =  properties.getProperty("windowMaximize");
		if(windowSize!=null) return Boolean.valueOf(windowSize);
		return true;
	}
	
	public String getReportConfigPath(){
		String reportConfigPath = directorypath + properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
}
