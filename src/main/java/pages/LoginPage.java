package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.rmi.server.ExportException;

import static utils.WebElementUtils.*;

public class LoginPage extends BasePage {

    public LoginPage() { PageFactory.initElements(driver, this); }

    @FindBy(id = "email")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "signOn")
    private WebElement submitButton;

    public void enterUsername(String username) { enterText(usernameField, username); }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void signOn(){ submitButton.click();}


    public DashBoardPage login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        enterUsername(username);
        enterPassword(password);
        signOn();

        return new DashBoardPage();
    }
}
