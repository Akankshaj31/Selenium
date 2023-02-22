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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Formspage {
	WebDriver wd;
	JavascriptExecutor js;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://demoqa.com/forms");
		Thread.sleep(3000);	
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@Test
	public void Practiceforms() throws InterruptedException, AWTException{
		Robot rc = new Robot();
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,200)");
		wd.findElement(By.xpath("//*[@class='accordion']/div[2]/div/ul/li[1]")).click();
		Thread.sleep(1000);  js.executeScript("window.scrollBy(0,200)"); Thread.sleep(1000);
		wd.findElement(By.id("firstName")).sendKeys("sathish"); Thread.sleep(1000);
		wd.findElement(By.id("lastName")).sendKeys("kumar"); Thread.sleep(1000);
		wd.findElement(By.id("userEmail")).sendKeys("sathish@gmail.com"); Thread.sleep(2000); Actions act = new Actions(wd);
		WebElement z1 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/form/div[3]/div[2]/div[1]/input")); 
		act.moveToElement(z1).click().build().perform();  Thread.sleep(2000);
		wd.findElement(By.id("userNumber")).sendKeys("8071553712"); Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/form/div[5]/div[2]/div[1]/div/input")).click(); Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[1]/div[2]/div[2]/select/option[93]")).click(); Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[1]/div[2]/div[1]/select/option[8]")).click(); Thread.sleep(1000);
		wd.findElement(By.xpath("//*[@class='react-datepicker']/div[2]/div[2]/div[4]/div[1]")).click(); Thread.sleep(2000);
		rc.keyPress(MenuKeyEvent.VK_DOWN); Thread.sleep(2000);
//		wd.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[6]/div[2]/div[1]/div[1]/div[1]")).sendKeys("software");
//		Thread.sleep(2000);
		wd.findElement(By.xpath("//label[contains(text(),'Music')]")).click(); Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("C:\\Users\\Admin\\Desktop\\already responded.png");
		Thread.sleep(2000);
		wd.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("COIMBATORE,TAMILNADU"); Thread.sleep(2000);
		rc.keyPress(MenuKeyEvent.VK_SPACE);
//		wd.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[10]/div[2]/div[1]/div[1]/div[2]/div[1]/*[1]")).click();
//		Thread.sleep(2000);
//		rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER); Thread.sleep(1000);
//		wd.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[10]/div[3]/div[1]/div[1]/div[2]/div[1]/*[1]")).click();
//		Thread.sleep(1000);
//		rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER); Thread.sleep(1000);
//		wd.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(3000);
	}
	@AfterTest
	public void afterTest() {
		wd.close();
	}
}
