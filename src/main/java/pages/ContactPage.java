package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ContactPage extends BasePage{
    public ContactPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    WebElement btnSignOut;
    @FindBy(xpath = "//*[text()='ADD']")
    WebElement btnAdd;
    @FindBy(xpath = "//h1[text()=' No Contacts here!']")
    WebElement contactPageMessage;
    @FindBy(css = "div.contact-item_card__2SOIM")
    List<WebElement> contactCards;

    public boolean isTextInContactPageMessagePresent(String text){
        return isTextInElementPresent(contactPageMessage, text);
    }

    public boolean isTextInBtnSignOutPresent(String text){
        return isTextInElementPresent(btnSignOut, text);
    }

    public boolean isTextInBtnAddPresent(String text){
       return isTextInElementPresent(btnAdd, text);
    }

    public boolean isPhonePresent(String phone) {
        return !driver.findElements(By.xpath("//h3[text()='" + phone + "']")).isEmpty();

    }


}
