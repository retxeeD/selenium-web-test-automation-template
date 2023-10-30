package br.com.poc.config;

import br.com.poc.config.commons.Constant;
import br.com.poc.properties.PropertiesLoader;
import com.github.javafaker.Faker;
import org.apache.bcel.generic.RETURN;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.poc.config.interfaces.WebApplication;

public class BaseTest {
	
	protected static WebDriver webDriver;
	protected static WebDriverWait wait;
	protected static Faker faker = new Faker();

	private static final String APPLICATION_PROPERTIES = "/application.properties";
	
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

	public static String getEnvironment(){
		if (System.getProperty(Constant.ENVIROMENT)==null || System.getProperty(Constant.ENVIROMENT).equals("")){
			System.setProperty(Constant.ENVIROMENT, PropertiesLoader.getInstance().getValue("/application.properties", Constant.ENVIROMENT));
		}
		return System.getProperty(Constant.ENVIROMENT);
	}

	public static String getBaseUrl(String environment, String pathBaseUrl){
		StringBuilder builder = new StringBuilder();

		String baseUrl = PropertiesLoader.getInstance().getValue(APPLICATION_PROPERTIES,
				builder.append(environment.toLowerCase()).append(".").append(pathBaseUrl).toString());
		return baseUrl;
	}

	public static String getEndpoint(String pathEndpoint){
		String endpoint = PropertiesLoader.getInstance().getValue(APPLICATION_PROPERTIES,
				pathEndpoint);
		return endpoint;
	}

}
