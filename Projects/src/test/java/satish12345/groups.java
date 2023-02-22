package satish12345;

import java.awt.AWTException;
import java.awt.Robot;  
import javax.swing.event.MenuKeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
  
public class groups {
	WebDriver wd;
	
	@BeforeTest(groups = "beforetest")
	  public void beforetest() throws InterruptedException {
			  WebDriverManager.chromedriver().setup();
			  this.wd = new ChromeDriver();
			  wd.get("https://demoqa.com/");
			  Thread.sleep(3000);
	  }
	
  @Test(groups = "textbox")
  public void testcase1() throws InterruptedException, AWTException {
	  Robot rc = new Robot();
	  rc.keyPress(MenuKeyEvent.VK_SPACE);  Thread.sleep(2000);		
	  wd.findElement(By.xpath("//*[@class='category-cards']/div[1]")).click(); Thread.sleep(2000);	  
	  wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[1]")).click(); Thread.sleep(2000);	  
	  rc.keyPress(MenuKeyEvent.VK_DOWN);  rc.keyPress(MenuKeyEvent.VK_DOWN);  rc.keyPress(MenuKeyEvent.VK_DOWN);	 
	  wd.findElement(By.id("userName")).sendKeys("sathish");
	  wd.findElement(By.id("userEmail")).sendKeys("sathish@gmail.com");
	  wd.findElement(By.id("currentAddress")).sendKeys("coimbatore");
	  wd.findElement(By.id("permanentAddress")).sendKeys("coimbatore");
	  rc.keyPress(MenuKeyEvent.VK_PAGE_DOWN); 	  Thread.sleep(3000);
      WebElement a1 = wd.findElement(By.xpath("//*[@id='submit']"));
	  Actions act = new Actions(wd);
	  act.moveToElement(a1).click().build().perform();	  Thread.sleep(3000);
  }
  @Test(groups = "checkbox")
  public void testcase2() throws InterruptedException {
	  wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[2]")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/span/button")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/ol/li/span/button")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/ol/li/ol/li/span/label/span")).click();
	  Thread.sleep(1000);
  }
  @Test(groups = "sanity", priority = 2)
  public void testcase3() {
	  System.out.println("sanity is done");
	  
  }
  @Test(groups = "retest", priority = 3)
  public void testcase4() {
	  System.out.println("retest is done");
	  
  }
}
