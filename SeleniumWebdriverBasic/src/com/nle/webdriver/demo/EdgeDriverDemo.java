package com.nle.webdriver.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverDemo {

	public static void main(String[] args) {
		// Have to download msedgedriver match with your current edge version in your
		// computer
		System.setProperty("webdriver.edge.driver", "/Users/nhungle/Documents/Study/Webdrivers/msedgedriver");

		// In order to create scripts that interact with the Selenium Server (Remote
		// WebDriver)
		// or create local Selenium WebDriver scripts, you need to make use of
		// language-specific client drivers
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://automationtesting.co.uk/");

	}

}
