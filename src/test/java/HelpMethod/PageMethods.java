package HelpMethod;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PageMethods {

    WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;

    }

    public void validateTitlePage(String expected) {
        String actual = driver.getTitle();
        Assert.assertEquals("Pagina dorita: " +" expected "+ " ", expected, actual);

    }
}
