package StepsForHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HooksDemoSteps 
{
	WebDriver driver = null;
	
	@Before(value = "@smoke", order = 1)
	public void browserSetup()
	{
		System.out.println("~~~ I am inside browserSetup ~~~");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Before(order = 2)
	public void browserSetup2()
	{
		System.out.println("~~~ I am inside browserSetup2 ~~~");
	}
	
	@After(order = 1)
	public void tearDown()
	{
		System.out.println("~~~ I am inside tearDown ~~~");
		driver.close();
		driver.quit();
	}
	
	@After(order = 0)
	public void tearDown2()
	{
		System.out.println("~~~ I am inside tearDown2 ~~~");
	}
	
	@BeforeStep
	public void beforeSteps()
	{
		System.out.println("~~~ I am inside beforeSteps ~~~");
	}
	
	@AfterStep
	public void afterSteps()
	{
		System.out.println("~~~ I am inside afterSteps ~~~");
	}
	
	@Given("^user is on the login page$")
    public void user_is_on_the_login_page() 
	{
        
    }

    @When("^user enters valid username and password$")
    public void user_enters_valid_username_and_password() 
    {
        
    }

    @Then("^user is navigated to the home page$")
    public void user_is_navigated_to_the_home_page()
    {
        
    }

    @And("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() 
    {
        
    }
}
