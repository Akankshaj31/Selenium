package Demoqapage;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import javax.swing.event.MenuKeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elementspage {
	WebDriver wd;
	JavascriptExecutor js;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://demoqa.com/elements");
		Thread.sleep(3000);	
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(priority = 0) 
	public void textbox() throws InterruptedException, AWTException {
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,200)"); Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[1]")).click(); Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");
		wd.findElement(By.id("userName")).sendKeys("sathish");
		wd.findElement(By.id("userEmail")).sendKeys("sathish@gmail.com");
		wd.findElement(By.id("currentAddress")).sendKeys("coimbatore");
		wd.findElement(By.id("permanentAddress")).sendKeys("coimbatore"); Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,100)"); Thread.sleep(1000);
		WebElement a1 = wd.findElement(By.xpath("//*[@id='submit']"));
		Actions act = new Actions(wd);
		act.moveToElement(a1).click().build().perform();
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
	}

	@Test(priority = 1)   
	public void CheckBox() throws InterruptedException {
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[2]")).click(); Thread.sleep(2000); 
		wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/span/button")).click(); Thread.sleep(1000); 
		wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/ol/li/span/button")).click(); Thread.sleep(1000); 
		wd.findElement(By.xpath("//*[@class='react-checkbox-tree rct-icons-fa4']/ol/li/ol/li/ol/li/span/label/span")).click(); Thread.sleep(1000); }

	@Test(priority = 2)  
	public void RadioButton() throws InterruptedException,AWTException{ 
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,200)"); Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[3]")).click(); Thread.sleep(1000);
		Actions act = new Actions(wd); 
		WebElement c1 = wd.findElement(By.id("impressiveRadio"));
		act.doubleClick(c1).build().perform(); Thread.sleep(2000); 
	}

	@Test(priority = 3)  
	public void WebTables() throws InterruptedException,AWTException{ 
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,200)"); Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[4]")).click(); Thread.sleep(2000); 
		wd.findElement(By.id("addNewRecordButton")).click();
		Thread.sleep(2000); wd.findElement(By.id("firstName")).sendKeys("sathish");
		wd.findElement(By.id("lastName")).sendKeys("kumar");
		wd.findElement(By.id("userEmail")).sendKeys("sathish@gmail.com");
		wd.findElement(By.id("age")).sendKeys("27");
		wd.findElement(By.id("salary")).sendKeys("30000");
		wd.findElement(By.id("department")).sendKeys("SDET");
		js.executeScript("window.scrollBy(0,200)"); 
		WebElement d1 =	wd.findElement(By.xpath("//*[@id='submit']")); 
		Actions act = new Actions(wd);
		act.moveToElement(d1).click().build().perform();
		Thread.sleep(1000); 
		WebElement d2 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[7]/div/span[2]")); 
		act.moveToElement(d2).click().build().perform(); Thread.sleep(3000); 
	}

	@Test(priority = 4)  
	public void Buttons() throws InterruptedException, AWTException{ 
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,300)"); Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[5]")).click(); Thread.sleep(2000); 
		Actions act = new Actions(wd); 
		js.executeScript("window.scrollBy(0,100)");
		WebElement e1 =wd.findElement(By.id("doubleClickBtn"));
		act.doubleClick(e1).build().perform(); Thread.sleep(1000); 
		WebElement e2 = wd.findElement(By.id("rightClickBtn"));
		act.contextClick(e2).build().perform(); Thread.sleep(1000);
		WebElement e3 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/div[3]/button"));
		act.doubleClick(e3).build().perform(); Thread.sleep(1000);
		Thread.sleep(3000); 
	}

	@Test(priority = 5)  
	public void Links() throws InterruptedException, AWTException{ 
		Robot rc = new Robot(); 
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,400)");
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[6]")).click(); Thread.sleep(3000); 
		rc.keyPress(MenuKeyEvent.VK_DOWN);
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000); 
		Actions act = new Actions(wd); 
		WebElement f1 =wd.findElement(By.id("simpleLink"));
		act.moveToElement(f1).click().build().perform(); 
		rc.keyPress(MenuKeyEvent.VK_CONTROL); rc.keyPress(MenuKeyEvent.VK_TAB);
		rc.keyRelease(MenuKeyEvent.VK_CONTROL); rc.keyRelease(MenuKeyEvent.VK_TAB); Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[3]/a")).click(); Thread.sleep(2000); rc.keyPress(MenuKeyEvent.VK_DOWN);
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[4]/a")).click(); 
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[5]/a")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[6]/a")).click(); 
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[7]/a")).click();
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[8]/a")).click(); 
		Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/p[9]/a")).click(); 
		Thread.sleep(3000);
	}
	@Test(priority = 6)  
	public void UploadandDownload() throws InterruptedException, AWTException{ 
		JavascriptExecutor js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,400)");
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/div/ul/li[8]")).click(); Thread.sleep(3000);
		wd.findElement(By.id("downloadButton")).click(); Thread.sleep(3000);
		wd.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Admin\\Desktop\\python.txt"); Thread.sleep(3000);
	}		 

	@AfterTest
	public void afterTest() {

		wd.quit();

	}
}
