package sda.pages.ebay;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class ItemPage {
    public ItemPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@rel='nofollow'])[5]")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@class='x-price-primary']")
    public WebElement itemPrice;
    public double getProductPrice() {
        String priceString = itemPrice.getText().replaceAll("[^0-9.]", "");
        System.out.println("item price : "+priceString);
        return Double.parseDouble(priceString);
    }
    public void addItemToCart(){
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        addToCartButton.click();
    }

}
