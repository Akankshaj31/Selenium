package satish12345;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webelement {
	WebDriver ab;

	@BeforeTest
	public void beforetest() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		ab = new ChromeDriver();
		ab.navigate().to("https://rahulshettyacademy.com/practice-project");
		ab.manage().window().maximize();
	}
  @Test
  public void actions() throws InterruptedException, AWTException {
	    WebElement we = ab.findElement(By.linkText("More"));
		Actions act = new Actions(ab);
		Thread.sleep(6000);
		act.moveToElement(we).build().perform();
		Robot rc=new Robot();
		rc.keyPress(MenuKeyEvent.VK_END);
		Thread.sleep(2000);
		rc.keyPress(MenuKeyEvent.VK_HOME);
		Thread.sleep(2000);
		//WebElement we1 = ab.findElement(By.xpath("//*[@class='nav-outer clearfix']/nav/div[2]/ul/li[1]"));
		//we1.click();
		Thread.sleep(2000);
		WebElement we2 = ab.findElement(By.xpath("//*[@class='fa fa-youtube']"));
		we2.click();
		Thread.sleep(2000);
  }
  @AfterTest
  public void aftertest() {
	  //ab.close();
	  
  }
}
