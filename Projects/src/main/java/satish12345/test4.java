package satish12345;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test4 {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://demoqa.com/");
		Thread.sleep(3000);
		 Robot rc = new Robot();
		 rc.keyPress(MenuKeyEvent.VK_SPACE);
		 Thread.sleep(2000);
		 WebElement we1 = wd.findElement(By.xpath("//*[@class='home-body']/div/div[1]"));
			we1.click();
			Thread.sleep(2000);
		WebElement we2 = wd.findElement(By.xpath("//*[@class='accordion']/div[1]/span/div/div[2]/div[2]"));
			 we2.click();
			Thread.sleep(2000); 
			WebElement we3 = wd.findElement(By.xpath("//*[@class='accordion']/div[3]/span/div/div[2]/div[2]"));
			 we3.click();
			 rc.keyPress(MenuKeyEvent.VK_SPACE);
			 rc.keyRelease(MenuKeyEvent.VK_SPACE);
			 Thread.sleep(2000);
			 WebElement we4 = wd.findElement(By.xpath("//*[@class='accordion']/div[3]/div/ul/li[2]"));
			 we4.click();
			 Thread.sleep(2000);
			 WebElement we5 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/div[1]/div[2]/button"));
			 we5.click();
			 Thread.sleep(2000);
			 rc.keyPress(MenuKeyEvent.VK_ENTER);
			 Thread.sleep(4000);
			 WebElement we7 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/div[2]/div[2]/button"));
			 we7.click();
			 Thread.sleep(7000);
			 rc.keyPress(MenuKeyEvent.VK_ENTER);
			 Thread.sleep(3000);
			 WebElement we6 = wd.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']/div[2]/div[3]/div[2]/button"));
			 we6.click();
			 Thread.sleep(3000);
			 rc.keyPress(MenuKeyEvent.VK_ENTER);			 
			 Thread.sleep(4000);
			 wd.close();
	}
}
