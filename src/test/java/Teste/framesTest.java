package Teste;

import Base.Base;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class framesTest extends Base {

    @Test
    public void framesTestt() throws InterruptedException {
        WebElement SwitchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        // obiect de tip actions
        Actions hover = new Actions(driver);
        hover.moveToElement(SwitchToElement).build().perform(); //garanteaza ca mouse-ul merge la element;

        WebElement alertElement = driver.findElement(By.cssSelector("a[href='Alerts.html']"));
        alertElement.click();
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");


        List<WebElement> frameElement = driver.findElements(By.cssSelector(".nav.nav-tabs li"));
        frameElement.get(0).click();

        driver.switchTo().frame("singleframe");
        WebElement textBoxElement = driver.findElement(By.cssSelector("input[type='text']"));
        textBoxElement.sendKeys("Mihaela");

        Thread.sleep(1000);

        driver.switchTo().defaultContent(); // Te intoarce cu focusul la pagina principala;

        frameElement.get(1).click();

        WebElement bigFrame = driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html"));
        driver.switchTo().frame(bigFrame);

        //driverul se schimba pe frame-ul mic;

        WebElement littleFrame = driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']"));
        driver.switchTo().frame(littleFrame);


        WebElement textBoxEle = driver.findElement(By.cssSelector("input[type='text']"));
        textBoxEle.sendKeys("Mihaela");

        Thread.sleep(1000);

        driver.switchTo().defaultContent();

        frameElement.get(0).click();
    }
}
