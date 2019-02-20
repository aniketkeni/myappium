package Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class ExistingApp
{
	public static void main(String[] args)
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability("deviceName", "MotoG");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability(CapabilityType.VERSION, "5.1");
		
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");	//for web
		
		//capabilities.setCapability("app","D:/4_NEW/AndroidCalculator.apk");	//for app
		
		capabilities.setCapability("apppackage", "com.whatsapp");	//for existing app
		capabilities.setCapability("appActivity", "com.whatsapp.Main");	//for existing app
		
		capabilities.setCapability("udid", "TA93303EEK");	
		
		try{
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			
			//driver.get("http://m.facebook.com");
			
			driver.findElement(By.xpath("//android.widget.TextView[@text='Aai']")).click();
			driver.findElement(By.id("com.whatsapp:id/entry")).sendKeys("how are you");
			driver.findElement(By.id("com.whatsapp:id/send")).click();
						
			driver.findElement(By.name("email")).sendKeys("sameer");
			driver.findElement(By.name("pass")).sendKeys("sameer");
			driver.findElement(By.name("login")).click();
			
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
}