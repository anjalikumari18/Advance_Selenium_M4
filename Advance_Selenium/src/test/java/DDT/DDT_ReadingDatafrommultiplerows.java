package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_ReadingDatafrommultiplerows {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		        //Step 1: Get java representation object of the physical file
				FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\Desktop\\DDT Files\\DeviceList.xlsx");
				
				//Step 2: Open the workbook in Read mode
				
				Workbook wb = WorkbookFactory.create(fis);
				
				//Step 3: Get control of the required sheet
				
				Sheet sh = wb.getSheet("Sheet1");
				
				int rowCount = sh.getLastRowNum();
				
				for(int i=0;i<=rowCount;i++) {
					Row row = sh.getRow(i);
					
					String columnData1 = row.getCell(0).toString();
					String columnData2 = row.getCell(1).toString();
					System.out.println(columnData1+"\t"+columnData2);
				}
				
		
	}

}
