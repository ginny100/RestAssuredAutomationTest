package StepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class LoginDemoSteps_POM 
{
//	WebDriver driver = null;
//	loginPage login;
//	
//	@Given("^the browser is open$")
//    public void the_browser_is_open()
//	{
//		System.out.println("~~~ I am inside the Login page ~~~");
//		System.out.println("Inside step - browser is open");
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Project path is " + projectPath);
//		System.setProperty("webdriver.chrome.driver", "./CucumberJava/src/test/resources/Drivers/chromedriver");
//		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//    }
//	
//	@And("^user is on the login page$")
//	public void user_is_on_the_login_page()
//	{
//		driver.navigate().to("https://example.testproject.io/web/");
//	}
//
//    @When("^user enters (.*) and (.*)$")
//    public void user_enters_username_and_password(String username, String password) throws InterruptedException
//    {
//    	login = new loginPage(driver);
//		login.enterUsername(username);
//		login.enterPassword(password);
//		Thread.sleep(2000);
//    }
//    
//    @And("^user clicks on the login button$")
//    public void user_clicks_on_the_login_button()
//    {
//    	login.clickLogin();
//    }
//
//    @Then("^user is navigated to the home page$")
//    public void user_is_navigated_to_the_home_page() throws InterruptedException
//    {
//    	login.checkLogOutDisplayed();
//    }
}