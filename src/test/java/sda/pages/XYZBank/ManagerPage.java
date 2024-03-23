package sda.pages.XYZBank;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;

import java.util.List;

public class ManagerPage {
    public ManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@ng-class='btnClass1']")
    public WebElement addCustomer;
    @FindBy(xpath = "//*[@ng-class='btnClass2']")
    public WebElement openAccount;
    @FindBy(xpath = "//*[@ng-class='btnClass3']")
    public WebElement customers;
    @FindBy(xpath = "//*[@ng-model='fName']")
    public WebElement firstnameField;
    @FindBy(xpath = "//*[@ng-model='lName']")
    public WebElement lastnameField;
    @FindBy(xpath = "//*[@ng-model='postCd']")
    public WebElement postcodeField;

    @FindBy(xpath = "//*[.='Add Customer']")
    public WebElement addCustomerButton;

   public void addCustomerInfo() throws InterruptedException {
        addCustomer.click();

        Faker faker = new Faker();
        for(int i=0; i<5; i++){
            firstnameField.sendKeys(faker.name().firstName());
            lastnameField.sendKeys(faker.name().lastName());
            postcodeField.sendKeys(faker.address().zipCode());
            addCustomerButton.click();
            Thread.sleep(1000);
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        }
    }

    @FindBy(id = "userSelect")
    public WebElement customerSelect;
    @FindBy(id = "currency")
    public WebElement currencySelect;
    @FindBy(xpath = "//button[.='Process']")
    public WebElement processButton;
    @FindBy(xpath = "//button[@ng-click='deleteCust(cust)']")
    public List<WebElement> deleteButtons;
    public void openNewAccount() throws InterruptedException {
        openAccount.click();
        Thread.sleep(1000);
        Select selectCustomer = new Select(customerSelect);
        Select selectCurrency = new Select(currencySelect);

        for(int i=1; i<=5; i++){
            selectCustomer.selectByIndex(i);
            Thread.sleep(1000);
            selectCurrency.selectByIndex(1);
            Thread.sleep(1000);
            processButton.click();
            Thread.sleep(1000);
            Driver.getDriver().switchTo().alert().accept();
        }
    }

    @FindBy(xpath = "//table[@class='table table-bordered table-striped']//tbody//tr")
    public List<WebElement> rows;
    public int customersTable(){
        customers.click();
        return rows.size();
    }

    public void deleteCustomers(){
        System.out.println("before "+deleteButtons.size());
        for(int i=0; i<deleteButtons.size()+1; i++){
            deleteButtons.get(i).click();
        }
        System.out.println("after "+deleteButtons.size());
    }
}
