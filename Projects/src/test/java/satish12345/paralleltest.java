package satish12345;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paralleltest {
	WebDriver wq;
	
	 @Parameters("mybrowser")
  
  @BeforeTest
  public void beforetest(String mybrowser) {
	  if(mybrowser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  wq = new ChromeDriver();
	  }
	  else if(mybrowser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  wq = new FirefoxDriver();
	  }
	  else if(mybrowser.equalsIgnoreCase("microsoftedge")) {
		  WebDriverManager.edgedriver().setup();
		  wq = new SafariDriver();
	  }
  }
  
  
  @Test
  public void orangehrm() throws InterruptedException {
	  wq.get("https://opensource-demo.orangehrmlive.com");
	  Thread.sleep(3000);
	  wq.findElement(By.name("username")).sendKeys("Admin");
	  wq.findElement(By.name("password")).sendKeys("admin123");
	  Thread.sleep(3000);
	  wq.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	  Thread.sleep(3000);
	  wq.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	  Thread.sleep(3000);
	  wq.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000);
  }
  
}
