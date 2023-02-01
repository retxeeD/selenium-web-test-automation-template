package br.com.poc.funcionalidades;

import br.com.poc.pages.IndexPage;
import br.com.poc.util.BaseTest;
import br.com.poc.util.commons.Constant;
import com.github.javafaker.Faker;
import org.junit.Assert;

public class IndexFeature extends BaseTest {

	private IndexPage page;

	Faker faker = new Faker();


	public IndexFeature() {
		this.page = new IndexPage(webDriver);
	}

	public void OpenRegisterPage() {
		String URI = Constant.BASE_URL + Constant.ENDPOINT_REGISTER_PAGE;
		//this.webDriver.get(URI);
		this.webDriver.get("https://demo.automationtesting.in/Index.html");
	}

	public void PutEmail() {
		page.getEmailField().sendKeys(faker.name().firstName() +"@teste.com.br");
	}

	public void ClickEnter() {
		page.getBtnEnter().click();
	}

	public void validURLRegisterPage(){
		Assert.assertEquals("https://demo.automationtesting.in/Register.html" , webDriver.getCurrentUrl());
	}

}
