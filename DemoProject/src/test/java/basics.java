import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import files.ReUsableMethods;
import files.payload;

public class basics 
{
	public static void main(String[] args) throws IOException 
	{
		// Validate if Add Place API is working as expected
		// given - all input details
		// when - submit the API - response, http method
		// then - validate the response
		// Convert content of the file to String -> content of file can convert into Byte -> Byte data to String
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		String response = given().log().all().queryParam("key", "qaclick123").
							header("Content-Type", "application/json").
							body(new String(Files.readAllBytes(Paths.get("./DemoProject/addPlace.json")))).
						when().post("maps/api/place/add/json").
						then().assertThat().statusCode(200).
							body("scope", equalTo("APP")).
							header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		
		JsonPath js = new JsonPath(response); // for parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		// Update new place
		String newAddress = "Summer Walk, Africa";
		
		given().log().all().queryParam("key", "qaclick123").
			header("Content-Type", "application/json").
			body("{\n"
					+ "\"place_id\":\"" + placeId + "\", \n"
					+ "\"address\":\"" + newAddress + "\",\n"
					+ "\"key\":\"qaclick123\"\n"
					+ "}").
		when().put("maps/api/place/update/json").
			then().assertThat().log().all().statusCode(200).
			body("msg", equalTo("Address successfully updated"));
		
		// Get place
		String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).
								when().get("maps/api/place/get/json").
								then().assertThat().log().all().statusCode(200).extract().response().asString();
		JsonPath js1 = ReUsableMethods.rawToJson(getPlaceResponse);
		String actualAddress = js1.getString("address");
		System.out.println(actualAddress);
		Assert.assertEquals(actualAddress, newAddress);
		
		// Cucumber JUnit, TestNG
	}
}