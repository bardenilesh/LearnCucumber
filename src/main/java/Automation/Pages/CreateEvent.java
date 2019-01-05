package Automation.Pages;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import Automation.selenium.SeleniumActions;


public class CreateEvent extends SeleniumActions{
  public void setTypeofEvent(String eventTypeValue) throws Exception {
    selectTextFromDropDown("id", "typeOfEvent", eventTypeValue);
  }
  
  public String getTypeofEvent() throws Exception {
    String drpValue=  getSelectedTextFromDropDown("id", "typeOfEvent");
    return drpValue;
  }

  public void setDrugNAlcoholEvent() throws Exception {
    clickOnElement("xpath", "(//input[@id='DNA'])[1]");
  }
  
  public boolean getIsDrugNAlcoholEvent() throws Exception {
    String check= getElementAttribute("xpath", "(//input[@id='DNA'])[1]", "checked");
    if (check == null || check == "") {
      return false;
    } else {
      return true;
    }
  }

  public void setNonDrugNAlcoholEvent() throws Exception {
    clickOnElement("xpath", "(//input[@id='DNA'])[2]");
  }
  
  
  public void setFirsAlcohol() throws Exception {
    clickOnElement("id", "firAlco");
  }
  
  public boolean getFirstAlcohol() throws Exception {
    boolean test =isAttributePresent("id", "firAlco", "checked");
    return test;    
  }
  
  public void setFirstDrug() throws Exception {
    clickOnElement("id", "firDrug");
  }
  
  public boolean getFirstDrug() throws Exception {
    boolean test = isAttributePresent("id", "firDrug", "checked");
    return test;
  }
  
  public void setTodaysEventDate() throws Exception {
    clickOnCalender(findElement("css", "div.ricCalendarInputWrapper.ricInlineWrapper"));
    Thread.sleep(1000);
    clickOnElement("css", "td.ricCalendarToday");
    Thread.sleep(2000);
  }
  
  public void setYesterdaysEventDate() throws Exception {
    //clickOnCalender(findElement("css", "div.ricCalendarInputWrapper.ricInlineWrapper"));
    //Thread.sleep(1000);
    enterText("id", "eventDate", getYesterdaysDate());    
  }
  
  public String getEventDate() throws Exception {
    String eDate = getElementAttribute("id", "eventDate", "value");
    return eDate;
  }

  public void setEventTime(String eventTime) throws Exception {
    enterText("id", "eventTime", eventTime);
  }
  
  public String getEventTime() throws Exception {
    String eTime = getElementAttribute("id", "eventTime", "value");
    return eTime;
  }
  
  public void setResultOfEvent(String result) throws Exception {
    selectTextFromDropDown("id", "resultOfEventAll", result);
  }

  public String getResultOfEvent() throws Exception {
    String drpValue=  getSelectedTextFromDropDown("id", "resultOfEventAll");
    return drpValue;
  }
  
  public void setCrewDescriptionOfIncident(String description) throws Exception {
    enterText("id", "CDoI", description);
  }
  
  public String getCrewDescriptionOfIncident() throws Exception {
    String desc = getElementAttribute("id", "CDoI", "value");
    return desc;
  }

  public void setEventDescription(String description) throws Exception{
    selectTextFromDropDown("id", "eventDescription", description);
  }
  
  public String getEventDescription() throws Exception{
    String drpValue =  getSelectedTextFromDropDown("id", "eventDescription");
    return drpValue;
  }
  
  public void setManagerComments(String comment) throws Exception {
    enterText("id", "mgrCmts", comment);
  }

  public String getManagerComments() throws Exception {
    String desc = getElementAttribute("id", "mgrCmts", "value");
    return desc;
  }
  
  public void clickOnNextButton() throws Exception
  {
      clickOnElement("xpath", ".//button[@class='primary']");
  }
  
  public void setTrainSymbol(String data) throws Exception {
    enterText("id", "trainSymbol", data);
  }
  
  public String getTrainTrainSymbol() throws Exception {
    String desc = getElementAttribute("id", "trainSymbol", "value");
    return desc;
  }

  public void setTrainTrainDay(String data) throws Exception {
    enterText("id", "trainDay", data);
    enterText("id", "trainDay", Keys.TAB);
  }
  
  public String getTrainTrainDay() throws Exception {
    String desc = getElementAttribute("id", "trainDay", "value");
    return desc;
  }
  
