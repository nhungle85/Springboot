package com.nle.webdriver.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByCSS {

	public static void main(String[] args) {
		WebDriver driver = initWebDriver();
		driver.get("https://automationtesting.co.uk/buttons.html");
		
		driver.findElement(By.cssSelector("#btn_one")).click();
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
