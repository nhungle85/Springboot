package com.nle.webdriver.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) {
		// Have to download chromedriver match with your current chrome version in your
		// computer
		System.setProperty("webdriver.gecko.driver", "/Users/nhungle/Documents/Study/Webdrivers/geckodriver");

		// In order to create scripts that interact with the Selenium Server (Remote
		// WebDriver)
		// or create local Selenium WebDriver scripts, you need to make use of
		// language-specific client drivers
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://automationtesting.co.uk/");

	}

}
