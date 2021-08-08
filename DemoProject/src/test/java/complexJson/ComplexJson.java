package complexJson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import complexJson.Courses.WebAutomation;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import complexJson.Courses.ApiAutomation;
import complexJson.Courses.MobileAutomation;
import static io.restassured.RestAssured.*;


public class ComplexJson 
{
	public static void main(String[] args) throws IOException
	{
		// Web Automation
		List<WebAutomation> webs = new ArrayList<WebAutomation>();
		
		Courses.WebAutomation sel = new Courses.WebAutomation();
		sel.setCourseTitle("Selenium");
		sel.setPrice(4000);
		
		Courses.WebAutomation pro = new Courses.WebAutomation();
		pro.setCourseTitle("Protractor");
		pro.setPrice(5000);
		
		webs.add(sel);
		webs.add(pro);
		
		// API Automation
		List<ApiAutomation> apis = new ArrayList<ApiAutomation>();
		
		Courses.ApiAutomation rest = new Courses.ApiAutomation();
		rest.setCourseTitle("RestAssure");
		rest.setPrice(5000);
		
		Courses.ApiAutomation soap = new Courses.ApiAutomation();
		soap.setCourseTitle("SOAP API Automation");
		soap.setPrice(3000);
		
		apis.add(rest);
		apis.add(soap);
		
		// Mobile Automation
		List<MobileAutomation> mobile = new ArrayList<MobileAutomation>();
		
		Courses.MobileAutomation app = new Courses.MobileAutomation();
		app.setCourseTitle("Appium");
		app.setPrice(5000);
		
		mobile.add(app);
		
		// All course objects
		Courses courses = new Courses();
		courses.setWebAutomation(webs);
		courses.setApiAutomation(apis);
		courses.setMobileAutomation(mobile);
		
		// POJO object
		serviceDetailsPojo sp = new serviceDetailsPojo();
		sp.setInstructor("Subhasish");
		sp.setUrl("softwaretestingandautomation.com");
		sp.setServices("Software Testing");
		sp.setExpertise("Testing");
		sp.setCourses(courses);
		sp.setLinkedIn("linkedinId");
		
		// Convert a Java object to a Json object
		ObjectMapper objectMapper = new ObjectMapper();
		String convertedJson = objectMapper.writeValueAsString(sp);
		System.out.println("The converted Json object is " + convertedJson);
		
		// Generate a Json file
		String userDir = System.getProperty("user.dir");
		File outputJsonFile = new File(userDir + "/src/test/resources/PayLoad.json");
		objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, sp);
		
		// (REST Assured) POST response
		Response postResponse = given().
									auth().none().
									header("Content-Type", "application/json").
									contentType(ContentType.JSON).
								when().
									body(sp).log().all().
									post("https://reqres.in/api/users");
		System.out.println("Post Response is " + postResponse.asString());
		
		// Convert a Json object to a Java object
		String response = postResponse.asString();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		serviceDetailsPojo sdp = objectMapper.readValue(response, serviceDetailsPojo.class);
		String instructor = sdp.getInstructor();
		String mobileAutoCourseTitle = sdp.getCourses().getMobileAutomation().get(0).getCourseTitle();
		System.out.println("Instructor name is " + instructor);
		System.out.println("Mobile automation course title is " + mobileAutoCourseTitle);
	}
}