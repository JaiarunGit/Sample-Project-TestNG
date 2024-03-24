package org.ng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestNG {

	WebDriver driver;

	@BeforeTest
	@Parameters("baseURL")
	public void setUp(String URL) {
		// Set the path of the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", 
	    "C:\\selenium webdriver\\chromedriver-win64\\chromedriver.exe");

		// Initialize ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximize the window

		// Navigate to the base URL
		driver.get(URL);
	}

	@Test(priority = 0)
	@Parameters("Title")
	public void testTitle(String title) {
		// Validate the title
		Assert.assertEquals(driver.getTitle(),title);
	}

	@Test(priority = 1)
	@Parameters("baseURL")
	public void testUrl(String URL) {
		// Find the header element
		Assert.assertEquals(driver.getCurrentUrl(),URL);
	}

	@Test(priority = 2)
	@Parameters("NextUrltitle")
	public void testLink(String nexturltitle) {
		// Find and click on a sample link
		WebElement link = driver.findElement(By.linkText("End of season sale"));
		link.click();

		// Validate the new page title
		Assert.assertEquals(driver.getTitle(),nexturltitle);

		// Navigate back to the original page
		driver.navigate().back();
	}

	@AfterTest
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
