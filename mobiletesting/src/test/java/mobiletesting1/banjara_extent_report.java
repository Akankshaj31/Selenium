package mobiletesting1;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class banjara_extent_report extends BanjaraRide {
	ExtentReports extent;
	AndroidDriver<AndroidElement> ban;

	@BeforeTest
	public void bt() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Admin\\eclipse-workspace\\mobiletesting\\test-output\\reports1.html");
		extent.attachReporter(spark);
		
	}
	@Test(priority = 0)
	public void Login() throws InterruptedException, IOException {
		ban = Banjara(); 
		ExtentTest test1 = extent.createTest("Test1");	
		
		ban.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ENGLISH\")")).click(); Thread.sleep(1000);
		test1.pass("language selected");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/edtMobileNumber")).sendKeys("8072553712"); Thread.sleep(1000);
		test1.pass("Mobile number entered");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/imgNext")).click(); Thread.sleep(1000);
		test1.log(Status.PASS, "Login success");
	}
	@Test(priority = 1)
	public void Select_Ride() throws InterruptedException, IOException {
		ExtentTest test2 = extent.createTest("Test2");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/card_desc")).click(); Thread.sleep(1000);
		test2.pass("BookNow selected");
		
		ban.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Hire Bike\")")).click(); Thread.sleep(1000);
		test2.pass("Hire Bike selected");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/txtItemLink")).click(); Thread.sleep(1000);
		test2.pass("Bike selected");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/btnBookNow")).click(); Thread.sleep(1000);
		test2.pass("BookNow clicked");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/rlDurationSpinner")).click();  Thread.sleep(1000);
		
		ban.findElements(MobileBy.className("android.widget.LinearLayout")).get(6).click(); Thread.sleep(2000);   // clicking 7days
		test2.pass("Duration selected for 7days");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/llDateContainer")).click(); Thread.sleep(1000);
		
		ban.findElement(MobileBy.AccessibilityId("02 February 2023")).click(); Thread.sleep(1000);
		
		ban.findElement(MobileBy.id("android:id/button1")).click(); Thread.sleep(2000);
		test2.pass("Date selected");
		
		ban.navigate().back(); Thread.sleep(1000);
		ban.navigate().back(); Thread.sleep(1000);
		ban.navigate().back(); Thread.sleep(1000); 
		test2.pass("Back to Main page");
	}
	@Test(priority = 2)
	public void Search_option() throws InterruptedException, IOException {
		ExtentTest test3 = extent.createTest("Test3");
		ban.findElement(MobileBy.AccessibilityId("Open")).click(); Thread.sleep(1000);  // clicking menu bar
		test3.pass("Menu button clicked");
		
		ban.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bookings\"))").click(); Thread.sleep(1000); //click bookings
		test3.pass("Booking option clicked");
		
		ban.findElement(MobileBy.AccessibilityId("Search")).click(); Thread.sleep(1000);   //clicking search button
		test3.pass("Search option clicked");
		
		ban.findElement(MobileBy.id("com.forbinary.banjararide:id/search_src_text")).sendKeys("Activa"); Thread.sleep(1000);
		test3.pass("Name Activa typed in search bar");
		
		ban.findElement(MobileBy.AccessibilityId("Clear query")).click(); Thread.sleep(2000); // for clear text
		test3.pass("Clear button clicked");
		
		ban.navigate().back(); Thread.sleep(2000);
		test3.pass("Back to Main page");
	}
	@Test(priority = 3)
	public void Call_option() throws InterruptedException, IOException {
		ExtentTest test4 = extent.createTest("Test4");
		
		ban.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Call Us\"))").click(); Thread.sleep(2000);
		test4.pass("Scroll and Call Us button clicked");
		test4.pass("Redirected to Dailler");
		
		ban.pressKey(new KeyEvent(AndroidKey.APP_SWITCH)); Thread.sleep(1000);  //if it give two times, it will switch to another apps  
		ban.pressKey(new KeyEvent(AndroidKey.APP_SWITCH)); Thread.sleep(1000);
		test4.pass("Back to BanjaraRide page");
		
		ban.findElement(MobileBy.AccessibilityId("Open")).click(); Thread.sleep(1000); // clicking menu bar
		test4.pass("Going to Menu");
		
		ban.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Logout\"))").click(); Thread.sleep(2000);
		test4.pass("Clicked on Logout");
		
		ban.navigate().back();
		test4.pass("Back to Home");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("C:\\Users\\Admin\\eclipse-workspace\\mobiletesting\\test-output\\reports1.html").toURI());
	}
}
