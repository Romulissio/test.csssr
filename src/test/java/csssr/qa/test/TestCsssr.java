package csssr.qa.test;

import csssr.qa.main.PageObj;
import csssr.qa.main.utils.ConfigProperties;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestCsssr extends BaseTest{
    private PageObj page = PageFactory.initElements(setup(), PageObj.class);
    @Test
    public void shouldOpenScreenshotToolLink() throws InterruptedException {
        page.open();
        Set<String> oldWindowsSet = page.getWindowsSet();
        page.clickSecondBlockButton();
        page.clickLinkScreenshotTools();
        page.switchNewWindow(oldWindowsSet);
        String expectedTitle = ConfigProperties.getProperty("expectedTitle");
        Assert.assertTrue(page.getTitle().contains(expectedTitle),
                String.format("Ожидаемый результат - %s - программа для создания скриншотов, " +
                        "Фактический результат - %s", expectedTitle, page.getTitle()));
    }
}
