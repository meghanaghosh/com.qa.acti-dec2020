package com.acti.pages; //VIDEO 41

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;


/*Tester Name: Meghana
 *Date Created:
 *Approved By: Meghana
 * 
 */

public class LoginPage extends DriverScript {
	
	// for Page Object Model it will be identified by @FindBy and not driver.Findelement
	
	@FindBy(id="username") WebElement usernameTextbox;
	@FindBy(name="pwd") WebElement passwordTextbox;
	@FindBy(id="loginButton") WebElement loginButton;
	@FindBy(xpath="//div[@class='atLogoImg']") WebElement actiLogo;

//***************************************************************//
	public LoginPage() {
	
		//PageFactory is a class present in selenium that supports POM and it is used to initialise the objects
		
		PageFactory.initElements(driver, this); //this means the above page elements
		
	}
	
//***************************************************************//	
	
	public void validateLoginFunction(String username, String password)
	{
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);
		loginButton.click();
	}

//***************************************************************//
	
	public boolean verifyActiLogo()
	{
		return actiLogo.isDisplayed();
	}
	
//***************************************************************//

	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
}
