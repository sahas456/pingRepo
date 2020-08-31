package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.WebElementUtils.enterText;

public class DockLoginPage extends BasePage {

    public DockLoginPage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "ping-username")
    private WebElement pingUserNameField;

    @FindBy(id = "ping-password")
    private WebElement pingPasswordField;

    @FindBy(id = "btn-sign-in")
    private WebElement pingSubmitButton;

    public DockPage dockLogin(String dockUserName, String dockPassword) {
        wait.until(ExpectedConditions.visibilityOf(pingUserNameField));
        enterText(pingUserNameField, dockUserName);
        enterText(pingPasswordField, dockPassword);
        pingSubmitButton.click();
        return new DockPage();
    }

}
