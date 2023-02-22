package rahulshetty1;
public class test123 
{
	package rahulshetty01;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.util.List;
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
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class test1 {
		WebDriver  wb;
		JavascriptExecutor js;
		
		@BeforeTest
		public void beforeTest() throws InterruptedException {
			WebDriver.chromedriver.setup();
		wb = new chromedriver();
			wb.manage().window().maximize();
			wb.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
			Thread.sleep(3000);	
			wb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
	  @Test(enabled = false)
	  public void radiobutton() throws InterruptedException {
		  wb.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).click(); Thread.sleep(2000);
		  wb.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[2]/input[1]")).click(); Thread.sleep(2000);
		  wb.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[3]/input[1]")).click(); Thread.sleep(2000);
		 
	  }
	  @Test(enabled = false)
	  public void autosugg() throws InterruptedException, AWTException {
		  Robot rc = new Robot();
		  wb.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("ind"); Thread.sleep(2000);
		  rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER);
		 
	  }
	  @Test(enabled = false)
	  public void dropdown() throws InterruptedException, AWTException {
		  Robot rc = new Robot();
		  wb.findElement(By.xpath("//select[@id='dropdown-class-example']")).click();
		  rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_DOWN); rc.keyPress(MenuKeyEvent.VK_ENTER);
	  }
	  @Test(enabled = false)
	  public void checkbox() throws InterruptedException, AWTException {
		  wb.findElement(By.xpath("//input[@id='checkBoxOption1']")).click(); Thread.sleep(2000);
		  wb.findElement(By.xpath("//input[@id='checkBoxOption2']")).click(); Thread.sleep(2000);
		  wb.findElement(By.xpath("//input[@id='checkBoxOption3']")).click(); Thread.sleep(2000);
	  }
	  @Test(enabled = false)
	  public void openwindow() throws InterruptedException, AWTException {
		
		 for (int i = 0; i <1; i++) {
			 wb.findElement(By.xpath("//button[@id='openwindow']")).click();
			  }
			  Thread.sleep(2000);
			  String parentwindow = wd.getWindowHandle();
			  System.out.println(parentwindow);
			  Set<String> allwindow = wd.getWindowHandles();
			  System.out.println(allwindow);
			  String lastwindow = "";
			 
			 for(String handle : allwindow) {
				 wb.switchTo().window(handle);
				 lastwindow = handle;
			 }
			 Thread.sleep(3000);
			 wb.switchTo().window(lastwindow);
			 wb.close();
			 wb.switchTo().window(parentwindow);
	  }
	  @Test(enabled = false)
	  public void opentab() throws InterruptedException, AWTException {
		  wb.findElement(By.xpath("//a[@id='opentab']")).click();
		  Robot rc = new Robot();
		  rc.keyPress(MenuKeyEvent.VK_CONTROL); rc.keyPress(MenuKeyEvent.VK_TAB);
		  rc.keyRelease(MenuKeyEvent.VK_CONTROL); rc.keyRelease(MenuKeyEvent.VK_TAB);
	  }
	  @Test(enabled = false)
	  public void alerts() throws InterruptedException, AWTException {
		  wb.findElement(By.xpath("//input[@id='name']")).sendKeys("sathish"); Thread.sleep(1000);
		  wb.findElement(By.xpath("//input[@id='alertbtn']")).click();
		  Alert alt = wb.switchTo().alert();
		  Thread.sleep(1000);
		  alt.accept(); Thread.sleep(1000);
		  wb.findElement(By.xpath("//input[@id='name']")).sendKeys("sathish"); Thread.sleep(1000);
		  wb.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		  Thread.sleep(1000);
		  alt.accept(); Thread.sleep(1000);
	  }
	  @Test(enabled = false)
	  public void hideshow() throws InterruptedException, AWTException {
		  wb.findElement(By.xpath("//input[@id='hide-textbox']")).click(); Thread.sleep(1000);
		  wb.findElement(By.xpath("//input[@id='show-textbox']")).click(); Thread.sleep(1000);
	  }
	  @Test(enabled = false)
	  public void scroll() throws InterruptedException, AWTException {
		  js = (JavascriptExecutor)wb;
	      js.executeScript("window.scrollBy(0,200)");
	      Thread.sleep(3000);
	  }
	
}
@Test(enabled = true)
public void Mouse_hover() throws InterruptedException, AWTException {
Robot rc = new Robot();
rc.keyPress(MenuKeyEvent.VK_SPACE); rc.keyPress(MenuKeyEvent.VK_SPACE);
Thread.sleep(1000);
Actions act = new Actions(wd);
WebElement a1 = wd.findElement(By.xpath("//button[@id='mousehover']"));
act.moveToElement(a1).build().perform();
}
