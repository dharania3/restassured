package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementnoTest {


@Test
public void elementvisTest() {
	System.out.println("Starting loginTest");

//	Create driver
	System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();


	// maximize browser window
	driver.manage().window().maximize();

//	open test page
	String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
	driver.get(url);
	System.out.println("Page is opened.");

//	enter username
	WebElement bts = driver.findElement(By.xpath("//div[@id='start']/button"));
	bts.click();


//	verifications:

//	 logout button is visible
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement msg = driver.findElement(By.xpath("//div[@id='finish']/h4"));
	//WebDriverWait wait = new WebDriverWait(driver,10);
	//wait.until(ExpectedConditions.visibilityOf(msg));
	String amsg = msg.getText();
	Assert.assertTrue(amsg.contains("Hello World!"),"not run successful");

	// Close browser
	driver.quit();
}}