package Appium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesktopWeb
{
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("www.facebook.com");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}