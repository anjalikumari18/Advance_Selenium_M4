package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		//Step 1: Get java representation object of the physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\DeviceList.xlsx");
		
		//Step 2: Open the workbook in Read mode
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the required sheet
		
		Sheet sh = wb.getSheet("Sheet1");
		
		//Step 4: Get the row control
		
		Row r = sh.getRow(1);
		
		//Step 5: Get access to cell
		
		Cell c = r.getCell(0);
		
		//Step 6: Read the string value
		String cell1 = c.getStringCellValue();
		System.out.println(cell1);
		
		//Step 7: Close the workbook
		wb.close();
		
		
	}

}
