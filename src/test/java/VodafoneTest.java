import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.assertTrue;

public class VodafoneTest {

    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty(
                "webdriver.chrome.driver", "webdriver/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testVodafone() {
        driver.get("https://web.vodafone.com.eg/ar/home");
        WebDriverWait wait = new WebDriverWait(driver, 20);



        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("innerLoginBtn"))).click();

        WebElement loginNumberField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginNum")));
        loginNumberField.sendKeys("01090614633");

        WebElement loginPasswordField =wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("loginPassword")));
        loginPasswordField.sendKeys("oNe_status_1");

        driver.findElement(By.id("loginButton")).click();



        WebElement accountHeadingTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("service-selector__active-heading")));
        String AccountHeadingTitle = accountHeadingTitle.getText();


        assertTrue(AccountHeadingTitle.contains("Yahya"));
        assertTrue(AccountHeadingTitle.contains("01090614633"));
    }


   @After
    public void tearDown() {
       driver.quit();
   }

}
