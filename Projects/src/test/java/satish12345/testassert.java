package satish12345;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testassert {
	WebDriver wd; 
	@BeforeTest
	public void beforetest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.navigate().to("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(3000);
	}
  @Test
  public void asserttest() throws InterruptedException {
	    String ActualTitle = wd.getTitle();
		String ExpectedTitle = "OrangeHRM";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		Thread.sleep(3000);
		WebElement s2 = wd.findElement(By.xpath("//*[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
		Assert.assertEquals(true, s2.isDisplayed());
		System.out.println("Expected");
		 
        
  }
  @AfterTest
  public void aftertest() {
	  wd.close();
  }
}
