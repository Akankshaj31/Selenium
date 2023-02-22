package satish12345;

import java.awt.AWTException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandle {
	WebDriver wd;
	public String URL1 ="https://demoqa.com/browser-windows";
	public String URL2 ="https://google.com";
	@BeforeTest
	public void beforetest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		Thread.sleep(3000);
	}
	
  @Test
  public void window() throws InterruptedException, AWTException {
	  wd.get(URL1);
	  Thread.sleep(3000);
	  WebElement a1 = wd.findElement(By.id("windowButton"));
	  
	  for (int i = 0; i < 3; i++) {
	  a1.click();
	  } 
	  Thread.sleep(2000);
	  String parentwindow = wd.getWindowHandle();
	  System.out.println(parentwindow);
	  Set<String> allwindow = wd.getWindowHandles();
	  System.out.println(allwindow);
	  String lastwindow = "";
	  
	 for(String handle : allwindow) {
		 wd.switchTo().window(handle);
		 wd.get("https://google.com");
		 lastwindow = handle;
	 }
	 Thread.sleep(3000);
	 wd.switchTo().window(parentwindow);
	 wd.get("https://opensource-demo.orangehrmlive.com");
	 wd.close();
	 wd.switchTo().window(lastwindow);
	 wd.get("https://mail.google.com");
	 wd.close();
  }
}
