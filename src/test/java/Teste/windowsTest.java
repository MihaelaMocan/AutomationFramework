package Teste;

import Base.Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class windowsTest extends Base {
    @Test
    public void testAlerte() throws InterruptedException {
        WebElement SwitchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        // obiect de tip actions
        Actions hover = new Actions(driver);
        hover.moveToElement(SwitchToElement).build().perform(); // garanteaza ca merge mouse-ul la element


        WebElement windowsElement = driver.findElement(By.cssSelector("a[href='Windows.html']"));
        windowsElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Windows.html");


        List<WebElement> meniuWindows = driver.findElements(By.cssSelector(".nav-labs li"));
        meniuWindows.get(1).click();

        WebElement clickElement = driver.findElement(By.cssSelector(".btn.btn-info"));
        clickElement.click();

        System.out.println(driver.getTitle());

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //returneaza o lista cu taburi
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));

        meniuWindows.get(1).click();
        WebElement okButtonElement = driver.findElement(By.cssSelector(".btn.btn-primary"));
        okButtonElement.click();

        ArrayList<String> multipleTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(multipleTabs.get(2));
        System.out.println(driver.getTitle());
        driver.close();

        driver.switchTo().window(multipleTabs.get(0));


        meniuWindows.get(1).click();
        WebElement windowsElemen = driver.findElement(By.cssSelector("button[onclick='newwindow()']"));
        windowsElemen.click();

        ArrayList<String> newindow = new ArrayList<>(driver.getWindowHandles());
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(newindow.get(0));

    }
}
