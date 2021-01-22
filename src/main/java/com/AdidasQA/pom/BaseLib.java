package com.AdidasQA.pom;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	public static WebDriver driver=null;
	
	@BeforeMethod	
	public void setUpWeb() throws MalformedURLException 
	{	
		String demoblazeURL="https://www.demoblaze.com/index.html";
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();

		System.out.println("Launching Chrome Driver..!");
		System.setProperty("webdriver.chrome.driver", "./exefile/chromedriver.exe");
		driver = new ChromeDriver(desiredCapabilities);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(demoblazeURL);

	}
	
	@AfterMethod
	public void window_close() {
        driver.quit();
    }

}
