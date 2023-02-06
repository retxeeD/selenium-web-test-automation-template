package br.com.poc.util;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.poc.util.interfaces.WebApplication;

public class BaseTest {
	
	protected static WebDriver webDriver;
	protected static WebDriverWait wait;
	protected static Faker faker = new Faker();

	//IMPLEMENTAR WAITS VISIBLE AND CLICKABLE
	
	/**
	 * Inicializa o {@code WebDriver} e o {@code WebDriverWait}
	 */
	
	protected void initializeWebApplication(WebApplication webApplication) {
		webDriver = webApplication.getDriver();
		webDriver.manage().window().maximize();
		wait = new WebDriverWait(webDriver, 20);
	}
	
	/**
	 * close driver web
	 */
	protected static void closeWeb() {
		webDriver.quit();
}

}
