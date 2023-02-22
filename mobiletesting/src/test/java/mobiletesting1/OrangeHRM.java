package mobiletesting1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class OrangeHRM {
	AndroidDriver<WebElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\Admin\\eclipse-workspace\\mobiletesting\\chromedriver.exe");
		driver=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://www.google.co.in/");
	  driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("orange hrm demo");
	  Actions act = new Actions(driver);
	  act.sendKeys(Keys.ENTER).build().perform();
	  driver.findElement(By.partialLinkText("OrangeHRM Demo.")).click();
	  String title = driver.getTitle();
		System.out.println(title);
	  driver.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	  WebElement t1 = driver.findElement(By.xpath("//*[@src='/web/images/orangehrm-logo.png?1672659722816\']"));
	  Assert.assertTrue(t1.isDisplayed());
	  if (t1.isDisplayed()) {
		  System.out.println("String is diplayed");
		  driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("Logout")).click();
	  }
	  else {
		  System.out.println("String is not displayed");
	  }
  }
}
