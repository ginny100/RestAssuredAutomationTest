import java.io.IOException;
import java.util.ArrayList;

public class testSample 
{
	public static void main(String[] args) throws IOException 
	{
		dataDriven data = new dataDriven();
		ArrayList dataSet = data.getData("Add Profile");
		
		System.out.println(dataSet.get(0));
		System.out.println(dataSet.get(1));
		System.out.println(dataSet.get(2));
		System.out.println(dataSet.get(3));
	}
}
