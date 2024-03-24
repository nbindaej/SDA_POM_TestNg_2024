package sda.pages.XYZBank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;

public class CustomerPage {
    public CustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "userSelect")
    public WebElement nameSelect;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    public WebElement depositButton;
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    public WebElement withdrawlButton;
    @FindBy(xpath = "//button[@ng-click='transactions()']")
    public WebElement transactionsButton;
    @FindBy(xpath = "//input[@type='number']")
    public WebElement amountBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@ng-show='message']")
    public WebElement successfulMessage;
    @FindBy(xpath = "//button[@ng-show='logout']")
    public WebElement logoutButton;

    public void selectYourName(){
        Select select = new Select(nameSelect);
        select.selectByIndex(2);
        loginButton.click();
    }
    public void deposit() throws InterruptedException {
        depositButton.click();
        amountBox.sendKeys("100");
        submitButton.click();
        Thread.sleep(1000);
    }
    public String successfulMessage() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(successfulMessage.getText());
        return successfulMessage.getText();
    }
    public void withdraw() throws InterruptedException {
        withdrawlButton.click();
        Thread.sleep(1000);
        amountBox.sendKeys("100");
        submitButton.click();
    }
    public void logout(){
        logoutButton.click();
    }
}
