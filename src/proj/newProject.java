package proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class newProject {

	public void test () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.spicejet.com");

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(2000L);
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
       
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();
        Select A = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
        A.selectByValue("3");
        Thread.sleep(2000L);
        Select C = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
        C.selectByValue("1");
        Thread.sleep(2000L);
        Select I = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
        I.selectByValue("1");
        Thread.sleep(2000L);
        driver.findElement(By.xpath("//input[@type='submit']")).click();	
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		newProject NP = new newProject();
		NP.test();
		

	}

}
