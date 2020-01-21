package Runner;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import manager.FileReaderManager;
;


@RunWith(Cucumber.class)
@CucumberOptions(
		
features = "src/test/java"
,glue= {"StepDefinations"},
/*plugin = { "usage" }*/
/*plugin = { "pretty", "html:target/cucumber-reports",
		"json:target/cucumber-reports/Cucumber.json",
		 "junit:target/cucumber-reports/Cucumber.xml" }*/
plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html " })
/*plugin = { "pretty" },
monochrome = true*/ 
//glue= {"StepDefinations", "selenium"}
public class testrunner 
{
	@AfterClass
	public static void writeExtentReport() throws IOException 
	{
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigFileReader().getReportConfigPath()));
		 Reporter.setSystemInfo("nitin tajane", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("Machine", "Windows 7" + "64 Bit");
	     Reporter.setSystemInfo("Selenium", "3.7.0");
	     Reporter.setSystemInfo("Maven", "3.5.2");
	     Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
