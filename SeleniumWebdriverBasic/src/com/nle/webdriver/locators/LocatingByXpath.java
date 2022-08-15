package com.nle.webdriver.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingByXpath {

	public static void main(String[] args) {
		WebDriver driver = initWebDriver();
		driver.get("https://automationtesting.co.uk/buttons.html");
		
		//select absolute path
		//driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div[1]/button")).click();
		
		//relative path
		driver.findElement(By.xpath("//button[@id='btn_one']")).click();
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
