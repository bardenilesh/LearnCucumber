package Automation.LearnCucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Automation/features"
		,glue="classpath:stepDefinitions",
		plugin = { 
        		"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"}, tags={"A","B"})
		public class Project_Run{}
