import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {

    private WebDriver driver;

    @Before
    public void setup() {

        System.setProperty(
                "webdriver.chrome.driver", "webdrivers/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }

    @Test
    public void testImageExists() {
        WebElement googleImage = driver.findElement(By.id("hplogo"));

        Assert.assertNotNull(googleImage);
    }

    @Test
    public void testOfferedInArabic() {
        WebElement LanguageLink = driver.findElement(By.xpath("//*[@id=\"SIvCob\"]/a"));

        Assert.assertEquals(LanguageLink.getText(), "العربية");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
