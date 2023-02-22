package mobiletesting1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class hybridtest extends capability {
	AndroidDriver<AndroidElement> driver;
	AndroidDriver<AndroidElement> driver1;
	AndroidDriver<AndroidElement> app1;
	AndroidDriver<AndroidElement> ban;
	@Test(enabled = false)
	public void test1() throws MalformedURLException, InterruptedException {
		driver1 = cap();                                // cap is method name in capability class
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_1")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_2")).click();
		driver1.findElement(MobileBy.AccessibilityId("plus")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_4")).click();
		driver1.findElement(MobileBy.id("com.android.calculator2:id/digit_6")).click();
		Thread.sleep(1000);
		driver1.findElement(MobileBy.AccessibilityId("equals")).click();
		driver1.findElement(MobileBy.AccessibilityId("clear")).click();
		driver1.navigate().back();
		
	}
	@Test(enabled = false)
	public void test2() throws InterruptedException, IOException {
		driver = generalstore();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();     // click to view country
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
//		driver.findElementByAndroidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(text(\"India\"))").click();
		                                                 // scroll down to view where located in India and click India
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("santra");
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();     // for clicking female option
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();     // click submit button
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))");
		                                                 // scroll down to view where located in product
		Thread.sleep(1000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		Thread.sleep(1000);                              // it will click the add to cart where it take from first option in that page
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD TO CART\")")).click();
		Thread.sleep(1000);
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();     //click cart
		Thread.sleep(1000);
		String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		System.out.println("price-1:"+price1);           //it will print the product price for first product
		price1 = price1.substring(1);                   // it will split and mention the string index 1 (here index 0 = $, index 1 = price)
		Double dprice1 = Double.parseDouble(price1);    //it will make the dprice1 String into double
		System.out.println(dprice1);
		String price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		System.out.println("Price-2:"+price2);                      //it will print the product price for first product
		price2 = price2.substring(1);                   // it will split and mention the string index 1 (here index 0 = $, index 1 = price)
		Double dprice2 = Double.parseDouble(price2);    // it will make the dprice1 String into double
		System.out.println(dprice2);
		String Totalprice = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("Totalprice:"+Totalprice);
		Totalprice = Totalprice.substring(2);
		Double dTotal = Double.parseDouble(Totalprice);
		System.out.println("dTotal:"+dTotal);
		Double addedtotal = dprice1 + dprice2;
		System.out.println("addedtotal:"+addedtotal);
		Assert.assertEquals(dTotal, addedtotal);
		if (dTotal.equals(addedtotal)) {
			System.out.println("Assertion pass");
		}
		else {
			System.out.println("Assertion fail");
		}
		driver.pressKey(new KeyEvent(AndroidKey.HOME));  //it will taken to the home screen
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));   //if it give two times, it will switch to another apps  
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    // take screenshot
		FileUtils.copyFile(scr, new File("C:\\Users\\Admin\\Pictures\\Screenshots\\screen.png"));
	}
	@Test(enabled = false)
	public void test3() throws MalformedURLException, InterruptedException {
		app1 = khanapp(); 
		app1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		AndroidElement a1 = app1.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sign in\")"));
		if (a1.isDisplayed()) {
			a1.click();
			app1.findElement(MobileBy.AccessibilityId("Continue with Google")).click();      Thread.sleep(1000);
			app1.findElement(MobileBy.id("com.google.android.gms:id/account_name")).click();    Thread.sleep(1000);
		}
		else {
			app1.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Join class\")")).click();   Thread.sleep(1000);
			app1.findElement(MobileBy.AccessibilityId("e.g. ABC123 or teacher@example.com")).sendKeys("sathishsd9298@gmail.com");    Thread.sleep(1000);
			app1.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ADD\")"));   Thread.sleep(1000);
		}
	}
	@Test(enabled = true)
	public void test4() throws MalformedURLException, InterruptedException {
		ban = Banjara(); 
		//Thread.sleep(4000);
		ban.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ban.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ENGLISH\")")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/edtMobileNumber")).sendKeys("8072553712"); Thread.sleep(1000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/imgNext")).click(); Thread.sleep(1000);
		//ban.findElement(MobileBy.id("com.forbinary.banjararide:id/imgNext")).click(); Thread.sleep(2000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/card_desc")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Hire Bike\")")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/txtItemLink")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/btnBookNow")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/rlDurationSpinner")).click();  Thread.sleep(1000);
		ban.findElements(MobileBy.className("android.widget.LinearLayout")).get(6).click(); Thread.sleep(2000);   // clicking 7days
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/llDateContainer")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.AccessibilityId("25 January 2023")).click(); Thread.sleep(1000);
		ban.findElement(MobileBy.id("android:id/button1")).click(); Thread.sleep(1000);
		ban.navigate().back(); Thread.sleep(1000);
		ban.navigate().back(); Thread.sleep(1000);
		ban.navigate().back(); Thread.sleep(1000); ban.navigate().back(); Thread.sleep(1000);
		ban.findElement(MobileBy.AccessibilityId("Open")).click(); Thread.sleep(1000);  // clicking menu bar
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/material_drawer_name")).click(); Thread.sleep(1000); //clicking bookings
		ban.findElement(MobileBy.AccessibilityId("Search")).click(); Thread.sleep(1000);   //clicking search button
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/search_src_text")).sendKeys("Activa"); Thread.sleep(1000);
		ban.findElement(MobileBy.AccessibilityId("Clear query")).click(); Thread.sleep(2000); // for clear text
		ban.navigate().back(); Thread.sleep(1000);
		ban.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))").click(); Thread.sleep(2000);
		ban.pressKey(new KeyEvent(AndroidKey.APP_SWITCH)); Thread.sleep(1000);  //if it give two times, it will switch to another apps  
		ban.pressKey(new KeyEvent(AndroidKey.APP_SWITCH)); Thread.sleep(1000);
		ban.findElement(MobileBy.AccessibilityId("Open")).click(); Thread.sleep(1000); // clicking menu bar
		ban.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Logout\"))").click(); Thread.sleep(2000);
		ban.navigate().back();
	}
}
