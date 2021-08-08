package oauth;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PayPalOAuthTest 
{
	static String access_token;
	static String clientId = "..."; // Insert your clientId here
	static String secret = "......"; // Insert your secret here
	
	@Test(priority = 1)
	public void getAccessToken()
	{
		Response response = given().
								auth().preemptive().
								basic(clientId, secret).
								param("grant_type", "client_credentials").
								log().all().
								post("..."); // v1 oauth token
		
		response.prettyPrint();
		System.out.println("Status code is " + response.statusCode());
		access_token = response.getBody().path("access_token");
		System.out.println("Access token is " + access_token);
	}

	@Test(priority = 2, dependsOnMethods = "getAccessToken")
	public void createPayPalOrder()
	{
		String payload = "{\n"
				+ "  \"intent\": \"CAPTURE\",\n"
				+ "  \"purchase_units\": \n"
				+ "  [\n"
				+ "    {\n"
				+ "      \"amount\": \n"
				+ "      {\n"
				+ "        \"currency_code\": \"USD\",\n"
				+ "        \"value\": \"100.00\"\n"
				+ "      }\n"
				+ "    }\n"
				+ "  ]\n"
				+ "}";
		Response response = given().
								contentType(ContentType.JSON).
								auth().oauth2(access_token).
								body(payload).
								log().all().
								post("..."); // v2 check out orders
		response.prettyPrint();
		System.out.println("Status code is " + response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(response.getBody().path("status"), "CREATED");
	}
}