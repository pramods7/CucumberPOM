package com.qa.stepDefinitions;

import java.util.concurrent.TimeUnit;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class HomePageSteps extends TestBase {
	LoginPage loginpage;
	HomePage homePage;

	
	@Given("^user opens browser$")
	public void user_opens_browser() {
	 TestBase.initialization();
	 	 
	}

	@Then("^user is on Login Page$")
	public void user_is_on_Login_Page() {
		loginpage = new LoginPage();
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software", title);
				
	}

	@Then("^user logs into app$")
	public void user_enters_username_and_password() throws InterruptedException {

		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	
	@Then("^validate home page title$")
	public void validate_home_page_title()  {
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);
		
	}

	@Then("^validate logged in username$")
	public void validate_logged_in_username()  {
	
		TestBase.switchToFrame();
	Assert.assertTrue(homePage.verifyCorrectUserName());
	
	
	}
	
	
	
	
	
	
	
	
}
