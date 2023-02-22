package rahulshetty1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class task1 {
 

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
			
		  @Test(enabled = true)
		  public void radiobutton() throws InterruptedException {
			  wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[1]/input[1]")).click(); Thread.sleep(2000);
			  wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[2]/input[1]")).click(); Thread.sleep(2000);
			  wd.findElement(By.xpath("//body/div[1]/div[1]/fieldset[1]/label[3]/input[1]")).click(); Thread.sleep(2000);
			 
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
			  wd.findElement(By.xpath("//input[@id='name']")).sendKeys("Akki"); Thread.sleep(1000);
			  wd.findElement(By.xpath("//input[@id='alertbtn']")).click();
			  Alert alt = wd.switchTo().alert();
			  Thread.sleep(1000);
			  alt.accept(); Thread.sleep(1000);
			  wd.findElement(By.xpath("//input[@id='name']")).sendKeys("Akki"); Thread.sleep(1000);
			  wd.findElement(By.xpath("//input[@id='confirmbtn']")).click();
			  Thread.sleep(1000);
			  alt.accept(); Thread.sleep(1000);
		  }
		  @Test(enabled = false)
		  public void hideshow() throws InterruptedException, AWTException {
			  wd.findElement(By.xpath("//input[@id='hide-textbox']")).click(); Thread.sleep(1000);
			  wd.findElement(By.xpath("//input[@id='show-textbox']")).click(); Thread.sleep(1000);
		  }
		  @Test(enabled = false)
		  public void scroll() throws InterruptedException, AWTException {
			  js = (JavascriptExecutor)wd;
		      js.executeScript("window.scrollBy(0,200)");
		      Thread.sleep(3000);
		  
		  
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	}
  }
}