  public void setTrainLoads(String data) throws Exception {
    enterText("id", "loads", data);
  }
  
  public String getTrainLoads() throws Exception {
    String desc = getElementAttribute("id", "loads", "value");
    return desc;
  }
  
  public void setTrainEmpties(String data) throws Exception {
    enterText("id", "empties", data);
  }
  
  public String getTrainEmpties() throws Exception {
    String desc = getElementAttribute("id", "empties", "value");
    return desc;
  }
  
  public void setTrainTonnage(String data) throws Exception {
    enterText("id", "tonnage", data);
  }
  
  public String getTrainTonnage() throws Exception {
    String desc = getElementAttribute("id", "tonnage", "value");
    return desc;
  }
  
  public void setTrainLength(String data) throws Exception {
    enterText("id", "length", data);
  }
  
  public String getTrainLength() throws Exception {
    String desc = getElementAttribute("id", "length", "value");
    return desc;
  }
  
  public void setTrainMaxAuthSpeed(String data) throws Exception {
    enterText("id", "mas", data);
  }
  
  public String getTrainMaxAuthSpeed() throws Exception {
    String desc = getElementAttribute("id", "mas", "value");
    return desc;
  }
  
  public void setTrainSpeedAtTimeOfIncident(String data) throws Exception {
    enterText("id", "sattoi", data);
  }
  
  public String getTrainSpeedAtTimeOfIncident() throws Exception {
    String desc = getElementAttribute("id", "sattoi", "value");
    return desc;
  }
  
  public void setSubDivision(String data) throws Exception {
    enterText("id", "subDivision",data);
    enterText("id", "subDivision",Keys.TAB);
  }

  public String getSubDivision() throws Exception {
    String desc = getElementAttribute("id", "subDivision", "value");
    return desc;
  }
  
  public void setMilePost(String data) throws Exception {
    enterText("id", "milePost", data);
    enterText("id", "milePost", Keys.TAB);
  }
  
  public String getMilePost() throws Exception {
    String desc = getElementAttribute("id", "milePost", "value");
    return desc;
  }
  
  public void setRegion(String data) throws Exception {
    selectTextFromDropDown("id", "region", data);
  }
  
  public String getRegion() throws Exception
  {
    String text= getSelectedTextFromDropDown("id", "region");
    return text;   
  }
  
  public void setServiceUnit(String data) throws Exception {
    selectTextFromDropDown("id", "serviceUnit", data);
  }
  
  public String getServiceUnit() throws Exception
  {
    String text= getSelectedTextFromDropDown("id", "serviceUnit");
    return text;   
  }
  
  public void setSignalTerritory(String data) throws Exception {
    selectTextFromDropDown("id", "sigTty", data);
  }
  
  public String getSignalTerritory() throws Exception {
    String text= getSelectedTextFromDropDown("id", "sigTty");
    return text;
  }
  
  public void setTypeOfTrack(String data) throws Exception {
    selectTextFromDropDown("id", "trackType", data);
  }
  
  public String getTypeOfTrack() throws Exception {
    String text= getSelectedTextFromDropDown("id", "trackType");
    return text;
  }
  
  public void setTypeOfAuthority(String data) throws Exception {
    selectTextFromDropDown("id", "authType", data);
  }
  
  public String getTypeOfAuthority() throws Exception {
    String text= getSelectedTextFromDropDown("id", "authType");
    return text;
  }
  
  public void setRailroad(String data) throws Exception {
    selectTextFromDropDown("id", "railRoad", data);
  }
  
  public String getRailroad() throws Exception {
    String text= getSelectedTextFromDropDown("id", "railRoad");
    return text;
  }
  
  public void setWithin10MilesOfTerminalTrue() throws Exception {
    clickOnElement("xpath", "(//input[@name='milesradio'])[1]");
    clickOnElement("xpath", "(//input[@name='milesradio'])[1]");
  }

  public void setWithin10MilesOfTerminalFalse() throws Exception {
    clickOnElement("xpath", "(//input[@name='milesradio'])[2]");
    clickOnElement("xpath", "(//input[@name='milesradio'])[2]");
  }
  
  public String getWithin10MilesOfTerminal() throws Exception{
    Boolean check= findElement("xpath", "(//input[@name='milesradio'])[1]").isSelected();

    String status="";
    if (check == null || check.equals(false)) {
      status= "No";
    } else {
      status= "Yes";
    }  
    return status;
  }
  
