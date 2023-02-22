package newdemo1;

public class javaclass {
	WebDriver wd;
	 @BeforeTest
	  public void beforeTest() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","C:\\selenium-java-4.7.0\\chromedriver.exe");
			wd = new ChromeDriver();
			wd.navigate().to("https://opensource-demo.orangehrmlive.com");
			Thread.sleep(3000);
	  }
 @Test(priority = 0)
 public void login() throws InterruptedException {
	  wd.findElement(By.name("username")).sendKeys("Admin");
		wd.findElement(By.name("password")).sendKeys("admin123");
		wd.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\']")).click();
		Thread.sleep(3000);
	  }
 @Test(priority = 1)
 public void homepage() throws InterruptedException {
	  wd.findElement(By.linkText("Admin")).click();
		Thread.sleep(3000);
	 wd.findElement(By.linkText("PIM")).click();
		Thread.sleep(3000);
		wd.findElement(By.xpath("//*[@class=\'oxd-button oxd-button--medium oxd-button--secondary\']")).click();
		Thread.sleep(3000);
 }
 @Test(priority = 2)
 public void logout() throws InterruptedException {
	  wd.findElement(By.xpath("//*[@class=\'oxd-userdropdown-name\']")).click();
	  Thread.sleep(1000);
	  wd.findElement(By.linkText("Logout")).click();
	  Thread.sleep(3000);
 }
 @AfterTest
 public void afterTest() {
	  wd.close();
 }
}
	

}
