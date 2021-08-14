package Teste;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public WebDriver driver;

    @Test
    public void metodaTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        //Deschidem un browser + accesam url
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        //Facem browserul modul maximize
        driver.manage().window().maximize();

        //Declari elementul Signin
        WebElement signinElement = driver.findElement(By.id("btn1"));
        signinElement.click();

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "mihaela@yahoo.com";
        emailElement.sendKeys(emailValue);

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordValue = "12234";
        passwordElement.sendKeys(passwordValue);

        WebElement clickElement = driver.findElement(By.id("enterbtn"));
        clickElement.click();



    }
}
