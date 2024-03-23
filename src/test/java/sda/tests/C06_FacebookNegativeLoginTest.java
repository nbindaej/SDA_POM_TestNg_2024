package sda.tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.FacebookLoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C06_FacebookNegativeLoginTest {
    //Go to https://www.facebook.com/
    //Log in (faker class)
    //Test the "Failed to login" message
    @Test
    public void loginTest(){

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        facebookLoginPage.login();

        Assert.assertTrue(facebookLoginPage.failedMessage.isDisplayed());

        String errorMessage = facebookLoginPage.getTextOfFailedMessage();
        Assert.assertTrue(errorMessage.contains("The email you entered isn’t connected to an account"));

        Driver.closeDriver();
    }

}
