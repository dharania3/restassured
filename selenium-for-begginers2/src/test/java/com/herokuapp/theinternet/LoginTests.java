package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	private void setUp(String browser) {

//			Create driver
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("Do not know how to start " + browser + ", starting chrome instead");
				System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			}

		driver.manage().window().maximize();
	}

	@Test(groups = { "login" })
	public void loginTest() {
		System.out.println("Starting loginTest");

//		Create driver

//		open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		//System.out.println("Page is opened.");

//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

//		click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

//		verifications:
//		 new url
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

//		 logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");

//		 succesful login message
		// WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		// Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not
		// the same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message: " + actualMessage
						+ "\nExpected Message: " + expectedMessage);

		// Close browser
		driver.quit();
	}

	@Parameters({ "us", "ps", "msg" })
	@Test(priority = 1, groups = { "negetive" })
	public void incorrectTest(String usname, String pass, String xmsg) {
		System.out.println("Starting incorrectUsernameTest");

//		Create driver

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
				"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
						+ xmsg);

		// Close browser

	}
	@AfterTest(alwaysRun = true)
	private void ends() {
		driver.quit();
	}
}
