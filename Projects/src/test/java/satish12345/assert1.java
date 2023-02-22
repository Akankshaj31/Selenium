package satish12345;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assert1 {
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
			WebDriver wd = new ChromeDriver();
			wd.navigate().to("https://opensource-demo.orangehrmlive.com");
			Thread.sleep(3000);
			String ActualTitle = wd.getTitle();
			String ExpectedTitle = "OrangeHRM";
			Assert.assertEquals(ExpectedTitle, ActualTitle);
			
	
	}
}