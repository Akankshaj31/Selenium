public class checkbox {

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
	
 //Radio Button
	wd.navigate().to("https://demoqa.com/radio-button");
//	wd.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
	WebElement wd1=wd.findElement(By.xpath("(//*[@class='custom-control-label'])[1]"));
	wd1.click();
	Thread.sleep(2000);
	
//Buttons
	rb.keyPress(KeyEvent.VK_PAGE_DOWN);
	wd.navigate().to("https://demoqa.com/buttons");
	Thread.sleep(3000);
	WebElement A=wd.findElement(By.id("doubleClickBtn"));
	act.doubleClick(A).build().perform();
	Thread.sleep(2000);
	WebElement B=wd.findElement(By.id("rightClickBtn"));
	act.contextClick(B).build().perform();
	Thread.sleep(2000);
	wd.findElement(By.xpath("(//*[@class='col-12 mt-4 col-md-6']/div[2]/div[3]/button)")).click();
	Thread.sleep(2000);
 //Links
	wd.navigate().to("https://demoqa.com/links");
	Thread.sleep(2000);
	wd.findElement(By.id("simpleLink")).click();
	Thread.sleep(2000);
	rb.keyPress(KeyEvent.VK_CONTROL);
	rb.keyPress(KeyEvent.VK_TAB);
	Thread.sleep(2000);
		
}

}