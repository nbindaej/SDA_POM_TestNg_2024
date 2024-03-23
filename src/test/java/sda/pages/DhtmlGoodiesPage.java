package sda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class DhtmlGoodiesPage {
    public DhtmlGoodiesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll({
            @FindBy(id = "box1"),
            @FindBy(id = "box2"),
            @FindBy(id = "box3"),
            @FindBy(id = "box4"),
            @FindBy(id = "box5"),
            @FindBy(id = "box6"),
            @FindBy(id = "box7"),
    })
    public List<WebElement> capital;
    @FindAll({
            @FindBy(id = "box101"),
            @FindBy(id = "box102"),
            @FindBy(id = "box103"),
            @FindBy(id = "box104"),
            @FindBy(id = "box105"),
            @FindBy(id = "box106"),
            @FindBy(id = "box107"),
    })
    public List<WebElement> country;

public void dragAndDropCapital(){
    Actions actions = new Actions(Driver.getDriver());
    for(int i=0; i<capital.size(); i++){
    actions.dragAndDrop(capital.get(i),country.get(i)).perform();
}
}

}
