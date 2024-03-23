package sda.pages.ebay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//select)[2]")
    public WebElement quantity;

    public void increaseItemQuantity(int qty) throws InterruptedException {
        Select select = new Select(quantity);
        select.selectByIndex(qty-1);
        Thread.sleep(1000);
    }

    @FindBy(xpath = "//*[@class='item-price font-title-3']")
    public WebElement totalprice;
    public double totalAmount() throws InterruptedException {
        String priceString = totalprice.getText().replaceAll("[^0-9.]", "");
        System.out.println("total price :" + priceString);
        return Double.parseDouble(priceString);
    }
}
