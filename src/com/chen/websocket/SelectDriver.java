package com.chen.websocket;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

public class SelectDriver

{
	public WebDriver driverName(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			 option.addArguments("headless");
			//option.addArguments("disable-infobars");
			return new ChromeDriver(option);
		} else {
			System.out.println("chromedriver失败");
			return null;
		}

	}

	public static SelectDriver sd = new SelectDriver();

	public static SelectDriver instance() {
		return sd;
	}

	public SelectDriver() {

	}

}
