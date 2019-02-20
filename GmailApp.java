package Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class GmailApp
{
	public static void main(String[] args)
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability("deviceName", "MotoG");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability(CapabilityType.VERSION, "5.1");
		
		capabilities.setCapability("appPackage", "com.google.android.gm");	//for existing app
		capabilities.setCapability("appActivity", "com.google.android.gm.ConversationListActivityGmail");	//for existing app
		
		capabilities.setCapability("udid", "TA93303EEK");	
		
		try{
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			
			//driver.get("http://m.facebook.com");
			//driver.findElement(By.xpath("//android.widget.TextView[@text='Gmail']")).click();
			//driver.findElement(By.id("com.android.launcher:id/preview_background")).click();
			//driver.findElement(By.id("com.android.launcher:text/Gmail")).click();
			
			driver.findElement(By.id("com.google.android.gm:id/compose_button")).click();
			driver.findElement(By.id("com.google.android.gm:id/subject")).sendKeys("test mail through Appium");
			driver.findElement(By.id("com.google.android.gm:id/body")).sendKeys("Hello Shashank, sending you a mail through Appium");
			driver.findElement(By.id("com.google.android.gm:id/to")).sendKeys("shashank.kulkarni@sk-solutions.in");
			Thread.sleep(3000);
			driver.findElement(By.id("com.google.android.gm:id/send")).click();
			driver.findElement(By.id("android:id/button1")).click();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}