package rahulshetty01;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.swing.event.MenuKeyEvent;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {
	WebDriver wd;
	JavascriptExecutor js;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		Thread.sleep(3000);	
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 0)
	public void radiobutton() throws InterruptedException {
		String title = wd.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Practice Page");
		WebElement RD1 = wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]"));
		RD1.click(); Thread.sleep(2000);
		WebElement RD2 = wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[2]/input[1]"));
		RD2.click(); Thread.sleep(2000);
		WebElement RD3 = wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[3]/input[1]"));
		RD3.click(); Thread.sleep(2000);
		if (RD1.isSelected()) {
			System.out.println("Radio button 1 is selected");
		} 
		else if (RD2.isSelected()){
			System.out.println("Radio button 2 is selected");
		}
		else {
			System.out.println("Radio button 3 is selected");
		}
		
	}
	@Test(enabled = false)
	public void autosugg() throws InterruptedException, AWTException {
		Robot rc = new Robot();
		wd.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind"); Thread.sleep(2000);
		rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER);

	}
	@Test(enabled = false)
	public void dropdown() throws InterruptedException, AWTException {
		Robot rc = new Robot();
		wd.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER);
	}
	@Test(enabled = false)
	public void checkbox() throws InterruptedException, AWTException {
		wd.findElement(By.xpath("//input[@id='checkBoxOption1']")).click(); Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@id='checkBoxOption2']")).click(); Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@id='checkBoxOption3']")).click(); Thread.sleep(2000);
	}
	@Test(enabled = false)
	public void openwindow() throws InterruptedException, AWTException {

		for (int i = 0; i <1; i++) {
			wd.findElement(By.xpath("//button[@id='openwindow']")).click();
		} 
		Thread.sleep(2000);
		String parentwindow = wd.getWindowHandle();
		System.out.println(parentwindow);
		Set<String> allwindow = wd.getWindowHandles();
		System.out.println(allwindow);
		String lastwindow = "";

		for(String handle : allwindow) {
			wd.switchTo().window(handle);
			lastwindow = handle;
		}
		Thread.sleep(3000);
		wd.switchTo().window(lastwindow);
		wd.close();
		wd.switchTo().window(parentwindow);
	}
	@Test(enabled = false)
	public void opentab() throws InterruptedException, AWTException {
		wd.findElement(By.xpath("//a[@id='opentab']")).click();
		Robot rc = new Robot();
		rc.keyPress(MenuKeyEvent.VK_CONTROL); rc.keyPress(MenuKeyEvent.VK_TAB);
		rc.keyRelease(MenuKeyEvent.VK_CONTROL); rc.keyRelease(MenuKeyEvent.VK_TAB);
	}
	@Test(enabled = false)
	public void alerts() throws InterruptedException, AWTException {
		wd.findElement(By.xpath("//input[@id='name']")).sendKeys("sathish"); Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='alertbtn']")).click();
		Alert alt = wd.switchTo().alert();
		Thread.sleep(1000);
		alt.accept(); Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='name']")).sendKeys("sathish"); Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		Thread.sleep(1000);
		alt.accept(); Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void hideshow() throws InterruptedException, AWTException {
		wd.findElement(By.xpath("//input[@id='hide-textbox']")).click(); Thread.sleep(1000);
		wd.findElement(By.xpath("//input[@id='show-textbox']")).click(); Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void scroll() throws InterruptedException, AWTException {
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void Mouse_hover() throws InterruptedException, AWTException {
		Robot rc = new Robot();
		rc.keyPress(MenuKeyEvent.VK_SPACE);
		Thread.sleep(1000);
		Actions act = new Actions(wd);
		WebElement a1 = wd.findElement(By.xpath("//button[@id='mousehover']"));
		act.moveToElement(a1).build().perform();
		Thread.sleep(3000);
	}
	@Test(enabled = false)
	public void frames() throws InterruptedException, AWTException {
		js = (JavascriptExecutor)wd;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(2000);
		wd.switchTo().frame(0);         // this is used to switch the frames one to another
		js.executeScript("window.scrollBy(0,600)"); Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-600)"); Thread.sleep(2000);
		wd.switchTo().defaultContent();     // this is used to come back from frame to very first page
		js.executeScript("window.scrollBy(0,-100)");
	}
}
