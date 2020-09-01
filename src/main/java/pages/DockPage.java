package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        profileButton.click();

        Assert.assertTrue(adminLink.isDisplayed());
        Assert.assertTrue(passwordLink.isDisplayed());
    }

    public void checkEndUserDetails() {
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        profileButton.click();
        Assert.assertTrue(passwordLink.isDisplayed());

        try{
            Assert.assertTrue(adminLink.isDisplayed(),"admin link is visible for User");
        }catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }

    }

    public DockLoginPage logOut() {
        wait.until(ExpectedConditions.visibilityOf(logOutLink));
        logOutLink.click();
        return new DockLoginPage();
    }

}