  public void setInitialTerminal() throws Exception {
    clickOnElement("xpath", "(//input[@name='initialsradio'])[1]");
    clickOnElement("xpath", "(//input[@name='initialsradio'])[1]");
  }
  
  public void setFinalTerminal() throws Exception {
    clickOnElement("xpath", "(//input[@name='initialsradio'])[2]");
    clickOnElement("xpath", "(//input[@name='initialsradio'])[2]");
  }

  public String getInitialOrFinalTerminal() throws Exception{
    Boolean check= findElement("xpath", "(//input[@name='initialsradio'])[1]").isSelected();
    String status="";
    if (check.equals(false)) {
      status= "Final";
    } else {
      status= "Initial";
    }  
    return status;
  }
  
  public void setNearestStation(String data) throws Exception {
    enterText("id", "nearestStation", data);
  }

  public String getNearestStation() throws Exception {
    String text= getElementAttribute("id", "nearestStation", "value");
    return text;
  }
  
  public void setCrewType(String data) throws Exception {
    selectTextFromDropDown("id", "crewType", data);
  }
  
  public String getCrewType() throws Exception {
    String text= getSelectedTextFromDropDown("id", "crewType");
    return text;
  }
  
  public void setOperation(String data) throws Exception {
    selectTextFromDropDown("id", "operation", data);
  }
  
  public String getOperation() throws Exception {
    String text= getSelectedTextFromDropDown("id", "operation");
    return text;
  }
  
  public void setWeather(String data) throws Exception {
    selectTextFromDropDown("id", "weather", data);
  }
  
  public String getWeather() throws Exception {
    String text= getSelectedTextFromDropDown("id", "weather");
    return text;
  }
  
  public void setVisiblity(String data) throws Exception {
    selectTextFromDropDown("id", "visibility", data);
  }
  
  public String getVisiblity() throws Exception {
    String text= getSelectedTextFromDropDown("id", "visibility");
    return text;
  }
  
  public void setGrade(String data) throws Exception {
    selectTextFromDropDown("id", "grade", data);
  }
  
  public String getGrade() throws Exception {
    String text= getSelectedTextFromDropDown("id", "grade");
    return text;
  }
  
  public void setCurvature(String description) throws Exception {
    selectTextFromDropDown("id", "curvature", description);
  }

  public String getCurvature() throws Exception {
    String text= getSelectedTextFromDropDown("id", "curvature");
    return text;
  }
  
  public void setFTXEventTrue() throws Exception {
    clickOnElement("xpath", "(//input[@id='ftxevent'])[1]");
    clickOnElement("xpath", "(//input[@id='ftxevent'])[1]");
  }

  public void setFTXEventFalse() throws Exception {
    clickOnElement("xpath", "(//input[@id='ftxevent'])[2]");
  }

