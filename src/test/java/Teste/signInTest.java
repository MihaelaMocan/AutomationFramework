package Teste;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class signInTest {
    public WebDriver driver;

    @Test

    public void test() {

        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Index.html");
        driver.manage().window().maximize();

        //Validam pagina de index;
        String expectedIndexPage = "Index";
        String actualIndexPage = driver.getTitle(); // returneaza valoarea din tag-ul de titlu
        Assert.assertEquals("Index page nu a a aparut", expectedIndexPage, actualIndexPage);


        //Declaram elementul sign-in;

        WebElement signInElement = driver.findElement(By.id("btn1"));
        signInElement.click();

        String expectedIndexSignIn = "SignIn";
        String actualIndexSignInPage = driver.getTitle();
        Assert.assertEquals("Pagina nu a fost gasita", expectedIndexPage, actualIndexPage);

        WebElement emailElement = driver.findElement(By.cssSelector("input[placeholder='E mail']"));
        String emailValue = "emailAdress@aaadw.com";
        emailElement.sendKeys(emailValue);

        WebElement passwordElement = driver.findElement(By.cssSelector("input[placeholder='Password']"));
        String passwordValue = "parola";
        passwordElement.sendKeys(passwordValue);

        WebElement enterElement = driver.findElement(By.id("enterbtn"));
        enterElement.click();

        WebElement errorMessage = driver.findElement(By.id("errormsg"));
        String expectedErrorMessage = "Invalid User Name or PassWord";
        String actualErrorMessage = errorMessage.getText();

        Assert.assertEquals("Mesajul de eroare pt login nu e bun.", expectedErrorMessage,  actualErrorMessage);


    }
}
