package satish12345;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class robot {
	WebDriver wd;
	public String URL1 ="https://www.google.co.in/";
	public String URL2 ="https://amazon.in/";
 
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get(URL1);
		Thread.sleep(3000);
  }
  @Test
  public void actions() throws AWTException, InterruptedException {
	  WebElement link = wd.findElement(By.xpath("//*[contains(text(),'Gmail')]"));
	  //link.click();
	  Actions act = new Actions(wd);
	  act.contextClick(link).build().perform();
	  
	  Robot rc = new Robot();
	  //rc.keyPress(MenuKeyEvent.VK_END);
	  //Thread.sleep(2000);
	  //rc.keyPress(MenuKeyEvent.VK_HOME);
	  Thread.sleep(2000);
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  rc.keyPress(MenuKeyEvent.VK_ENTER);
	  Thread.sleep(2000);
	  rc.keyPress(MenuKeyEvent.VK_CONTROL);
	  rc.keyPress(MenuKeyEvent.VK_TAB);
	  rc.keyRelease(MenuKeyEvent.VK_CONTROL);
	  //link1.click();
	  //Thread.sleep(2000);
	  //rc.keyPress(MenuKeyEvent.VK_UP);
	  //Thread.sleep(3000);
	  
  }
  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
