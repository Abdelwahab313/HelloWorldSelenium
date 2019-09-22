import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GoogleTest {

    private WebDriver driver;
    private Eyes eyes;

    @Before
    public void setup() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("src/main//resources/test.properties")));
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        driver = new ChromeDriver();

        initiateEyes();
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

        driver.findElement(By.cssSelector("input.gsfi")).sendKeys("here");
        validateWindow();
    }

    @After
    public void teardown(){
        driver.quit();
        eyes.abortIfNotClosed();
    }


    public void validateWindow() {
        eyes.open(driver, "Automation Google",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }


    private void initiateEyes() {
        eyes = new Eyes();

        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }
}
