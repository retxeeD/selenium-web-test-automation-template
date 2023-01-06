package br.com.frame.steps;

import br.com.frame.funcionalidades.RegisterUserFeature;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RegisterUserSteps {

    private RegisterUserFeature register;

    public RegisterUserSteps() {
        this.register = new RegisterUserFeature();
    }

    @Given("that I'm on the index page")
    public void that_Im_on_the_index_page(){
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
