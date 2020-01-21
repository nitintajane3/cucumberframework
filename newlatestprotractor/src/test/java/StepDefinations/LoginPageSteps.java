package StepDefinations;

import java.util.List;
import java.util.Map;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObject.LoginPage;

public class LoginPageSteps 
{

	TestContext testContext;
	LoginPage  loginPage;
	
	public LoginPageSteps(TestContext context)
	{
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPageObject();
	}

	@Given("^user enters credentional$")
    public void user_enters_username_and_Password(DataTable  userdetails) throws Throwable 
	{  	
    	List<Map<String,String>> data = userdetails.asMaps(String.class,String.class);
    	loginPage.openLoginPopup();
    	Thread.sleep(500);
    	loginPage.userGetLoginToApplication(data.get(0).get("username"), data.get(0).get("password"));
    	
    }
    
    @When("^dashboard display or not$")
    public void success_message_is_displayed() throws Throwable 
    {
    	Thread.sleep(1000);
    	loginPage.verifyDashbaordPageDisplayOrNot();
    	Reporter.addScenarioLog("dashboard page has verified");
    	
    }
}
