package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SettingsPage extends BasePage {

    public SettingsPage(){ PageFactory.initElements(driver, this);}

    @FindBy(css = ".user .page-title")
    private WebElement settingsHeader;

    @FindBy(css = ".user .button")
    private WebElement editButton;

    public void verifySettingsPage(){

        Assert.assertTrue(settingsHeader.isDisplayed());
        Assert.assertTrue(editButton.isDisplayed());

    }

    public EditPage gotoEditPage(){

        editButton.click();
        return new EditPage();

    }



}