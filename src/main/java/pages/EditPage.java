package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage extends BasePage {

    public EditPage(){ PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//span[text()='Role']")
    private WebElement roleField;


}
