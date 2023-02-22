package satish12345;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extent_Report {
	ExtentReports extent;
	ExtentTest logger;
	WebDriver wd;
	@BeforeTest
	public void bt() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/sathish.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"src/test/java/extent-config.xml"));
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		
	}
	

  @Test
  public void orangehrm() {
	  logger = extent.startTest("demo");
	  wd.get("https://opensource-demo.orangehrmlive.com");
  }
}
