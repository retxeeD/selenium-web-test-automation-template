package br.com.poc.util.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.poc.util.interfaces.WebApplication;

public enum Web implements WebApplication {

	CHROME{
		public WebDriver getDriver(){
			String soName = System.getProperty("os.name");
			System.out.println(soName);
			if (soName.contains("Windows")) {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			} else if (soName.contains("Ubunto")) {
				System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			}else {
				throw new RuntimeException("Please add the chrome and chrome drive to this SO");
			}
			return new ChromeDriver();
		}
	},

	CHROME_PIPELINE {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			return new ChromeDriver();
		}
	},

	CHROME_WINDOWS {
		public WebDriver getDriver() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
