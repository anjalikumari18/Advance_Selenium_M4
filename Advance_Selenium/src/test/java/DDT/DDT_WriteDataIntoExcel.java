package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Step 1: Create object of FIS
		
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");

		//Step 2: Open the workbook in Read mode
		
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: Get control of the sheet
		
		Sheet sh = wb.getSheet("Sheet1");
		
		//Step 4: Get row control
		
		Row row = sh.getRow(1);
		
		//Step 5: We call createCell(), instead of getCell()
		
		Cell cell = row.createCell(2);
		
		//Step 6: Specify cell data and cell type
		
		cell.setCellType(CellType.STRING);
		cell.setCellValue("PASS");
		
		
		//Step 7: Open workbook in write mode
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\CampaignDetails.xlsx");
		
		//Step 8: Save the data in Excel
		
		wb.write(fos);
		
		//Step 9: Close the workbook
		
		wb.close();
		
		System.out.println("Code executed");
	}

}
