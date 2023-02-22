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

public class makemytrip {
	WebDriver qc;
	@BeforeTest
	public void beforetest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		qc= new ChromeDriver();
		qc.manage().window().maximize();
		qc.get("https://www.makemytrip.com/");
		 Thread.sleep(4000);	
		 	
	}
  @Test
  public void f() throws InterruptedException, AWTException {
	  Actions act = new Actions(qc);
	 Robot rc = new Robot();
	 act.doubleClick().build().perform();
	 act.doubleClick().build().perform();
		 Thread.sleep(4000);
	  //WebElement w2 = qc.findElement(By.xpath("//*[@class='paddingLR20']/div[2]"));
	  //w2.click();
	  //Thread.sleep(2000);
	  WebElement w1 = qc.findElement(By.xpath("//*[@class='lbl_input latoBold  appendBottom5']"));
	  act.doubleClick(w1).build().perform();
	  w1.click();
	  qc.findElement(By.xpath("//*[@class='hsw_autocomplePopup autoSuggestPlugin ']/div/input")).sendKeys("coimbatore");
	  Thread.sleep(2000);
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  rc.keyPress(MenuKeyEvent.VK_ENTER);
	  WebElement w2 = qc.findElement(By.xpath("//*[@class='fsw_inner returnPersuasion']/div[2]/label/span"));
	  act.doubleClick(w2).build().perform();
	  act.doubleClick().build().perform();
	  qc.findElement(By.xpath("//*[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']/div[1]/input")).sendKeys("delhi");
	  Thread.sleep(2000);
	  rc.keyPress(MenuKeyEvent.VK_DOWN);
	  rc.keyPress(MenuKeyEvent.VK_ENTER);
	  qc.findElement(By.xpath("//*[@class='fsw_inner returnPersuasion']/div[3]/label/span")).click();
	  Thread.sleep(2000);
	  qc.findElement(By.xpath("//*[@class='fsw_inputBox dates inactiveWidget activeWidget']/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[5]/div/p[1]")).click();
	  Thread.sleep(2000);
	  qc.findElement(By.xpath("//*[@class='fsw_inner returnPersuasion']/div[4]/label/span")).click();
	  Thread.sleep(2000);
	  qc.findElement(By.xpath("//*[@class='fsw_inputBox dates inactiveWidget activeWidget']/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[4]/div[5]/div/p[1]")).click();
	  Thread.sleep(2000);
	  //rc.keyPress(MenuKeyEvent.VK_ALT);
	  //rc.keyPress(MenuKeyEvent.VK_TAB);
	 // rc.keyRelease(MenuKeyEvent.VK_ALT);
	  //Thread.sleep(2000);
	  //rc.keyPress(MenuKeyEvent.VK_ALT);
	  //rc.keyPress(MenuKeyEvent.VK_TAB);
	  //rc.keyRelease(MenuKeyEvent.VK_ALT);
	  //qc.findElement(By.xpath("//*[@class='modalFieldInner makeFlex hrtlCenter ']/input")).sendKeys("8072553712");
	  //qc.findElement(By.xpath("//*[@class='aCsJod oJeWuf']/div[1]/div/input")).sendKeys("skksathish258");
	  //qc.findElement(By.name("Email or phone")).sendKeys("skksathish258");
	  Thread.sleep(2000);
  }
  @AfterTest
  public void aftertest() {
	 //qc.close();
  }
}
