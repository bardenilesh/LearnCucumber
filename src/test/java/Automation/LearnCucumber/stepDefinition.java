package Automation.LearnCucumber;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import Automation.selenium.SeleniumActions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepDefinition extends SeleniumActions{
	@Given("^url opened$")
	public void url_opened() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		openBrowser("https://accounts.google.com","");
	}

	@Then("^enter user id and click next$")
	public void enter_user_id_and_click_next() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		enterText("id", "identifierId", "msbot01");		
		clickOnElement("xpath", ".//*[@id='identifierNext']/content/span");
	}

	@Then("^enter password$")
	public void enter_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions.
		try {
//			List <String> lst = new ArrayList<String>();
			wait(2000);
			WebElement el = findElement("xpath", "//*[regexp:(text(), 'Forgot password?')]");
			//[a-zA-Z0-9]{1,}[@][a-zA-Z0-9]{1,}[.][a-zA-Z0-9]{3}')]
			System.out.println(el);
			enterText("name", "password", "@dgjadgj");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^click login$")
	public void click_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//clickOnElement("xpath", ".//*[@id='passwordNext']/content/span");
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {
		closeBrowser();
	    // Write code here that turns the phrase above into concrete actions
	}
}
