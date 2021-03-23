package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegetiveTests {
	
	@Parameters({ "us","ps","msg" })
	@Test(priority = 1 ,groups = { "negetive", "smoketest" })
	public void incorrectUsernameTest(String usname,String pass,String xmsg) {
		System.out.println("Starting incorrectUsernameTest");

//		Create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// maximize browser window
		driver.manage().window().maximize();

//		open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened.");

//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys(usname);
		

//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);

//		click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();


		// Verifications
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String actualErrorMessage = errorMessage.getText();

		Assert.assertTrue(actualErrorMessage.contains(xmsg),
				"Actual error message does not contain expected. \nActual: " 
						+ actualErrorMessage + "\nExpected: "
						+ xmsg);
		
		// Close browser
		driver.quit();
	}

	/*
	 * @Test(priority = 2,groups = { "smoke" }) public void incorrectPasswordTest()
	 * { System.out.println("Starting incorrectPasswordTest");
	 * 
	 * // Create driver System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver();
	 * 
	 * // sleep for 3 seconds
	 * 
	 * // maximize browser window driver.manage().window().maximize();
	 * 
	 * // open test page String url = "http://the-internet.herokuapp.com/login";
	 * driver.get(url); System.out.println("Page is opened.");
	 * 
	 * // enter username WebElement username =
	 * driver.findElement(By.id("username")); username.sendKeys("tomsmith");
	 * 
	 * 
	 * // enter password WebElement password =
	 * driver.findElement(By.name("password"));
	 * password.sendKeys("incorrectPassword!");
	 * 
	 * // click login button WebElement logInButton =
	 * driver.findElement(By.tagName("button")); logInButton.click();
	 * 
	 * 
	 * // Verifications WebElement errorMessage =
	 * driver.findElement(By.id("flash")); String expectedErrorMessage =
	 * "Your password is invalid!"; String actualErrorMessage =
	 * errorMessage.getText();
	 * 
	 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
	 * "Actual error message does not contain expected. \nActual: " +
	 * actualErrorMessage + "\nExpected: " + expectedErrorMessage);
	 * 
	 * // Close browser driver.quit(); }
	 */
}