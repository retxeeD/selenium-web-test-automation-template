package br.com.poc.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class IndexPage {
	
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	
	@FindBy(xpath = "//img[@id='enterimg']")
	private WebElement btnEnter;
	
	@FindBy(xpath = "//button[@id='btn1' and text()='Sign In']")
	private WebElement btnSignIn; 

	@FindBy(xpath = "//button[@id='btn2' and text()='Skip Sign In']")
	private WebElement btnSkipSignIn;

	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
