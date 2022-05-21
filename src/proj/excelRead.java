package proj;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelRead {

	public static void main(String[] args) throws IOException, InterruptedException {
		/*System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// TODO Auto-generated method stub
		
		
		// Get Parent Window Handle before navigating to download
        String parentWindow = driver.getWindowHandle();
        
		// navigate to chrome downloads
        driver.get("chrome://downloads");
        Set<String> allWinowHandles= driver.getWindowHandles();
        // Switch to new Window Handle
         for(String winHandle: allWinowHandles){
             //Switch to second window
             if(!winHandle.equals(parentWindow)){
                 driver.switchTo().window(winHandle);
             }
// Use JavaScript Executor to get information about Downloaded File
        JavascriptExecutor downloadWindowExecutor = (JavascriptExecutor)driver;
        // Wait for Download till 100% completion
        double percentageProgress = (double) 0;
        while (percentageProgress != 100) {
            percentageProgress = (Long) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
            System.out.println("Completed Percentage" + percentageProgress);
           Thread.sleep(100);
        }
        // Get File Name using Java Query
        String fileName = (String) downloadWindowExecutor.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
     // Get download folder location
        String downloadedFolder = (String) downloadWindowExecutor.executeScript("return c");
        System.out.println("Details of Downloaded Files");
        // print the details
        System.out.println("Details of Downloaded Files");
        System.out.println("Downloaded File Name: " + fileName);
        System.out.println("Donwloaded File Location: " + downloadedFolder);
        driver.switchTo().window(parentWindow);
        */
		
		// Specify the path of file
		  File src=new File("C:\\Users\\Sweta Naik\\Downloads\\Buildingform1645793043.xlsx");
		 
		   // load file
		   FileInputStream fis=new FileInputStream(src);
		   
		 /*  Workbook wb1 = WorkbookFactory.create(src);
		   List<String> sheetNames = new ArrayList<String>();
		   for (int i=0; i<wb1.getNumberOfSheets(); i++) {
			   
		       sheetNames.add( wb1.getSheetName(i) );
		   }
		 */
		   
		
	        
		   // Load workbook
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		   // Load sheet- Here we are loading first sheetonly
		      XSSFSheet sh1= wb.getSheetAt(0);
		 
		  // getRow() specify which row we want to read.
		 
		  // and getCell() specify which column to read.
		  // getStringCellValue() specify that we are reading String data.

		      //int rowCount = sh1.getLastRowNum();
		      int rowCount = sh1.getPhysicalNumberOfRows();
		      XSSFCell firstColumnCell = null;
		        int firstColumnRowCount = 0;
		      
		      //Row row = sh1.getRow(0);
		      System.out.println(rowCount-1);
		      
		      
		 
		 for(int i=0; i<=rowCount; i++){
			
		
			 //sh1.getRow(i).getCell(0);
			 try {
			 System.out.println(sh1.getRow(i).getCell(0).getStringCellValue()); 
			/* XSSFRow row = sh1.getRow(i);
             firstColumnCell = row.getCell(0);*/
			 firstColumnCell = sh1.getRow(i).getCell(0);
			 
			 }
			 catch (NullPointerException nullPointerException) {
             if (firstColumnCell.getStringCellValue().length() > 0) {
                 //firstColumnRowCount = i;
                 int totBid = i-1;
                 System.out.println("Total No. of buildings: " + (i-1));
                 
             }
             }
             
		 
		 /* catch (NullPointerException nullPointerException) {
			  int totBid = i-1;
             System.out.println("Total No. of buildings: " + (i-1));
         }
		 if (firstColumnCell != null) {
             if (firstColumnCell.getStringCellValue().length() > 0) {
                 firstColumnRowCount = i;
             }
         }*/
		

}
	}

}
