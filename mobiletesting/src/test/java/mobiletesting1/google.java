package mobiletesting1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class google {
AndroidDriver<WebElement> wd;
	
	@BeforeTest
	public void bt() throws MalformedURLException
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "XUV9X18831G04154");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\Admin\\eclipse-workspace\\mobiletesting\\chromedriver.exe");
		wd=new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  @Test
  public void search() {
	  wd.get("https://www.google.co.in/");
	  wd.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("orange hrm demo");
	  Actions act = new Actions(wd);
	  act.sendKeys(Keys.ENTER).build().perform();
	  wd.findElement(By.partialLinkText("OrangeHRM Demo.")).click();
	  wd.findElement(By.xpath("//*[@name='username']")).sendKeys("Admin");
	  wd.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
	  wd.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
  }
}
