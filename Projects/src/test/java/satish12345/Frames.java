package satish12345;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver wd;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("https://demoqa.com/frames");
	}
	
  @Test
  public void frames1() throws InterruptedException {
	  
       JavascriptExecutor js = (JavascriptExecutor)wd;
       js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       Thread.sleep(3000);
	  List<WebElement> frame = wd.findElements(By.tagName("iframe"));
	  System.out.println(frame);
	  System.out.println(frame.size());
	  
	  for(int i=0; i<=8; i++){
			String str = frame.get(i).getAttribute("id");
			System.out.println(str);
  }
	  Thread.sleep(3000);
      wd.switchTo().frame("frame2");
      js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
      Thread.sleep(3000);
      wd.close();
}
  
}