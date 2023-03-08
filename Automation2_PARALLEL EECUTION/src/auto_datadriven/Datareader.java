package auto_datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Datareader {
	
	@DataProvider(name="excel")
	public Object[][] Dataread() throws InvalidFormatException, IOException {
		FileInputStream f = new FileInputStream("./Datasheet/Login_crm.xlsx");
	//	FileReader fr = new FileReader(f);
	    XSSFWorkbook wk = new XSSFWorkbook(f);
	    XSSFSheet sh = wk.getSheet("Login");
	    int numofrows = sh.getPhysicalNumberOfRows();
	    System.out.println(numofrows);
	    Object [][] testdata = new Object[numofrows-1][6];
	    for (int i=1;i<numofrows;i++) {
	    	XSSFRow xr = sh.getRow(i);
	    	XSSFCell user = xr.getCell(0);
	    	XSSFCell pass = xr.getCell(1);
	    	XSSFCell phone = xr.getCell(2);
	    	XSSFCell company = xr.getCell(3);
	    	XSSFCell lastname = xr.getCell(4);
	    	XSSFCell emailid = xr.getCell(5);
	    	testdata [i-1][0] = user.getStringCellValue();
	    	testdata [i-1][1] = pass.getStringCellValue();
	    	
	    	testdata [i-1][2] = phone.getStringCellValue();
	    	testdata [i-1][3] = company.getStringCellValue();
	    	testdata [i-1][4] = lastname.getStringCellValue();
	    	testdata [i-1][5] = emailid.getStringCellValue();
	    }
	   
	    return testdata;
	}
	
	
    
}
