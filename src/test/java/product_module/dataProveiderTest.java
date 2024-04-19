package product_module;



import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.basic.BasicArrowButton;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.CAH.generic_Utility.IPathConstant;

public class dataProveiderTest {

	
	@DataProvider
	public Object[][] OrganisationInfo() {
		Object[][] obj = new Object[3][4];
	   obj[0][0]="Qspider";
	   obj[0][1]="Banglore";
	   obj[0][2]="Manual";
	   obj[0][3]=45000;
	   
	   obj[1][0]="Jspider";
	   obj[1][1]="Btm";
	   obj[1][2]="java";
	   obj[1][3]=55000;
	   
	   obj[2][0]="testYantra";
	   obj[2][1]="kattrigupe";
	   obj[2][2]="job";
	   obj[2][3]=0;
	   
	   return  obj;
	}
	
	@Test(dataProvider = "vTigerLoginCred")
	public void getData(String org,String loc, String course, int cost) {
		System.out.println("organisation:  "+org+" location: "+loc+" course: "+ course+" cost: "+cost);
	}
	
	@DataProvider(name = "vtigerlog")
	public Object[][] vTiger() {
		Object[][] obj = new Object[2][2];
	   obj[0][0]="admin";
	   obj[0][1]="adminn";	   
	   
	   obj[1][0]="admin";
	   obj[1][1]="admin";
  
	   return  obj;
	}
	
	@DataProvider(name="readDataFromExcel1")
	public Object[][] takingDataFromExcel1() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("CampaignInfo");
		 int rowCount = sh.getLastRowNum();
		 int cellCount = sh.getRow(0).getLastCellNum();
		 
		 Object[][] object = new Object[rowCount+1][cellCount];
		 for (int i = 0; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				object[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		 return object;
	}
	
	@DataProvider(name="readDataFromExcel2")
	public Object[][] takingDataFromExcel2() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("CampaignInfo");
		 int rowCount = sh.getLastRowNum()+1;
		 int cellCount = sh.getRow(0).getLastCellNum();
		 
		 Object[][] object = new Object[rowCount][cellCount];
		 for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				object[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		 return object;
	}
	
	@DataProvider(name="takingDataFromExcelbyphsical")
	public Object[][] takingDataFromExcelbyphsical1() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(IPathConstant.ExcelPath);
		 Workbook wb = WorkbookFactory.create(fis);
		 Sheet sh = wb.getSheet("CampaignInfo");
		 int rowCount = sh.getPhysicalNumberOfRows();
		 int cellCount = sh.getRow(0).getPhysicalNumberOfCells();
		 
		 Object[][] object = new Object[rowCount][cellCount];
		 for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				object[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		 return object;
		
	}
	

}

