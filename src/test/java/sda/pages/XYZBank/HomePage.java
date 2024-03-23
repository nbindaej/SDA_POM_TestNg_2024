package sda.pages.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[.='Bank Manager Login']")
    public WebElement managerLoginButton;
    @FindBy(xpath = "//button[.='Customer Login']")
    public WebElement customerLoginButton;
    @FindBy(xpath = "//*[@class='btn home']")
    public WebElement homeButton;

    public void managerLogin(){
        managerLoginButton.click();
    }
    public void customerLogin(){
        customerLoginButton.click();
    }
    public void backToHome(){
        homeButton.click();
    }

}
