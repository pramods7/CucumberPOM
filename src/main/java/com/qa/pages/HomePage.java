package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	

	public HomePage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifyHomePageTitle(){
		
		return driver.getTitle();
		
	}
	
	
	public boolean verifyCorrectUserName(){
			
		return userNameLabel.isDisplayed();
		
	}
	

	
	public void clickOnNewContactLink(){
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(ContactsLink).build().perform();
		
		newContactLink.click();
	}
	
}
