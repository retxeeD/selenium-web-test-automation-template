package br.com.frame.funcionalidades;

import br.com.frame.pages.RegisterUserPage;
import br.com.frame.util.BaseTest;
import com.github.javafaker.Faker;
import org.junit.Assert;

public class RegisterUserFeature extends BaseTest {

	private RegisterUserPage register;

	Faker faker = new Faker();

	public RegisterUserFeature() {
		this.register = new RegisterUserPage(webDriver);
	}

	public void OpenRegisterPage() {
		this.webDriver.get("https://demo.automationtesting.in/Index.html");
		this.register = new RegisterUserPage(webDriver);
	}

	public void PutEmail() {
		register.getEmail().sendKeys(faker.name().firstName() +"@teste.com.br");
	}

	public void ClickEnter() {
		register.getBtnEnter().click();
	}

	public void validURLRegisterPage(){
		Assert.assertEquals("https://demo.automationtesting.in/Register.html" , webDriver.getCurrentUrl());
	}

}
