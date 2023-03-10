package satish12345;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class dataprovider {
	
	WebDriver wd;
	
	 @DataProvider(indices = {})
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Admin", "admin123" },
	      new Object[] { "Admin", "admin123" },  //positive scenario
	      new Object[] { "Admin1", "admin123" },  //negative scenario
	    };
	  }
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();	
			wd.get("https://opensource-demo.orangehrmlive.com");
			Thread.sleep(3000);
	  }
	
  @Test(dataProvider = "dp")
  public void data_provider(String n, String s) throws InterruptedException {
	  Thread.sleep(3000);
	  wd.findElement(By.name("username")).sendKeys(n);
	  wd.findElement(By.name("password")).sendKeys(s);
	  Thread.sleep(3000);
	  wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	  Thread.sleep(3000);
	  wd.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
	  Thread.sleep(3000);
	  wd.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
  }

}
