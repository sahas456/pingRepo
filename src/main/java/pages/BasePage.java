package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage {

    public static WebDriver driver = DriverFactory.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 15);
}