package StepDefinations;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObject.UserProfilePage;

public class UserProfilePageSteps 
{
	TestContext testContext;
    UserProfilePage userprofilepage;
    
	public  UserProfilePageSteps(TestContext context) 
	{
		testContext = context;
		userprofilepage = testContext.getPageObjectManager().getUserProfilePageObject();
	}
	
	 @Then("open logout page")
	    public void open_logout_page() throws InterruptedException
	    {
	    	Thread.sleep(1000);
	    	userprofilepage.openProfilePopup();
	    }
	    
	    @Then("^user get logout$")
	    public void user_get_logout() throws InterruptedException
	    {
	    	Thread.sleep(500);
	    	userprofilepage.clickOnLogoutButton();
	    }
}
