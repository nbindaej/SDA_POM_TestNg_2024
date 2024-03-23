package sda.pages.ebay;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

import java.util.Iterator;
import java.util.Set;

public class EbayPage {
    public EbayPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "gh-ac")
    public WebElement searchBox;
    @FindBy(xpath = "(//div[@class='s-item__title'])[2]")
    public WebElement firstItem;
    public void serachFor(String keyword){
        searchBox.sendKeys(keyword, Keys.ENTER);
        firstItem.click();
        Set<String> handlesSet =Driver.getDriver().getWindowHandles();
        Iterator<String> handlesItr = handlesSet.iterator();

        String searchPageHandle = handlesItr.next();
        String itemPageHandle = handlesItr.next();

        Driver.getDriver().switchTo().window(itemPageHandle);
    }
}
