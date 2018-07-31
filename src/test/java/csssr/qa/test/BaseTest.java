package csssr.qa.test;

import csssr.qa.main.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    public WebDriver setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().
                implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        return driver;
    }
    @AfterTest
    public void tearDown()throws Exception{
        driver.quit();
    }
}
