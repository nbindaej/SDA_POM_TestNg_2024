package sda.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class FacebookLoginPage {
    public FacebookLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(name = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement failedMessage;

    public void login(){
        Faker faker = new Faker();
        emailField.sendKeys(faker.internet().emailAddress());
        passwordField.sendKeys(faker.internet().password());
        loginButton.click();
    }

    public String getTextOfFailedMessage(){
        return failedMessage.getText();
    }
}