  public boolean getFTXEvent() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='ftxevent'])[1]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }

 public boolean getFTXEventFalse() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='ftxevent'])[2]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }  

  public void setEventRecorderTrue() throws Exception {
    clickOnElement("xpath", "(//input[@id='eventRecorder'])[1]");
  }

  public void setEventRecorderFalse() throws Exception {
    clickOnElement("xpath", "(//input[@id='eventRecorder'])[2]");
  }
  
  public boolean getEventRecorder() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='eventRecorder'])[1]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }
  
   public boolean getEventRecorderFalse() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='eventRecorder'])[2]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }
  
  public void setBlueFlagTrue() throws Exception {
    clickOnElement("xpath", "(//input[@id='blueFlag'])[1]");
  }

  public void setBlueFlagFalse() throws Exception {
    clickOnElement("xpath", "(//input[@id='blueFlag'])[2]");
  }
  
  public boolean getBlueFlag() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='blueFlag'])[1]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }
  
  public boolean getBlueFlagFalse() throws Exception{
    Boolean check= findElement("xpath", "(//input[@id='blueFlag'])[2]").isSelected();
    if (check == null || check.equals(false)) {
      return false;
    } else {
      return true;
    }  
  }
  
  public void clickOnBackButton() throws Exception
  {    
      clickOnElement("xpath", "//button[@ng-if='rcWzCtrl.currentStep > 0']");
  }
  
  public void clickOnSubmitButtonOnCrewListDialog() throws Exception
  {
      clickOnElement("xpath", "//button[@ng-click='crewCtrl.submit()']");
  }
  
  public void clickOnEnterEventButton() throws Exception
  {      
      clickOnElement("xpath", "//button[@ng-click='rcWzCtrl.finish();']");
  }
  
  public void setEmployeeID(String data) throws Exception {
    enterText("id", "employeeId", data);
  }
  
  public void clickOnAddButton() throws Exception{
	     clickOnElement("xpath", "//button[contains(text(), 'Add')]");
    
  }
  
  public String getEmployeeID() throws Exception{
    String desc = getTextFromWebElement("xpath", "//tbody/tr/td[1]/label/u/a");
    return desc;
  }
  public void setPosition(String data) throws Exception{
    selectTextFromDropDown("id", "positions", data);
  }
  
  public String getPosition() throws Exception {
    String text= getSelectedTextFromDropDown("id", "positions");
    return text;
  }
  
  public void setTodaysDateOnDuty() throws Exception{
//    clickOnCalender(el);
//    Thread.sleep(1000);
//    setYesterdaysDate();
//    Thread.sleep(3000);
    enterText("id", "onDutyDate", getTodaysDate());
  }
  
  public void setYesterdaysDateOnDuty() throws Exception{
//    clickOnCalender(el);
//    Thread.sleep(1000);
//    setYesterdaysDate();
//    Thread.sleep(3000);
    enterText("id", "onDutyDate", getYesterdaysDate());
  }
  
  public String getDateOnDuty() throws Exception {
    String text= getElementAttribute("id", "onDutyDate", "value");
    return text;
  }
  
  public void setTimeOnDuty(String data) throws Exception{
    enterText("id", "timeOnDuty", data);
  }
  
  public String getTimeOnDuty() throws Exception {
    String text= getElementAttribute("id", "timeOnDuty", "value");
    return text;
  }
  
  public void setHoursOnDuty(String data) throws Exception{
    enterText("id", "hrsOnDuty", data);
  }
  
  
  public String getHoursOnDuty() throws Exception {
    String text= getElementAttribute("id", "hrsOnDuty", "value");
    return text;
  }
  
  public void setPreviousRest(String data) throws Exception{
    enterText("id", "previosRest", data);
    enterText("id", "previosRest", Keys.TAB);
  }
  
  public String getPreviousRest() throws Exception {
    String text= getElementAttribute("id", "previosRest", "value");
    return text;
  }
  
  public void setDirection(String data) throws Exception{
    selectTextFromDropDown("id", "direction", data);
  }
  
  public String getDirection() throws Exception {
    String text= getSelectedTextFromDropDown("id", "direction");
    return text;
  }
  
  public void setLastJobBriefing(String data) throws Exception{
    selectTextFromDropDown("id", "briefJob", data);
  }
  
  public String getLastJobBriefing() throws Exception {
    String text= getSelectedTextFromDropDown("id", "briefJob");
    return text;
  }
  
  public void setSuspended(String data) throws Exception{
    selectTextFromDropDown("id", "suspension", data);
  }
  
  public String getSuspended() throws Exception {
    String text= getSelectedTextFromDropDown("xpath", ".//*[@ng-model='employee.suspended']");
    return text;
  }
  
  public void setRegulation(String data) throws Exception{
    selectTextFromDropDown("id", "regulation", data);
  }
  
  public String getRegulation() throws Exception {
    String text= getSelectedTextFromDropDown("id", "regulation");
    return text;
  }
  
  public void setPrimaryRuleNumber(String data) throws Exception{
    selectTextFromDropDown("xpath", ".//select[@ng-model='employee.primaryRules']", data);
  }
  
  
  public String getPrimaryRuleNumber() throws Exception {
    String text= getSelectedTextFromDropDown("xpath", ".//select[@ng-model='employee.primaryRules']");
    return text;
  }
  
  public void setOperatingMoreThan6Months(String data) throws Exception{
    selectTextFromDropDown("id", "reqSelect", data);
  }
  
  public String getOperatingMoreThan6Months() throws Exception {
    String text= getSelectedTextFromDropDown("id", "reqSelect");
    return text;
  }
  
  public void setOperatingMoreThan6MonthsForOther(String data) throws Exception{
    selectTextFromDropDown("id", "reqSelect", data);
  }
  
  public String getOperatingMoreThan6MonthsForOther() throws Exception {
    String text= getSelectedTextFromDropDown("id", "reqSelect");
    return text;
  }
 
  public void setMEmployeeID(String data) throws Exception {
    enterText("id", "employeeId", data);
  }
  
  public String getMEmployeeID(String index) throws Exception{
    String desc = getTextFromWebElement("xpath", "//tbody/tr["+index+"]/td[1]/label/u/a");
    return desc;
  }
  public void setMPosition(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='positions'])["+index+"]", data);
  }
  
  public String getMPosition(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='positions'])["+index+"]");
    return text;
  }
  
  public void setMTodaysDateOnDuty(String index) throws Exception{
//    clickOnCalender(el);
//    Thread.sleep(1000);
//    setYesterdaysDate();
//    Thread.sleep(3000);
    enterText("xpath", "(.//*[@id='onDutyDate'])["+index+"]", getTodaysDate());
  }
  
  public String getMDateOnDuty(String index) throws Exception {
    String text= getElementAttribute("xpath", "(.//*[@id='onDutyDate'])["+index+"]", "value");
    return text;
  }
  
  public void setMTimeOnDuty(String index, String data) throws Exception{
    enterText("xpath", "(.//*[@id='timeOnDuty'])["+index+"]", data);
  }
  
  public String getMTimeOnDuty(String index) throws Exception {
    String text= getElementAttribute("xpath", "(.//*[@id='timeOnDuty'])["+index+"]", "value");
    return text;
  }
  
  public void setMHoursOnDuty(String index, String data) throws Exception{
    enterText("xpath", "(.//*[@id='hrsOnDuty'])["+index+"]", data);
  }
  
  
  public String getMHoursOnDuty(String index) throws Exception {
    String text= getElementAttribute("xpath", "(.//*[@id='hrsOnDuty'])["+index+"]", "value");
    return text;
  }
  
  public void setMPreviousRest(String index, String data) throws Exception{
    enterText("xpath", "(.//*[@id='previosRest'])["+index+"]", data);
    enterText("xpath", "(.//*[@id='previosRest'])["+index+"]", Keys.TAB);
  }
  
  public String getMPreviousRest(String index) throws Exception {
    String text= getElementAttribute("xpath", "(.//*[@id='previosRest'])["+index+"]", "value");
    return text;
  }
  
  public void setMDirection(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='direction'])["+index+"]", data);
  }
  
  public String getMDirection(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='direction'])["+index+"]");
    return text;
  }
  
  public void setMLastJobBriefing(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='briefJob'])["+index+"]", data);
  }
  
  public String getMLastJobBriefing(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='briefJob'])["+index+"]");
    return text;
  }
  
  public void setMSuspended(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@ng-model='employee.suspended'])["+index+"]", data);
  }
  
  public String getMSuspended(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@ng-model='employee.suspended'])["+index+"]");
    return text;
  }
  
  public void setMRegulation(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='regulation'])["+index+"]", data);
  }
  
  public String getMRegulation(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='regulation'])["+index+"]");
    return text;
  }
  
  public void setMPrimaryRuleNumber(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//select[@ng-model='employee.primaryRules'])["+index+"]", data);
  }
  
  
  public String getMPrimaryRuleNumber(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//select[@ng-model='employee.primaryRules'])["+index+"]");
    return text;
  }
  
  public void setMOperatingMoreThan6Months(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='reqSelect'])["+index+"]", data);
  }
  
  public String getMOperatingMoreThan6Months(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='reqSelect'])["+index+"]");
    return text;
  }
  
  public void setMOperatingMoreThan6MonthsForOther(String index, String data) throws Exception{
    selectTextFromDropDown("xpath", "(.//*[@id='reqSelect'])["+index+"]", data);
  }
  
  public String getMOperatingMoreThan6MonthsForOther(String index) throws Exception {
    String text= getSelectedTextFromDropDown("xpath", "(.//*[@id='reqSelect'])["+index+"]");
    return text;
  }
//  public void clickOnCreateEventButton() throws Exception
//  {
//    if(!browser.contains("ie"))
//    {
//      clickOnElement("name", "submitButton");
//    }else{
//      clickOnElement("xpath", "//button[contains(text(), 'Enter Event')]");
//    }
//  }
}
