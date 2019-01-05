package Automation.LearnCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Automation.Pages.CreateEvent;
import Automation.selenium.SeleniumActions;
import Automation.util.ExcelUtility;
import Automation.util.Global;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class createEvent extends SeleniumActions{

	ExcelUtility oExcel = new ExcelUtility();
	CreateEvent crtEvnt = new CreateEvent();
	String regulation;
	
	@Given("^User is logged in to EQMS Application$")
	public void user_is_logged_in_to_EQMS_Application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		openBrowser("https://xtest.employees.www.uprr.com/lic/ui/secure/index.html","C:\\Users\\xsat802\\Nilesh_Workspace\\LearnCucumber\\TestData\\data.xls");
		login(oExcel.get("username"), oExcel.get("password"));
	}

	@When("^Navigate to Create Event Page$")
	public void navigate_to_Create_Event_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		clickOnElement("xpath", "//span[text()='Licensing']");
        clickOnElement("xpath", "//span[text()='License Status']");
        clickOnElement("link", "Enter an Event");
        Thread.sleep(1000);
        pleaseWaitTillLoadingIsDone();
        fluentWaitElementToBeClickable(By.id("typeOfEvent"));
	}

	@When("^Enter Event Cause Detail$")
	public void enter_Event_Cause_Detail() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		crtEvnt.setTypeofEvent(oExcel.get("typeofevent"));
        Thread.sleep(2000);
        crtEvnt.setNonDrugNAlcoholEvent();        
        crtEvnt.setYesterdaysEventDate();
        crtEvnt.setEventTime(oExcel.get("eventtime"));
        crtEvnt.setResultOfEvent(oExcel.get("resultofevent"));
        crtEvnt.setCrewDescriptionOfIncident(oExcel.get("crewsdescription"));
        crtEvnt.setManagerComments(oExcel.get("managercomments"));
        
	}

	@When("^Click on Next Button$")
	public void click_on_Next_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		crtEvnt.clickOnNextButton();
        wait(1000);
	}

	@Then("^User should be successfully navigated to Event Information Page$")
	public void user_should_be_successfully_navigated_to_Event_Information_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fluentWaitElementToBeVisible(By.id("trainSymbol"));
	}

	@When("^Enter all fields in event information page$")
	public void enter_all_fields_in_event_information_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		wait(1000);
        crtEvnt.setTrainSymbol(oExcel.get("trainsymbol"));
        crtEvnt.setTrainTrainDay(oExcel.get("trainday"));
        crtEvnt.setTrainLoads(oExcel.get("loads"));
        crtEvnt.setTrainEmpties(oExcel.get("empties"));
        crtEvnt.setTrainTonnage(oExcel.get("tonnage"));
        crtEvnt.setTrainLength(oExcel.get("length"));
        crtEvnt.setTrainMaxAuthSpeed(oExcel.get("maxauthspeed"));
        crtEvnt.setTrainSpeedAtTimeOfIncident(oExcel.get("speedatdtimeofincident"));
	}

	@When("^Enter Sub Division and Mile post$")
	public void enter_Sub_Division_and_Mile_post() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		crtEvnt.setSubDivision(oExcel.get("subdivision"));
        Thread.sleep(2000);
        //pleaseWait();
        crtEvnt.setMilePost(oExcel.get("milepost"));
        Thread.sleep(2000);
	}

	@Then("^Chek the service unit and region is correctly populated$")
	public void chek_the_service_unit_and_region_is_correctly_populated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String reg = crtEvnt.getRegion();
        if (reg.contains(oExcel.get("region"))) {
        	System.out.println("Region is correctly set");
        } else {
        	System.out.println("Region is wrongly set");
        }
        String servunit = crtEvnt.getServiceUnit();
        if (servunit.contains(oExcel.get("serviceunit"))) {
          System.out.println("Service unit is correctly set");
        } else {
          System.out.println("Service unit is wrongly set");
        }
        crtEvnt.setSignalTerritory(oExcel.get("signalterritory"));
        crtEvnt.setTypeOfTrack(oExcel.get("typeoftrack"));
        crtEvnt.setTypeOfAuthority(oExcel.get("typeofauthority"));
        crtEvnt.setRailroad(oExcel.get("railroad"));
        if (oExcel.get("within10milesofterminal").contains("Y")) {
          crtEvnt.setWithin10MilesOfTerminalTrue();
          Thread.sleep(2000);
        } else {
          crtEvnt.setWithin10MilesOfTerminalFalse();
        }
        if (oExcel.get("initialorfinalterminal").contains("NA")) {
          // Do nothing
        } else if (oExcel.get("initialorfinalterminal").contains("Initial")) {
          crtEvnt.setInitialTerminal();
        } else if (oExcel.get("initialorfinalterminal").contains("Final")) {
          crtEvnt.setFinalTerminal();
        }
        crtEvnt.setNearestStation(oExcel.get("neareststation"));
        crtEvnt.setCrewType(oExcel.get("crewtype"));
        crtEvnt.setOperation(oExcel.get("operation"));
        crtEvnt.setWeather(oExcel.get("weather"));
        crtEvnt.setVisiblity(oExcel.get("visibility"));
        crtEvnt.setGrade(oExcel.get("grade"));
        crtEvnt.setCurvature(oExcel.get("curvature"));
        if (oExcel.get("isftxevent").contains("Yes")) {
          crtEvnt.setFTXEventTrue();
        } else {
          crtEvnt.setFTXEventFalse();
        }
        if (oExcel.get("iseventrecorder").contains("Y")) {
          crtEvnt.setEventRecorderTrue();
        } else {
          crtEvnt.setEventRecorderFalse();
        }
        if (oExcel.get("isblueflag").contains("Y")) {
          crtEvnt.setBlueFlagTrue();
        } else {
          crtEvnt.setBlueFlagFalse();
        }
	}

	@When("^Click on Next button$")
	public void click_on_Next_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 crtEvnt.clickOnNextButton();
	        if (isElementPresent(By.xpath("//button[contains(text(),'Submit')]"))) {
	          crtEvnt.clickOnSubmitButtonOnCrewListDialog();
	        }
	}

	@Then("^User should be navigate to Employee Information page$")
	public void user_should_be_navigate_to_Employee_Information_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 Thread.sleep(2000);
		 fluentWaitElementToBeClickable(By.xpath("//button[contains(text(), 'Add')]"));
	}

	@When("^Enter all fields present on Employee Information page$")
	public void enter_all_fields_present_on_Employee_Information_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 crtEvnt.setEmployeeID(oExcel.get("employeeid"));
	        crtEvnt.clickOnAddButton();
	        Thread.sleep(1000);
	        crtEvnt.setPosition(oExcel.get("position"));
	        Thread.sleep(1000);
	        crtEvnt.setYesterdaysDateOnDuty();
	        crtEvnt.setTimeOnDuty(oExcel.get("timeonduty"));
	        crtEvnt.setHoursOnDuty(oExcel.get("hoursonduty"));
	        crtEvnt.setPreviousRest(oExcel.get("previousrest"));
	        Thread.sleep(1000);
	        crtEvnt.setDirection(oExcel.get("direction"));
	        Thread.sleep(1000);
	        crtEvnt.setDirection(oExcel.get("direction"));
	        Thread.sleep(1000);
	        crtEvnt.setLastJobBriefing(oExcel.get("lastjobbriefing"));
	        Thread.sleep(1000);
	        crtEvnt.setSuspended(oExcel.get("suspended"));
	        if(oExcel.get("position").equalsIgnoreCase("eng")  || oExcel.get("position").equalsIgnoreCase("rco(brakeman)"))
	        {
	            crtEvnt.setRegulation(oExcel.get("regulationeng"));
	            regulation=oExcel.get("regulationeng");
	            crtEvnt.setPrimaryRuleNumber(oExcel.get("primaryrulenumber"));
	            Thread.sleep(500);
	            crtEvnt.setOperatingMoreThan6Months(oExcel.get("isoperatinglongerthan6months"));
	        }else if(oExcel.get("position").equalsIgnoreCase("con") || oExcel.get("position").equalsIgnoreCase("rco(conductor)"))
	        {
	           crtEvnt.setRegulation(oExcel.get("regulationcon"));
	            regulation=oExcel.get("regulationcon");
	            crtEvnt.setPrimaryRuleNumber(oExcel.get("primaryrulenumber"));
	            Thread.sleep(500);
	            crtEvnt.setOperatingMoreThan6Months(oExcel.get("isoperatinglongerthan6months"));
	        }     
	}

	@When("^Click on Create Event button$")
	public void click_on_Create_Event_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		crtEvnt.clickOnEnterEventButton();
//      crtEvnt.clickOnBackButton();
//      pleaseWait();
         pleaseWaitTillLoadingIsDone();
        Thread.sleep(2000);
	}

	@Then("^User should see the success message$")
	public void user_should_see_the_success_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String succMsg=getTextFromWebElement("xpath", "//div[@class='text-pre']");
        
        if(succMsg.equalsIgnoreCase("Event Created successfully.")){
        }else{
          Global.drv.quit();
        }
	}

	@Then("^Event should be created successfully$")
	public void event_should_be_created_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^I verify the Fail in step$")
	public void i_verify_the_Fail_in_step() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
