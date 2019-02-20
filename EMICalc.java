package Appium;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;

public class EMICalc
{
	public static void main(String[] args)
	{
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		
		capabilities.setCapability("deviceName", "MotoG");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability(CapabilityType.VERSION, "5.1");		
		capabilities.setCapability("app", "D:/2_STUDY & WORK/2_SK/EmiCalcAssignment/emicalculator.apk");
		capabilities.setCapability("udid", "TA93303EEK");	
		
		try{
			AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
						
			driver.findElement(By.id("net.emicalculator:id/loanAmountTextView")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("net.emicalculator:id/loanAmountEditText")).clear();
			driver.findElement(By.id("net.emicalculator:id/loanAmountEditText")).sendKeys("2000");
			driver.findElement(By.id("net.emicalculator:id/continueButton")).click();
			
			driver.findElement(By.id("net.emicalculator:id/loanInterestEditText")).clear();
			driver.findElement(By.id("net.emicalculator:id/loanInterestEditText")).sendKeys("10");
			driver.findElement(By.id("net.emicalculator:id/continueButton")).click();
			
			driver.findElement(By.id("net.emicalculator:id/loanTenureEditText")).clear();
			driver.findElement(By.id("net.emicalculator:id/loanTenureEditText")).click();
			driver.findElement(By.id("net.emicalculator:id/loanTenureEditText")).sendKeys("1");
			
			driver.findElement(By.id("net.emicalculator:id/doneButton")).click();
			
			driver.findElement(By.id("net.emicalculator:id/textView5")).click();			
			
			String value = driver.findElement(By.id("net.emicalculator:id/emiTextView")).getText();
			System.out.print(value);
			
			//Assert.assertEquals(value, "176");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}