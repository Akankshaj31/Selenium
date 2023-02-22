package satish12345;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload_alerts {
	WebDriver wd;
	public String URL1 ="https://demoqa.com/upload-download";
	public String URL2 ="https://demoqa.com/alerts";
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		
	}
	
  @Test(enabled = false)
  public void uploading() throws InterruptedException {
	  wd.get(URL1);
	  Thread.sleep(2000);
	  wd.findElement(By.id("uploadFile")).sendKeys("\"C:\\Users\\Admin\\Desktop\\already responded.png\"");
  }
  @Test(priority = 1)
  public void alerts() throws InterruptedException, AWTException {
	  wd.get(URL2);
	  Robot rc = new Robot();
	 wd.findElement(By.id("alertButton")).click(); //clicking on the alert button
	  Alert alt = wd.switchTo().alert(); //switch to alert popup
	  Thread.sleep(2000);
	  alt.accept();
	  wd.findElement(By.id("timerAlertButton")).click(); //clicking on the alert button
	  WebDriverWait w1 = new WebDriverWait(wd, 180);
	  w1.until(ExpectedConditions.alertIsPresent());
	  alt.accept();
	  Thread.sleep(3000);
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  Thread.sleep(3000); 
	  wd.findElement(By.id("confirmButton")).click();
	  Thread.sleep(3000);
	  alt.accept();  
	  Thread.sleep(3000);   
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  Thread.sleep(3000); 
	  wd.findElement(By.id("promtButton")).click();
	  Thread.sleep(3000);
	  alt.sendKeys("sathish");
	  alt.accept();
  }
}
