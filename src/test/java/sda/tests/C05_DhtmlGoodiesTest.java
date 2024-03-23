package sda.tests;

import org.testng.annotations.Test;
import sda.pages.DhtmlGoodiesPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C05_DhtmlGoodiesTest {
    @Test
    public void dragAndDropTest() {

        DhtmlGoodiesPage dhtmlGoodiesPage = new DhtmlGoodiesPage();
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlGoodiesUrl"));

        // Fill in capitals by country.
        dhtmlGoodiesPage.dragAndDropCapital();

        Driver.closeDriver();
    }
}