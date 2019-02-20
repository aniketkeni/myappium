package Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class MobileApp
{
	public static void main(String[] args)
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability("deviceName", "MotoG2");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability(CapabilityType.VERSION, "5.0");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		capabilities.setCapability("app", "D:/4_NEW/AndroidCalculator.apk");
		capabilities.setCapability("udid", "TA93303EEK");
						
		try {
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			driver.findElement(By.id("com.android2.calculator3:id/cling_dismiss")).click();
			
			driver.findElement(By.id("com.android2.calculator3:id/digit3")).click();
			
			//driver.findElement(By.id("com.android2.calculator3:id/plus")).click();  //addition
			//driver.findElement(By.id("com.android2.calculator3:id/minus")).click(); //subtraction
			//driver.findElement(By.id("com.android2.calculator3:id/mul")).click();	 //multiplication
			driver.findElement(By.id("com.android2.calculator3:id/div")).click();  //division
			
			driver.findElement(By.id("com.android2.calculator3:id/digit1")).click();			
			driver.findElement(By.id("com.android2.calculator3:id/equal")).click();
			
			String res = driver.findElement(By.className("android.widget.EditText")).getText();
			Assert.assertEquals(res, "3");
			
//			.//android.widget.Button[@text='OK']
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

}
