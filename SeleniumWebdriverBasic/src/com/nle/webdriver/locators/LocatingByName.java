package com.nle.webdriver.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByName {

	public static void main(String[] args) {
		WebDriver driver = initWebDriver();
		driver.get("https://automationtesting.co.uk/contactForm.html");
		
		driver.findElement(By.name("first_name")).sendKeys("Nhung");
		driver.findElement(By.name("last_name")).sendKeys("Le");
		driver.findElement(By.name("email")).sendKeys("nhungle@example.com");
		driver.findElement(By.name("message")).sendKeys("Selenium learning select location by name");
	}

	public static WebDriver initWebDriver() {
		// Have to download chromedriver match with your current chrome version in your
		// computer
		System.setProperty("webdriver.chrome.driver", "/Users/nhungle/Documents/Study/Webdrivers/chromedriver");

		// In order to create scripts that interact with the Selenium Server (Remote
		// WebDriver)
		// or create local Selenium WebDriver scripts, you need to make use of
		// language-specific client drivers
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		return driver;

	}

}
