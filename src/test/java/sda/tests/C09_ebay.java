package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.ebay.CheckoutPage;
import sda.pages.ebay.EbayPage;
import sda.pages.ebay.ItemPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C09_ebay {
    @Test
    public void test() throws InterruptedException {
        EbayPage ebayPage = new EbayPage();
        ItemPage itemPage = new ItemPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        Driver.getDriver().get(ConfigReader.getProperty("ebayUrl"));

        ebayPage.serachFor("black cup 250ml");
        Double itemPrice = itemPage.getProductPrice();
        itemPage.addItemToCart();


        int qty=3;
        checkoutPage.increaseItemQuantity(qty);
        Thread.sleep(1000);
        Double totalPrice = checkoutPage.totalAmount();
        Assert.assertEquals(totalPrice,itemPrice*qty);
    }
}
