package datapakg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class data1 {
	WebDriver wd;
	public String URL="https://opensource-demo.orangehrmlive.com/";
	public String username1;
	public String password1;
	@BeforeTest
	public void BT() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.get(URL);
		Thread.sleep(3000);
	}
  @Test
  public void datadriven() throws IOException, InterruptedException {
	  
	  File excel =new File("C://Users//Akanksha//OneDrive//Desktop//orange.xlsx/");
	  FileInputStream fis = new FileInputStream(excel);
	  XSSFWorkbook book = new XSSFWorkbook(fis);
	  XSSFSheet sheet = book.getSheet("Sheet1");
	  
	  int rowcount = sheet.getLastRowNum();
	  
	  for(int i=0; i<=rowcount; i++) {
		
		  username1 = sheet.getRow(i).getCell(0).getStringCellValue();
		   password1 = sheet.getRow(i).getCell(1).getStringCellValue();
		 wd.findElement(By.name("username")).sendKeys(username1);
		 wd.findElement(By.name("password")).sendKeys(password1);
		 wd.findElement(By.xpath("//*[@type='submit']")).click();
		 Thread.sleep(3000);
		 
          if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
			 
			 wd.findElement(By.xpath("//*[@class=\'oxd-userdropdown-name\']")).click(); 
			 Thread.sleep(1000);
			  wd.findElement(By.linkText("Logout")).click();
			  Thread.sleep(3000);
			  
		 }
		 
          else if(wd.findElement(By.xpath("//*[@class='oxd-alert-content oxd-alert-content--error']")).isDisplayed()) {
			 for(int j=i+1; j<=rowcount; j++) {
				 String username2 = sheet.getRow(j).getCell(0).getStringCellValue();
				 String password2 = sheet.getRow(j).getCell(1).getStringCellValue(); 
				 
				 wd.findElement(By.name("username")).sendKeys(username2);
				 wd.findElement(By.name("password")).sendKeys(password2);
				 
				 wd.findElement(By.xpath("//*[@type='submit']")).click(); 
				 Thread.sleep(3000);
			 
			 if(wd.getCurrentUrl().equalsIgnoreCase("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
				 
				 wd.findElement(By.xpath("//*[@class=\'oxd-userdropdown-name\']")).click(); 
				 Thread.sleep(1000);
				  wd.findElement(By.linkText("Logout")).click();
				  Thread.sleep(3000);
				  
			 }
		 }
			break; // it will end the loop
		 }
	  } 
book.close();
} 
}
