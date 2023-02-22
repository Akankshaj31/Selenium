package satish12345;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class demoqa {
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://demoqa.com/");
		Thread.sleep(3000);
		 Robot rc = new Robot();
		 rc.keyPress(MenuKeyEvent.VK_SPACE);
		 Thread.sleep(2000);
		 wd.findElement(By.xpath("//*[@class='home-body']/div/div[1]")).click();
			Thread.sleep(2000);
		wd.findElement(By.xpath("//*[@class='accordion']/div[1]/span/div/div[2]/div[2]")).click();
			Thread.sleep(2000); 
			 rc.keyPress(MenuKeyEvent.VK_SPACE);
			 Thread.sleep(2000);
			wd.findElement(By.xpath("//*[@class='accordion']/div[5]/span/div/div[2]/div[2]")).click();
			Thread.sleep(2000);
			 rc.keyPress(MenuKeyEvent.VK_SPACE);
			Thread.sleep(2000);
			wd.findElement(By.xpath("//*[@class='accordion']/div[5]/div/ul/li[4]")).click();
			Thread.sleep(2000);
			WebElement w1 = wd.findElement(By.id("draggable"));
			WebElement w2 = wd.findElement(By.id("droppable"));
			Actions act = new Actions(wd);
			act.dragAndDrop(w1, w2).build().perform();
			Thread.sleep(2000);

}
}