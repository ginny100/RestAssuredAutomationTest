package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition
{
    @Given("^User is on NetBanking landing page$")
    public void user_is_on_netbanking_landing_page() throws Throwable 
    {
    	// navigate the user to the login url
    	System.out.println("Navigate the user to the login url");
    	//throw new io.cucumber.java.PendingException();
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable 
    {
    	System.out.println("Logged in successfully");
        //throw new PendingException();
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable 
    {
        // home page validation
    	System.out.println("Home page validated");
    	//throw new io.cucumber.java.PendingException();
    }
    
    @When("^User login into application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_something_and_password_something(String username, String password) throws Throwable 
    {
    	System.out.println(username);
    	System.out.println(password);
        //throw new PendingException();
    }

//    @And("^Cards are displayed$")
//    public void cards_are_displayed() throws Throwable 
//    {
//        // validate the cards
//    	System.out.println("Cards validated");
//    	//throw new io.cucumber.java.PendingException();
//    }
    
    @Then("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String beDisplayed) throws Throwable 
    {
    	System.out.println(beDisplayed);
        //throw new PendingException();
    }
}