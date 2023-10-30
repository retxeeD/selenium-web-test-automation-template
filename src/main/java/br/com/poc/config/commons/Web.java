package br.com.poc.config.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.poc.config.interfaces.WebApplication;

public enum Web implements WebApplication {

/*	CHROME {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
			return new ChromeDriver();
		}
	}, */

	CHROME_WINDOWS {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
