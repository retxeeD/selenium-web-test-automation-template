package br.com.poc.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage {

    @FindBy(xpath ="aa")
    private WebElement firstName;
    @FindBy(xpath ="aa")
    private WebElement lastName;
    @FindBy(xpath ="aa")
    private WebElement address;
    @FindBy(xpath ="aa")
    private WebElement emailAddress;
    @FindBy(xpath ="aa")
    private WebElement phone;
    @FindBy(xpath ="aa")
    private WebElement hobbiesCricket;
        @FindBy(xpath ="aa")
    private WebElement hobbiesMovies;
        @FindBy(xpath ="aa")
    private WebElement hobbiesHockey;
        @FindBy(xpath ="aa")
    private WebElement languages;
    @FindBy(xpath ="aa")
    private WebElement skillsDropdown;

}
