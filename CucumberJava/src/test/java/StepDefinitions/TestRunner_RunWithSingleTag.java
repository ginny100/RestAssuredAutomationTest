package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/FeatureWithTags", 
                 glue = {"StepDefinitions"},
                 tags = "@mustRun")
/*
 * Other ways to right test using tags
 * @smoke              : Scenarios tagged with @smoke
 * @smoke and @fast    : Scenarios tagged with both @smoke and @fast
 * @gui or @database   : Scenarios tagged with either @gui or @database
 * @fast and not @slow : Scenarios tagged with @fast that aren't also tagged with @slow */

public class TestRunner_RunWithSingleTag 
{

}