package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/HooksDemo/HooksDemo.feature", 
                 glue = {"StepsForHooks"},
                 monochrome = true,
                 plugin = {"pretty", "html:target/HTMLReports/report.html",
                		             "json:target/JSONReports/report.json",
                		             "junit:target/JUnitReports/report.xml"})

public class TestRunner_ForHooks 
{
	
}