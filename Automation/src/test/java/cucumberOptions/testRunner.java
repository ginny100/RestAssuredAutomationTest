package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// Feature
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", //package feature
                 glue = "stepDefinitions") // package name

public class testRunner 
{
	
}