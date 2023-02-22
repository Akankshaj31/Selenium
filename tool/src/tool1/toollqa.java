package tool1;

public class toollqa {
	

		public static void main(String[] args) throws InterruptedException, AWTException {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver wd = new ChromeDriver();
			Actions act=new Actions(wd);
			Robot rb=new Robot();
			 wd.manage().window().maximize();
			wd.navigate().to("https://demoqa.com/elements");
			//rb.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(1000);
			
	 //Check Box
		wd.findElement(By.xpath("(//*[@class='element-list collapse show']/ul/li[2])")).click();
		wd.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])")).click();
		Thread.sleep(1000);
		
		


}
