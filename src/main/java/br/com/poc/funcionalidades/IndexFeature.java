package br.com.poc.funcionalidades;

import br.com.poc.pages.IndexPage;
import br.com.poc.config.BaseTest;
import br.com.poc.config.commons.Constant;
import br.com.poc.util.data.DataUtils;
import com.github.javafaker.Faker;
import org.junit.Assert;

public class IndexFeature extends BaseTest {

	private IndexPage page;

	Faker faker = new Faker();


	public IndexFeature() {
		this.page = new IndexPage(webDriver);
	}

	public void OpenRegisterPage() {
		String url = getBaseUrl(getEnvironment(), Constant.BASE_URL) + getEndpoint(Constant.ENDPOINT_INDEX_PAGE);
		this.webDriver.get(url);
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
