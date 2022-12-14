package com.nle.webdriver.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		// Have to download chromedriver match with your current chrome version in your
		// computer
		System.setProperty("webdriver.chrome.driver", "/Users/nhungle/Documents/Study/Webdrivers/chromedriver");

		// In order to create scripts that interact with the Selenium Server (Remote
		// WebDriver)
		// or create local Selenium WebDriver scripts, you need to make use of
		// language-specific client drivers
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://automationtesting.co.uk/");
	}

}
