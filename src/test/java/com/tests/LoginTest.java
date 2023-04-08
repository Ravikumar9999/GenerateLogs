package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	//What is log? : capturing info/activities at the time of program execution
	//types of logs
	    //1. info
	    //2. war
	    //3. error
	    //4. fatal
	
	//how to generate the logs? use Apache log4j API (log4j jars)
	//How it works? it reads log 4j configuration from log4j.properties file
	//where to create: create inside resources folder
	
	
	WebDriver driver;
	Logger log = Logger.getLogger(LoginTest.class);
	
	
	@BeforeMethod
	public void setUp() {
		
		log.info("****************************** Starting test cases execution  *****************************************");

		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		log.info("launching chrome broswer");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://classic.freecrm.com/");	
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}

	
	@Test(priority=1)
	public void freeCrmTitleTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		log.info("login page title is--->"+title);
		
		Assert.assertEquals(title, "Free CRM - CRM software for customer relationship management, sales, and support.");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		
	}
	
	
	@Test
	public void freeCRMLogoTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		
		boolean b =driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		
	}
	
	
	
	
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		
		log.info("****************************** Browser is closed *****************************************");
		
		driver.quit();
	}
}
