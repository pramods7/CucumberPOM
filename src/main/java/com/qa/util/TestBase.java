package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class TestBase {

	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream ("E:\\Software\\New Eclipse\\Cucumber_BDD Framework\\eclipse\\CucumberPOM\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public static void initialization(){
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Software\\New Eclipse\\Cucumber_BDD Framework\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browsername.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\Software\\New Eclipse\\NewFrameworkProject\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
			
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	
	
	}

	public static void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	
	
}
