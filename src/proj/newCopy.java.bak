package proj;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import proj.newCopy;
//import proj.newCopy.Modules;

public class newCopy {

	WebElement buttons,navbtn,fieldname;
	static WebElement elepath;
	int val,loopval;
	static int result,i,j,count=0;
	static String WEpath, loopcount;
	static JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	Object[] options = {"Yes, please", "No way!", "Skip, records"};

	String url = "https://cityos-uat.smartmu.com/";
	String  path = "C:\\Selenium\\chromedriver.exe";
	public static WebDriver driver;
	WebDriverWait wait;


	public String launchandlogin() throws InterruptedException{
		System.out.println("launching Chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 20);
		
		wait.until((ExpectedConditions.presenceOfElementLocated(By.id("emailDiv"))));
		driver.findElement(By.id("emailDiv")).sendKeys("testpanj@yopmail.com"); // ** change user name

		driver.findElement(By.id("passwordDiv")).sendKeys("Hello@123"); //** change password
		wait.until((ExpectedConditions.presenceOfElementLocated(By.id("passwordDiv"))));
		driver.findElement(By.className("submit-btn")).click();
		Thread.sleep(1500);	
		//fetching the session count
		String layercount = "/html/body/app-root/app-management/app-map-sessions-route/app-dashboard/div/div/div[2]/div/div[1]/span";
		return layercount;
	}

	public void terminateBrowser() throws InterruptedException{ //closing the browser session
		Thread.sleep(3000);	
		driver.close(); //driver close
		driver.quit(); //driver quit
		System.exit(0); //
	}

	public void NavCityOS() throws InterruptedException{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/mat-dialog-container/map-session-dashboard-dialog/div[2]/div[1]")).click();
		buttons = driver.findElement(By.xpath("//a[@href='/app-management/cityos']"));
		buttons.click();
		Thread.sleep(1000);
	}
	public static String dropdownselection (int looping) throws InterruptedException{ //will work for dropdown items
		int i=1;
		for (i=i+1; i<= looping; i++) {
			elepath = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/mat-option["+i+"]"));
			WEpath = elepath.getText();
			frame.setAlwaysOnTop(true);
			result = JOptionPane.showConfirmDialog(frame, WEpath, "Do you want to continue", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (result==0) {
				elepath.click();
				System.out.println("Element is : "+ WEpath);
				break;
			}
		}
		return WEpath;
	}

	public static int dropdownoptioncount(int  count)throws InterruptedException  {
		List<WebElement> numOptions = driver.findElements(By.xpath("//mat-option"));
		count = numOptions.size();
		//System.out.println("Total items are : "+ count);
		Thread.sleep(2000);
		return count;	
	}
/*
	public static void dropdownboxselection (int looping) throws InterruptedException{ //will work for checkbox items, need to provide the length and start limit 
		for (int i=1;i<= looping; i++) {
			WebElement OKBtnElement = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div/div/mat-option["+i+"]"));
			String WEpath = OKBtnElement.getText();
			int result = JOptionPane.showConfirmDialog(frame, WEpath, "Do you want to continue", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (result==0) {
				OKBtnElement.click();
				System.out.println("Element is : "+ WEpath);
				continue;
			}
		}
	}
*/
	public static void userinput(WebElement path, String msg) throws InterruptedException{ //path of element and field name
		Actions action = new Actions(driver);
		JFrame  jf=new JFrame();
		jf.setAlwaysOnTop(true);
		String text = JOptionPane.showInputDialog(jf, msg, "The title", JOptionPane.NO_OPTION);
		if(text != null) {
			System.out.println(text);
			try {
				path.click();
				action.sendKeys(path, text).build().perform();
			}
			catch (Exception e) {}
		}
		else {
			jf.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog( jf, "Not clicking on submit button" );
		}
		text=null;
	}

	
	public void surveyorassignment(String values) throws InterruptedException, Exception{
		  int counter;
		  int loop=0;
		  System.out.println("selected value is : " + values);
			if(values.startsWith("Users")) {
				fieldname = driver.findElement(By.xpath("//*[@id=\"listByUsers\"]/div/table"));
				List<WebElement> rowcount = fieldname.findElements(By.tagName("tr"));
				counter = rowcount.size();

				loop = selectbyusers();	//iterating through the table for available surveyors		
				System.out.println("Total iterated users are : "+ loop);
				
				/*buttons = driver.findElement(By.xpath("//*[contains(text(),'Assign')]"));
				buttons.click();*/
				Thread.sleep(1500);
				assignment(values); // selecting users
				Thread.sleep(1500);
				//buttons = driver.findElement(By.xpath("//*[contains(text(),'ASSIGN WARD(S)')]"));
				//buttons.click();
				buttons = driver.findElement(By.xpath("//div[contains(text(),'ASSIGN WARD(S) TO USER(S)')]"));
				buttons.click();
			}
			else {
				loop =0;
				fieldname = driver.findElement(By.xpath("//*[@id=\"listByWards\"]/div/table"));
				List<WebElement> rowcount = fieldname.findElements(By.tagName("tr"));
				counter = rowcount.size();
				System.out.println("Total checkbox count is : "+ counter);
				
				loop = selectbywards(); //iterating through the table for available wards
				System.out.println("Total iterated wards are : "+ loop);
				
				/*buttons = driver.findElement(By.xpath("//*[contains(text(),'Assign')]"));
				buttons.click();*/
				Thread.sleep(1500);
				assignment(values); //selecting wards
				Thread.sleep(1500);
				//buttons = driver.findElement(By.xpath("//*[contains(text(),'ASSIGN USER(S)')]"));
				//buttons.click();
				buttons = driver.findElement(By.xpath("//div[contains(text(),'ASSIGN USER(S) TO WARD(S)')]"));
				buttons.click();
	
				
			}
	}

	public void assignment( String values) throws InterruptedException{
		Actions action = new Actions(driver);
		JFrame  jf=new JFrame();
		int i;
		System.out.println("The value is : " + values);
		String users = "surveyors";
			
		if (values.equalsIgnoreCase("Users")) {
			i=1;
			try {
				do {
					jf.setAlwaysOnTop(true);
					String labels = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-wards-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText();
					
					int loop = JOptionPane.showOptionDialog(jf, labels, "The title", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					if (loop==0) {
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-wards-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/mat-checkbox[1]")).click();
						Thread.sleep(500);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();	
						i++;
						continue;
						}
						if (loop==2) {
						break;
						}
					i++;
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
									
				} while (driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-wards-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr[\"+i+\"]/td[1]/mat-checkbox[1]")).isDisplayed());
			}
			catch (Exception e) {
				//System.out.println("Found error");
				}		
		}
		else {
			i=1;
			try {
				do {
					jf.setAlwaysOnTop(true);
					String labels = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-surveyor-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).getText();
					
					int loop = JOptionPane.showOptionDialog(jf, labels, "The title", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					if (loop==0) {
						driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-surveyor-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[1]/mat-checkbox[1]")).click();
						Thread.sleep(500);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();	
						i++;
						continue;
						}
						if (loop==2) {
						break;
						}
					i++;
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
									
				} while (driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-management[1]/app-cityos[1]/div[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/app-view-surveyor-assignments[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr["+i+"]/td[2]")).isDisplayed());
			}
			catch (Exception e) {
				//System.out.println("Found error");
				}
		}	
	}
	


	
	public int selectbywards () throws InterruptedException{
		Actions action = new Actions(driver);
		JFrame  jf=new JFrame();
		int i=1;
		try {
			do {
				jf.setAlwaysOnTop(true);
				String labels = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav-content/app-list-survey-assignments/div/div/div/div[2]/div/div/table/tbody/tr["+i+"]/td[2]")).getText();
				
				int loop = JOptionPane.showOptionDialog(jf, labels, "The title", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				if (loop==0) {
					driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/span")).click();
					driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]")).click();
					Thread.sleep(500);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();	
					i++;
					continue;
					}
					if (loop==2) {
					break;
					}
				i++;
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				//System.out.println("Value of I is : "+ i);
				
			} while (driver.findElement(By.xpath("//tbody/tr["+i+"]/td[4]/span")).isDisplayed());
		}
		catch (Exception e) {
			//System.out.println("Found error");
			}
		return (i-1);
		
	}


	public int selectbyusers() throws InterruptedException {
		Actions action = new Actions(driver);
		JFrame  jf=new JFrame();
		int i=1;
		try {
			do {
				jf.setAlwaysOnTop(true);
				String labels = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav-content/app-list-survey-assignments/div/div/div/div[2]/div/div/table/tbody/tr["+i+"]/td[2]")).getText();
				
				int loop = JOptionPane.showOptionDialog(jf, labels, "The title", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
				if (loop==0) {
					driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]/span")).click();
					driver.findElement(By.xpath("//body/div[3]/div[2]/div[1]/div[1]/div[1]")).click();
					Thread.sleep(500);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();	
					i++;
					continue;
					}
					if (loop==2) {
					break;
					}
				i++;
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				//System.out.println("Value of I is : "+ i);
				
			} while (driver.findElement(By.xpath("//tbody/tr["+i+"]/td[5]/span")).isDisplayed());
		}
		catch (Exception e) {
			//System.out.println("Found error");
			}
		return (i-1);
	}


	public class Modules {
		
	public void ULBMngmt() throws InterruptedException{
		
		Actions actions = new Actions(driver);
		navbtn = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav/div/div/div/div[1]/ul/li[1]"));
		navbtn.click();
		Thread.sleep(1000);
		
		fieldname = driver.findElement(By.xpath("//input[@formcontrolname = 'name']"));
		fieldname.clear();
		Thread.sleep(500);
		userinput(fieldname,"ULB Name"); //ULB name
		
		fieldname = driver.findElement(By.xpath("//input[@formcontrolname = 'code']"));
		fieldname.clear();
		Thread.sleep(500);
		userinput(fieldname,"ULB Code"); //ULB Code
		Thread.sleep(1000); 
		
		//Click on ULB AOI layer
		driver.findElement(By.id("layer")).click(); 
		val = dropdownoptioncount(count);
		System.out.println("Total AOI layer items are : "+ val); // displaying the count
		dropdownselection(val);
		Thread.sleep(1000);
		
		val=0; //Administrative tier
		driver.findElement(By.id("administrativeTier")).click(); 
		val = dropdownoptioncount(count);
		System.out.println("Total Number Of Administrative Tiers are : "+ val); // displaying the count
		loopcount = dropdownselection(val);
		System.out.println("Loop count total value is : "+ loopcount);
		Thread.sleep(1000);
		loopval = Integer.parseInt(loopcount);
		
		j=5; 
		for (i=1;i<=loopval;i++) {
		Thread.sleep(1200);
		val=0;
		//int k=1;
		driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav-content/app-urban-local-bodies/div/div/div/div/div/form/div["+j+"]/div/div[1]/mat-select")).click(); //tier 1 Administrative layer
		val = dropdownoptioncount(count);
		System.out.println("Total Tier I Administrative Layer : "+ val); // displaying the count
		dropdownselection(val);
		
		
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1500);	
		
		val=0;
		driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav-content/app-urban-local-bodies/div/div/div/div/div/form/div["+j+"]/div/div[2]/mat-select")).click(); //Field to be used as ward name for Tier I Layer

		val = dropdownoptioncount(count);
		System.out.println("Total Field to be used as ward name for Tier I Layer : "+ val); // displaying the count
		dropdownselection(val);
		Thread.sleep(1200);
		System.out.println("Value of J is : "+ j);
		j++;
		Thread.sleep(1200);
		}
		
		Thread.sleep(1500);
		
		val=0;
		driver.findElement(By.xpath("//mat-select[@formcontrolname = 'surveyMgmtTier']")).click(); //Tier For Survey Assignment
		val = dropdownoptioncount(count);
		System.out.println("Total Tier For Survey Assignment : "+ val); // displaying the count
		dropdownselection(val);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Submit')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
		Thread.sleep(2000);
		//Spatial_Analysis.successmsg("Wont be able to edit ULB Config again, hence not clicking on Confirm button");
		
		//driver.findElement(By.xpath("//*[contains(text(),'Cancel')]")).click();
	  }

	public void SurveyMngmt() throws Exception{
		
		val=0;
		Thread.sleep(2000);
		navbtn = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav/div/div/div/div[1]/ul/li[2]"));
		navbtn.click();
		Thread.sleep(1500);
		driver.findElement(By.id("selectedListBy")).click();
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		frame.setAlwaysOnTop(true);
		//loop is to iterate through the dropdown items
		for (i=1; i<= val; i++) {
			elepath = driver.findElement(By.xpath("//mat-option[@role = 'option']["+i+"]"));
			WEpath = elepath.getText();
			result = JOptionPane.showConfirmDialog(frame, WEpath, "Do you want to continue", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (result==0) {
				elepath.click();
				System.out.println("Element is : "+ WEpath);
				break;
			}
		}
		//end of loop
		Thread.sleep(1500);
		surveyorassignment(WEpath);
		}

	public void PropertyAssessment() throws InterruptedException {
		Actions action = new Actions(driver);
		JFrame  jf=new JFrame();
		val=0;
		Thread.sleep(2000);
		navbtn = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav/div/div/div/div[2]/ul/li[1]"));
		navbtn.click();
		Thread.sleep(2000);
		
		val=0;
		driver.findElement(By.id("project")).click(); // select project
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		dropdownselection(val);
		
		val=0;
		driver.findElement(By.id("buildingForm")).click(); // select buildingForm
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		dropdownselection(val);
		
		val=0;
		driver.findElement(By.id("premiseForm")).click(); // select premiseForm
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		dropdownselection(val);
		
		val=0;
		driver.findElement(By.id("sessionDashboard")).click(); // Map session for survey
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		dropdownselection(val);
		
		val=0;
		driver.findElement(By.id("sessionDataView")).click(); // Map session for Data view
		Thread.sleep(1500);
		val = dropdownoptioncount(count);
		dropdownselection(val);
		
		if(driver.findElement(By.id("loadBuildingBaseLayer")).isDisplayed()) {
			jf.setAlwaysOnTop(true);
			int result = JOptionPane.showConfirmDialog(jf, "Load Building feature available", "Do you want to continue", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if (result==0) {
				driver.findElement(By.id("loadBuildingBaseLayer")).click();
				System.out.println("Load buildings feature enabled");
				
				Thread.sleep(1500);
				driver.findElement(By.id("buildingBaseLayer")).click(); //building base layer
				val = dropdownoptioncount(count);
				dropdownselection(val);
				
				action.sendKeys(Keys.PAGE_DOWN).build().perform();
				
				Thread.sleep(1500);
				driver.findElement(By.id("buildingBaseLayerProperty")).click(); //building base layer property
				val = dropdownoptioncount(count);
				dropdownselection(val);
				}
			}
		Thread.sleep(1500);
		jf.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog( jf, "Not clicking on submit button" );
		//driver.findElement(By.xpath("//button[@type = 'submit']")).click(); //click on submit button
		
		}

	public void datamanagement () throws InterruptedException {
		
		//Actions action = new Actions(driver);
		//JFrame  jf=new JFrame();
		val=0;
		Thread.sleep(2000);
		navbtn = driver.findElement(By.xpath("/html/body/app-root/app-management/app-cityos/div/mat-sidenav-container/mat-sidenav/div/div/div/div[2]/ul/li[2]"));
		navbtn.click();
		Thread.sleep(2000);
	}

	}


	public static void main(String[] args) throws Exception{
		newCopy OS = new  newCopy();
		OS.launchandlogin();
		Thread.sleep(2000);
		OS.NavCityOS();
		Thread.sleep(2000);
		Modules mod = OS.new Modules();
		//Modules
		
		//ULB Management
		//mod.ULBMngmt();
		//Survey Management
		mod.SurveyMngmt();
		//mod.PropertyAssessment();
		
		OS.terminateBrowser();
	}

}
