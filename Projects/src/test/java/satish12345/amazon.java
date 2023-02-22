package satish12345;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class amazon {
  WebDriver wd;
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.navigate().to("https://amazon.in");
		Thread.sleep(3000);
  }
  
  @Test(priority = 0)
  public void Login() throws InterruptedException {
	  	  wd.findElement(By.id("nav-signin-tooltip")).click();
	  Thread.sleep(2000);
	  wd.findElement(By.xpath("//*[@class=\'a-input-text a-span12 auth-autofocus auth-required-field\']")).sendKeys("8072553712");
	  wd.findElement(By.id("continue")).click();
	  Thread.sleep(3000);
	  	  wd.findElement(By.id("ap_password")).sendKeys("sathish@92");
	  wd.findElement(By.id("signInSubmit")).click();
	 	  Thread.sleep(3000);
  }
  @Test(priority = 1)
  public void Homepage() throws InterruptedException {
	  wd.findElement(By.xpath("//*[@class=\'a-icon a-icon-previous-rounded\']")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class=\'a-icon a-icon-previous-rounded\']")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.xpath("//*[@class=\'a-icon a-icon-previous-rounded\']")).click();
	  Thread.sleep(3000);
	  wd.findElement(By.id("twotabsearchtextbox")).sendKeys("mobiles");
	  Thread.sleep(4000);
	  wd.findElement(By.id("nav-search-submit-button")).click();
  }
  
  @AfterTest
  public void afterTest() {
	  wd.close();
  }

}
