package Project1;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import javax.swing.event.MenuKeyEvent;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testadmin {
	WebDriver wd;
	
	@BeforeTest
	public void BT() throws InterruptedException { 
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
	}
	
  @Test(priority = 0)
  public void Login() throws InterruptedException, IOException {
	  wd.findElement(By.name("username")).sendKeys("Admin");
	  wd.findElement(By.name("password")).sendKeys("admin123");
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class='oxd-form-actions orangehrm-login-action']")).click();
	  Thread.sleep(3000);
	  System.out.println(wd.getTitle());
	  WebElement t1 = wd.findElement(By.xpath("//*[@src='/web/images/orangehrm-logo.png?1672659722816\']"));
	  Assert.assertTrue(t1.isDisplayed());
	  if (t1.isDisplayed()) {
		  System.out.println("String is diplayed");
	  }
	  File scr = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);    // take screenshot
	  FileUtils.copyFile(scr, new File("C:\\Users\\Admin\\Pictures\\Screenshots\\screen.png"));
  }
  @Test(enabled = false)
  public void Admin() throws InterruptedException, AWTException {
	  Robot rc = new Robot(); //Actions act = new Actions(wd);
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  wd.findElement(By.linkText("Admin")).click(); Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class='oxd-form-row']/div/div[2]/div/div[2]/div/div/div[2]/i")).click(); Thread.sleep(1000);
	  rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER); 
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class='oxd-form-actions']/button[2]")).click(); Thread.sleep(1000);
	  JavascriptExecutor js = (JavascriptExecutor)wd;
      js.executeScript("window.scrollBy(0,500)"); Thread.sleep(1000);
      wd.findElement(By.xpath("//*[@class='oxd-table']/div[2]/div[6]/div/div[1]/div/div/label/span/i")).click(); Thread.sleep(1000);
      wd.findElement(By.xpath("//*[@class='oxd-table']/div[2]/div[7]/div/div[1]/div/div/label/span/i")).click(); Thread.sleep(1000);
      js.executeScript("window.scrollBy(0,-200)"); Thread.sleep(2000);
      wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")).click(); Thread.sleep(2000);
      wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
      Thread.sleep(5000);
  }
  @AfterTest
  public void AT() {
	 
  }
}
