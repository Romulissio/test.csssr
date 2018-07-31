package csssr.qa.main;

import csssr.qa.main.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;


public class PageObj {
    WebDriver driver;
    public PageObj(WebDriver driver){
        this.driver = driver;
    }
    @FindBy(xpath = "//section/div[2]/a")
    private WebElement firstBlockButton;
    @FindBy(xpath = "//section[2]//a")
    private WebElement linkScreenshotTools;

    /**
     * Открвает страницу
     */
    public void open(){
        driver.get(ConfigProperties.getProperty("open.url"));
    }

    /**
     * Открывет второй блок в распределении обязанностей
     */
    public void clickSecondBlockButton(){
        firstBlockButton.click();
    }

    /**
     * Кликает на ссылку "Софт для быстрого создания скриншотов"
     */
    public void clickLinkScreenshotTools(){
        linkScreenshotTools.click();
    }

    /**
     *
     * @return Возвращает множество вкладок браузера
     */
    public Set getWindowsSet(){
        return driver.getWindowHandles();
    }

    /**
     * Переключение драйвера на новую вкладку браузера
     * @param oldWindowsSet
     */
    public void switchNewWindow(Set<String> oldWindowsSet){
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

    /**
     *
     * @return Возвращает тайтл страницы
     */
    public String getTitle(){
        return driver.getTitle();
    }

}
