package HelpMethod;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class elementMethods {

    //declaram metode generale la nivel de interactiune cu elemente;


    public WebDriver driver;

    public elementMethods(WebDriver driver) {
        this.driver = driver;



    }

    public void clickElement(WebElement element) {
        element.click();

    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
        //metoda care scrie ceva pe un element;
    }

    public void selectElementByText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);


    }
    public void selectElementByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void fillElement(WebElement element, String value, Keys command) {
        element.sendKeys(value,command);
    }


}
