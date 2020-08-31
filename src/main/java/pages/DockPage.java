package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DockPage extends BasePage {

    public DockPage(){ PageFactory.initElements(driver, this); }

    @FindBy(css = ".details-target .settings-btn")
    private WebElement profileButton;

    @FindBy(css = ".details-body .account")
    private WebElement adminLink;

    @FindBy(css = ".details-body .passwords")
    private WebElement passwordLink;

    @FindBy(css = ".details-body .logout")
    private WebElement logOutLink;

    public void checkAdminDetails() {
        profileButton.click();
        Assert.assertTrue(adminLink.isDisplayed());
        Assert.assertTrue(passwordLink.isDisplayed());
    }

    public void checkEndUserDetails() {
        profileButton.click();
        Assert.assertTrue(passwordLink.isDisplayed());
    }

    public DockLoginPage logOut() {
        logOutLink.click();
        return new DockLoginPage();
    }

}
