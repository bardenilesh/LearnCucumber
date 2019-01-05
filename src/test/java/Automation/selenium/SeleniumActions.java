package Automation.selenium;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Automation.util.ExcelUtility;
import Automation.util.Global;

public class SeleniumActions {
	ExcelUtility oExcel = new ExcelUtility();
	static WebDriver webDriver;
	private Actions action;

	public WebDriver openBrowser(String url, String data) {
		try {
			System.setProperty(
					"webdriver.ie.driver",
					"C:\\Users\\xsat802\\Nilesh_Workspace\\EQM_AUTOMATION\\drivers\\IEDriverServer.exe");
			Global.dataFile = data;
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			webDriver = new InternetExplorerDriver(capabilities);
			webDriver.manage().window().maximize();
			webDriver.get(url);
			timeOut(30);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return webDriver;
	}

	public void closeBrowser() {
		webDriver.close();
	}
	
	 public static int getTodaysDay()
	  {   Calendar cal = Calendar.getInstance();
	      int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
	      return dayOfMonth;
	  }
	  
	  public static int getTodaysMonth()
	  {   Calendar cal = Calendar.getInstance();
	      int dayOfMonth = (cal.get(Calendar.MONTH)+1);
	      return dayOfMonth;
	  }
	  
	  public static int getTodaysYear()
	  {   Calendar cal = Calendar.getInstance();
	      int dayOfMonth = cal.get(Calendar.YEAR);
	      return dayOfMonth;
	  }
	public String getTodaysDate() throws Exception {
	    String day, month, year;
	      day=Integer.toString(getTodaysDay());
	      month=Integer.toString(getTodaysMonth());
	      year=Integer.toString(getTodaysYear());
	     String finalDate = month+"/"+day+"/"+year;
	    return dateFormatter(finalDate);
	  }
	
	  public String dateFormatter(String date)
	  {
	    String dutyDate=date;
	    String[] splDutyDate = dutyDate.split("/");
	    for(int i=0;i<(splDutyDate.length-1);i++)
	    {
//	      System.out.println(splDutyDate[i].length());
	      if(splDutyDate[i].length()==1)
	      {
//	        System.out.println("value ="+splDutyDate[i]);
	        splDutyDate[i]="0"+splDutyDate[i];
//	        System.out.println("value ="+splDutyDate[i]);
	      }
//	      System.out.println(splDutyDate[i]);
	    }
	    if (splDutyDate[2].length() == 2) {
//	      System.out.println("Year = "+splDutyDate[2]);
	      splDutyDate[2]="20"+splDutyDate[2];
//	      System.out.println("Year = "+splDutyDate[2]);
	    }
	    System.out.println(splDutyDate[1]+"/"+splDutyDate[0]+"/"+splDutyDate[2]);
	    return splDutyDate[0]+"/"+splDutyDate[1]+"/"+splDutyDate[2];
	  }

	public void login(String username, String Password) throws Exception {
		enterText("id", "USER", username);
		enterText("id", "PASSWORD", Password);
		clickOnElement("id", "login-button");
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait(1000);
	}

	public void timeOut(long val) {
		webDriver.manage().timeouts().implicitlyWait(val, TimeUnit.SECONDS);
	}

	public List<String> getDropDownOptions(WebElement el) {
		List<WebElement> opt = new ArrayList<WebElement>();
		opt = new Select(el).getOptions();
		List<String> optionText = new ArrayList<String>();
		for (int i = 0; i < opt.size(); i++) {
			optionText.add(opt.get(i).getText());
		}
		return optionText;
	}

	public void pleaseWait() {
		try {
			Thread.sleep(100);
			for (int x = 0; x < 100; x++) {
				if (isElementPresent(By.id("ricolaPleaseWait"))) {
					if (!webDriver.findElement(By.id("ricolaPleaseWait"))
							.isDisplayed()) {
						break;
					} else {
						Thread.sleep(100);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pleaseWaitTillLoadingIsDone() {
		try {
			Thread.sleep(200);
			WebDriverWait wait = new WebDriverWait(webDriver, 200);
			if (isElementPresent(By.className("rc-loading-animation"))) {
				wait.until(ExpectedConditions.stalenessOf(webDriver
						.findElement(By.className("rc-loading-animation"))));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// WebDriverWait wait = new WebDriverWait(webDriver, 100);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("rc-loading-animation")));
		// System.out.print("Text box text4 is now invisible");
	}

	public void pleaseWaitTillLoadingIsDone1() {
		try {
			Thread.sleep(100);
			for (int x = 0; x < 200; x++) {
				if (isElementPresent(By.className("rc-loading-animation"))) {
					if (!webDriver.findElement(
							By.className("rc-loading-animation")).isDisplayed()) {
						break;
					} else {
						Thread.sleep(100);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// WebDriverWait wait = new WebDriverWait(webDriver, 100);
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("rc-loading-animation")));
		// System.out.print("Text box text4 is now invisible");
	}

	public WebElement findElement(String locatorType, String value)
			throws NoSuchElementException, IOException {
		WebElement field = null;
		try {
			// webDriver.manage().timeouts().implicitlyWait(10,
			// TimeUnit.SECONDS);
			field = webDriver.findElement(locatorValue(locatorType, value));
			// takeScreenShot();
		} catch (NoSuchElementException ex) {
		}
		return field;
	}

	public List<WebElement> findElements(String locatorType, String value)
			throws NoSuchElementException {
		List<WebElement> allData = null;
		try {
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			allData = webDriver.findElements(locatorValue(locatorType, value));
		} catch (NoSuchElementException ex) {
		}
		return allData;
	}

	public void enterText(String locatorType, String value, String text) {
		try {
			WebElement element = findElement(locatorType, value);
			element.clear();
			wait(100);
			element.sendKeys(text);
			wait(100);
			element = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void wait(int timeInMiliSeconds) {
		try {
			Thread.sleep(timeInMiliSeconds);
		} catch (InterruptedException e) {
		}
	}

	public void enterText(String locatorType, String value, Keys text) {

		try {
			WebElement element = findElement(locatorType, value);
			wait(100);
			element.sendKeys(text);
			wait(100);
			element = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnElement(String locatorType, String value)
			throws Exception {
		try {

			WebElement element = findElement(locatorType, value);
			element.click();
			wait(1000);
		} catch (NoSuchElementException e) {

		}
	}

	public String getTextFromWebElement(String locatorType, String value)
			throws Exception {
		WebElement element = null;
		String gettext = null;
		try {
			element = findElement(locatorType, value);

			gettext = element.getText();

		} catch (NoSuchElementException e) {
		}
		return gettext;
	}

	public void fluentWaitElementToBeVisible(By locator) {
		new WebDriverWait(webDriver, 30).until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}

	public void fluentWaitElementToBeInvisible(By locator) {
		new WebDriverWait(webDriver, 30).until(ExpectedConditions
				.invisibilityOfElementLocated(locator));
	}

	public void fluentWaitElementToBeClickable(By locator) {
		new WebDriverWait(webDriver, 30).until(ExpectedConditions
				.elementToBeClickable(locator));
	}

	public void waitUntilElementBecomesClickble(String locatorType,
			String value, Integer seconds) {

		By locator;
		try {
			locator = locatorValue(locatorType, value);
			WebDriverWait wait = new WebDriverWait(webDriver, seconds);
			wait.until(ExpectedConditions.not(ExpectedConditions
					.visibilityOf(webDriver.findElement(locator))));
		} catch (NoSuchElementException ex) {
		}

	}

	public void WaitforElement(String locatorType, String value) {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			fluentWaitElementToBeVisible(locator);

		} catch (NoSuchElementException ex) {
		}
	}

	public void WaitforElementToBeInvisible(String locatorType, String value) {

		try {
			By locator;
			locator = locatorValue(locatorType, value);
			fluentWaitElementToBeInvisible(locator);

		} catch (NoSuchElementException ex) {
		}
	}

	public String getElementAttribute(String locatorType, String value,
			String name) {
		String attribute = null;
		try {

			attribute = findElement(locatorType, value).getAttribute(name);

		} catch (Exception ex) {

		}
		return attribute;
	}

	public boolean isAttributePresent(String locatorType, String value,
			String attributeName) {
		String attribute = null;
		try {

			attribute = findElement(locatorType, value).getAttribute(
					attributeName);

		} catch (Exception ex) {

		}
		if (attribute != null) {
			return true;
		} else {
			return false;
		}
	}

	public void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
	}

	public By locatorValue(String locatorType, String value) {
		  int caseNum = 0;
		  if(locatorType.toLowerCase().equals("id"))
		  {
			  caseNum=1;
		  }else if(locatorType.toLowerCase().equals("name"))
		  {
			  caseNum=2;
		  }else if(locatorType.toLowerCase().equals("xpath"))
		  {
			  caseNum=3;
		  }else if(locatorType.toLowerCase().equals("css"))
		  {
			  caseNum=4;
		  }else if(locatorType.toLowerCase().equals("link"))
		  {
			  caseNum=5;
		  }else if(locatorType.toLowerCase().equals("partiallink"))
		  {
			  caseNum=6;
		  }else if(locatorType.toLowerCase().equals("class"))
		  {
			  caseNum=7;
		  }else if(locatorType.toLowerCase().equals("tagName"))
		  {
			  caseNum=8;
		  }
		  
	    By by;
	    switch (caseNum) {
	      case 1:
	        by = By.id(value);
	        break;
	      case 2:
	        by = By.name(value);
	        break;
	      case 3:
	        by = By.xpath(value);
	        break;
	      case 4:
	        by = By.cssSelector(value);
	        break;
	      case 5:
	        by = By.linkText(value);
	        break;
	      case 6:
	        by = By.partialLinkText(value);
	        break;
	      case 7:
	      by= By.className(value);
	      break;
	      case 8:
	          by= By.tagName(value);
	          break;
	      default:
	        by = null;
	        break;
	    }
	    return by;
	  }

	public boolean isElementPresent(By by) {
		try {
			webDriver.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			webDriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String readField(WebElement el) {
		List<WebElement> options = el.findElements(By.tagName("option"));
		for (WebElement option : options) {
			if (option.isSelected()) {
				return option.getText();
			}
		}
		return null;
	}

	public void selectTextFromDropDown(String locatorType, String value,
			String text) throws Exception {
		try {
			WebElement element = findElement(locatorType, value);
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
			wait(1000);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
		}
	}

	public String getSelectedTextFromDropDown(String locatorType, String value)
			throws Exception {
		try {
			WebElement element = findElement(locatorType, value);
			Select sel = new Select(element);
			String text = sel.getFirstSelectedOption().getText();
			wait(1000);
			return text;
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			return "";
		}
	}

	public String currentSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	public String currentSystemDatePlus(int days) {
		String currentDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // dd/MM/yyyy
			Date date = new Date();
			currentDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(currentDate));
			c.add(Calendar.DATE, days); // number of days to add
			currentDate = dateFormat.format(c.getTime());
			return currentDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	public String currentSystemDateMinus(int days) {
		String currentDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // dd/MM/yyyy
			Date date = new Date();
			currentDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(currentDate));
			c.add(Calendar.DATE, -days); // number of days to add
			currentDate = dateFormat.format(c.getTime());
			return currentDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	public String getYesterdaysDate() throws Exception {
		String yestDate = null;
		try {
			yestDate = currentSystemDateMinus(1);
			return yestDate;
		} catch (Exception e) {
			e.printStackTrace();
			return yestDate;
		}
	}

	public String currentSystemTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	public String currentSystemTimePlus(int mins) {
		String currentDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm"); // dd/MM/yyyy
			Date date = new Date();
			currentDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(currentDate));
			c.add(Calendar.MINUTE, mins); // number of days to add
			currentDate = dateFormat.format(c.getTime());
			return currentDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	public String currentSystemTimeMinus(int mins) {
		String currentDate = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm"); // dd/MM/yyyy
			Date date = new Date();
			currentDate = dateFormat.format(date);
			Calendar c = Calendar.getInstance();
			c.setTime(dateFormat.parse(currentDate));
			c.add(Calendar.MINUTE, -mins); // number of days to add
			currentDate = dateFormat.format(c.getTime());
			return currentDate;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate;
	}

	public boolean checkMatchAttr(By by, String compareWith, String fieldName) {
		boolean isCorrect = false;
		if (webDriver.findElement(by).getAttribute("value").trim()
				.equalsIgnoreCase(compareWith.trim())) {
			System.out.println(fieldName + " is correctly shown");
			isCorrect = true;
		} else {
			System.out.println(fieldName + " is not shown correctly");
			isCorrect = false;
		}
		System.out.println(fieldName + " "
				+ webDriver.findElement(by).getAttribute("value"));
		return isCorrect;
	}

	public boolean checkPartialMatchAttr(By by, String compareWith,
			String fieldName) {
		boolean isCorrect = false;
		if (compareWith
				.trim()
				.toLowerCase()
				.contains(
						webDriver.findElement(by).getAttribute("value").trim()
								.toLowerCase())) {
			System.out.println(fieldName + " is correctly shown");
			isCorrect = true;
		} else {
			System.out.println(fieldName + " is not shown correctly");
			isCorrect = false;
		}
		System.out.println(fieldName + " "
				+ webDriver.findElement(by).getAttribute("value"));
		return isCorrect;
	}

	public boolean checkMatchText(By by, String compareWith, String fieldName) {
		boolean isCorrect = false;
		if (webDriver.findElement(by).getText().trim()
				.equalsIgnoreCase(compareWith.trim())) {
			System.out.println(fieldName + " is correctly shown");
			isCorrect = true;
		} else {
			System.out.println(fieldName + " is not shown correctly");
			isCorrect = false;
		}
		System.out.println(fieldName + " "
				+ webDriver.findElement(by).getText());
		return isCorrect;
	}

	public boolean checkPartialMatchText(By by, String compareWith,
			String fieldName) {
		boolean isCorrect = false;
		if (compareWith
				.trim()
				.toLowerCase()
				.contains(
						webDriver.findElement(by).getText().trim()
								.toLowerCase())) {
			System.out.println(fieldName + " is correctly shown");
			isCorrect = true;
		} else {
			isCorrect = false;
		}
		System.out.println(fieldName + " "
				+ webDriver.findElement(by).getText());
		return isCorrect;
	}

	public boolean isEqual(String string1, String string2, String fieldName) {
		boolean isCorrect = false;
		if (string1.trim().toLowerCase().equals(string2.trim().toLowerCase())) {
			System.out.println(fieldName + " is correctly shown");
			isCorrect = true;
		} else {
			System.out.println(fieldName + " is not shown correctly");
			isCorrect = false;
		}
		return isCorrect;
	}
	  public void clickOnCalender(WebElement cal)
	  {
	    try {
	      action= new Actions(webDriver);
	      int x_location = cal.getLocation().getX();
	      int width = cal.getSize().getWidth();
	      System.out.println("Width " + width);
	      System.out.println("clicked x at " + x_location+(width-2));
	      action.moveToElement(cal, width - 2, 0).click().perform();
	      Thread.sleep(1000);
	    } catch (InterruptedException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
}