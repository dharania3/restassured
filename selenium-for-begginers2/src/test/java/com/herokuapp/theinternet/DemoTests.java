package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTests {
	public class roTests {

		@Test
		public void loginTest() throws InterruptedException {
			System.out.println("Starting loginTest");

//			Create driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			WebDriver driver = new ChromeDriver();


			// maximize browser window
			driver.manage().window().maximize();

//			System.out.println("Opening Website.....");
			driver.get("https://demoqa.com/alerts");

			
			WebElement bt1 = driver.findElement(By.id("timerAlertButton"));
			bt1.click();
			Thread.sleep(5500);
//			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.switchTo().alert().accept();
			driver.close();
	}}}


