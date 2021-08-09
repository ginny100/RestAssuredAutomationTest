import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven
{
	// Identify Testcases column by scanning the entire list 1st row
	// Once the column is identified, scan the entire testCases column to identify the purchase testCases row
	// After grabbing the purchase testCases row, pull all the data of that row and feed it into test
	
	public ArrayList<String> getData(String testcaseName) throws IOException 
	{
		/* Identify Testcases column by scanning the entire list 1st row
		 * Once the column is identified, scan the entire testCases column to identify the purchase testCases row
		 * After grabbing the purchase testCases row, pull all the data of that row and feed it into test */
		
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("/Users/khuedangmai/Desktop/Eclipse.app/Contents/MacOS/RestAssuredAutomation/ExcelDrive/demoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++)
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testData"))
			{
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases column by scanning the entire list 1st row
				Iterator<Row> rows = sheet.iterator(); // sheet is a collections of rows
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator(); // row is a collections of cells
				int k = 0;
				int column = 0;
				
				while (cells.hasNext())
				{
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("testCases"))
					{
						// the desired column
						column = k;
					}
					k++;
				}
				System.out.println(column);
				
				// Scan the entire testCases column to identify the purchase testCases row
				while (rows.hasNext())
				{
					Row nextRow = rows.next();
					if (nextRow.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
					{
						// pull all the data of that row and feed it into test
						Iterator<Cell> cellValues = nextRow.cellIterator();
						while (cellValues.hasNext())
						{
							Cell cell = cellValues.next();
							if (cell.getCellType() == CellType.STRING)
							{
								a.add(cell.getStringCellValue());
							}
							else
							{
								a.add(NumberToTextConverter.toText(cell.getNumericCellValue()));
							}
						}
					}
				}
			}
		}	
		return a;
	}
	
	public static void main(String[] args)
	{
		
	}
}
