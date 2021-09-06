package Teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class testeAlerte {

    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\ChromeDriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");   // are rolul sa mearga la url si sa astepte sa se incarce pagina
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() {
       // driver.quit();
    }

    @Test
    public void testAlerte() throws InterruptedException {
        WebElement SwitchToElement = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        // obiect de tip actions
        Actions hover = new Actions(driver);
        hover.moveToElement(SwitchToElement).build().perform(); // garanteaza ca merge mouse-ul la element


        Thread.sleep(1000);
        WebElement alertElement = driver.findElement(By.cssSelector("a[href='Alerts.html']"));
        alertElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(1000);

        List<WebElement> elementAlerts = driver.findElements(By.cssSelector(".nav.nav-tabs.nav-stacked li"));
        //Click pe primul element;
        elementAlerts.get(0).click();
        WebElement alertWithOKElement = driver.findElement(By.cssSelector("button[onclick='alertbox()']"));
        alertWithOKElement.click();

        System.out.println(driver.switchTo().alert().getText()); //Verificam daca intelij a interactionat cu alerta;
        driver.switchTo().alert().accept(); //Interactionezi cu alerta;

        elementAlerts.get(1).click();
        WebElement alertWithOkCancelElement = driver.findElement(By.cssSelector("button[onclick='confirmbox()']"));
        alertWithOkCancelElement.click();
        System.out.println(driver.switchTo().alert().getText()); //Verificam daca inteli a interactionat cu alerta;

        driver.switchTo().alert().dismiss();

        elementAlerts.get(2).click();
        WebElement alertWithTextElement = driver.findElement(By.cssSelector("button[onclick='promptbox()']"));
        alertWithTextElement.click();
        driver.switchTo().alert().sendKeys("Mihaela");
        driver.switchTo().alert().accept();

    }
}
