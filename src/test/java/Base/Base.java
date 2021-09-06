package Base;

import HelpMethod.elementMethods;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


    public WebDriver driver;

    public elementMethods elementMethods; //la nivel global


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
}
