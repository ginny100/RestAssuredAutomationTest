import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class excelDriven 
{
	@Test
	public void addBook() throws IOException
	{
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("RestAddBook", "testData");
		
		HashMap<String, Object> jsonAsMap = new HashMap<String, Object>();
		jsonAsMap.put("name", data.get(1));
		jsonAsMap.put("isbn", data.get(2));
		jsonAsMap.put("aisle", data.get(3));
		jsonAsMap.put("author", data.get(4));
		
		/* Nested hash map
		 * HashMap<String, Object> jsonAsMap2 = new HashMap<String, Object>();
		 * jsonAsMap.put("lat", "11");
		 * jsonAsMap.put("lng", "21");
		 * jsonAsMap.put("location", jsonAsMap2); */
				
		RestAssured.baseURI = "http://216.10.245.166";
		Response resp = given().
							header("Content-Type", "application/json").
							body(jsonAsMap).
						when().
							post("/Library/Addbook.php").
						then().
							log().all().assertThat().statusCode(200).extract().response();
		
		JsonPath js = ReUsableMethods.rawToJson(resp);
		String id = js.get("ID");
		System.out.println(id);			
	}
}