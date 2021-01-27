package com.acti.base;  //VIDEO 40

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


/*Name: Meghana
 * Date created: 01/20/2020
 * Date modified:
 * Approved: Meghana
 * E-mail:
 */

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public DriverScript() 
	{
		try
		{
			File file = new File("/Users/meghanaghosh/Desktop/MY-DEC2020 WORKSPACE/com.qa.actitime/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		
		catch(Exception e)
		{
			System.out.println("Unable to load the Properties File "+e.getMessage());
		}
		
	}
		
		//Method to launch a browser
		
		//@Test  //Once you done with unit testing, ensure to remove @Test annonation, else it will open dual browsers
		public static void initBrowser()
		{
			String browser = prop.getProperty("browser"); //browser key is coming from config.properties file
			
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "/Users/meghanaghosh/Downloads/chromedriver");
				driver=new ChromeDriver();
			}
			
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.chrome.driver", "/Users/meghanaghosh/Downloads/geckodriver");
				driver=new FirefoxDriver();
			}
			else
			{
				System.out.println("No Browser specified properly");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			
			String url = prop.getProperty("url"); // the key qa url is from config.properties file
			driver.get(url);
		}
	}
	
	

