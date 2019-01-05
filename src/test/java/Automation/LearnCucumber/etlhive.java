package Automation.LearnCucumber;

import Automation.selenium.SeleniumActions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class etlhive extends SeleniumActions{

	@Given("^Open chrome borwser$")
	public void open_chrome_borwser() throws Throwable {
		openBrowser("https://www.etlhive.com/","C:\\Users\\xsat802\\Nilesh_Workspace\\LearnCucumber\\TestData\\data.xls");   
	}

	@Given("^enter the url$")
	public void enter_the_url() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Page is getting load$")
	public void page_is_getting_load() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^click on selenium tutorial$")
	public void click_on_selenium_tutorial() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
