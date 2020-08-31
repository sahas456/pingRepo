package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

public class WebElementUtils extends BasePage {

    public static void enterText(WebElement element, String text)  {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
