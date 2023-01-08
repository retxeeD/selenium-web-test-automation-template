package br.com.poc.steps;

import br.com.poc.funcionalidades.RegisterUserFeature;
import br.com.poc.util.reports.ReportVariables;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterUserSteps {

    private RegisterUserFeature register;

    public RegisterUserSteps() {
        this.register = new RegisterUserFeature();
    }

    @Given("that I'm on the index page")
    public void that_i_m_on_the_index_page() {
        ReportVariables.setCommunValues("Validação da funcionalidade RegisterUser", "NA", "NA");
        this.register.OpenRegisterPage();
    }

    @And("I have a valid email to register")
    public void I_have_a_valid_email_to_register() {
        this.register.PutEmail();
    }

    @When("I click the enter button")
    public void I_click_the_enter_button() {
        this.register.ClickEnter();
    }

    @When("I'm redirected to the registration page")
    public void Im_redirected_to_the_registration_page(){
        this.register.validURLRegisterPage();
    }
}
