package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashBoardPage extends BasePage {

     public DashBoardPage(){ PageFactory.initElements(driver, this); }

     @FindBy(id = "pingone-logo")
     private WebElement logo;

     @FindBy(xpath = "//*[@id='headerLinkUser']")
     private WebElement profileName;

     @FindBy(xpath = "//*[@id='configureSsoBox']//*[@class='ping-notice-details']/a[4]")
     private WebElement dockUrlBox;

     public void verifyHomePage(String profileuser){
          Assert.assertEquals(profileName.getText(), profileuser);
          Assert.assertTrue(logo.isDisplayed());
     }

     public SettingsPage gotoUserSettingsPage(){
          profileName.click();
          return new SettingsPage();
     }

     public String getDockUrl() {
          return dockUrlBox.getAttribute("href");
     }

     public DockLoginPage goToDock(String dockUrl) {
          driver.get(dockUrl);
          return new DockLoginPage();
     }
}
