package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps
{
//	WebDriver driver = null;
//	
//	@Given("the browser is open")
//    public void the_browser_is_open() 
//	{
//		System.out.println("Starting - browser is open");
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Project path is " + projectPath);
//        System.setProperty("webdriver.chrome.driver", "./CucumberJava/src/test/resources/Drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//        //driver.manage().window().maximize();
//        System.out.println("Ending - browser is closed");
//    }
//	
//	@And("user is on the Google search page")
//    public void user_is_on_the_google_search_page()
//    {
//		driver.navigate().to("https://google.com");
//    }
//
//    @When("user enters a text in the Google search box")
//    public void user_enters_a_text_in_the_google_search_box()
//    {
//        driver.findElement(By.name("q")).sendKeys("Ginny");
//    }
//    
//    @And("user hits Enter")
//    public void user_hits_enter()
//    {
//    	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//    }
//
//    @Then("user is navigated to the Search Result page")
//    public void user_is_navigated_to_the_search_result_page()
//    {
//        driver.getPageSource().contains("Ginny's | Cookware, Bedding & Bath on Credit");
//        driver.close();
//        driver.quit();
//    }
}
