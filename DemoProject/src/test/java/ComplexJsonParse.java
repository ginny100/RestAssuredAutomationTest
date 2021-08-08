import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse 
{
	public static void main(String[] args) 
	{
		JsonPath js = new JsonPath(payload.CoursePrice());
		
		// Print # of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		// Print purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		// Print title of the 1st course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		System.out.println();
		
		// Print all course titles
		for (int i = 0; i < count; i++)
		{
			System.out.println(js.get("courses[" + i + "].title").toString());
			System.out.println(js.get("courses[" + i + "].price").toString());
		}
		System.out.println();
		
		// Print # of copies sold by RPA Course
		System.out.println("Number of copies sold by RPA course:");
		for (int i = 0; i < count; i++)
		{
			String courseTitles = js.get("courses[" + i + "].title");
			if (courseTitles.equalsIgnoreCase("RPA"))
			{
				// copies sold
				int copies = js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
			}
		}
	}
}