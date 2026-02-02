package ui_tests;

import dto.Contact;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;
import static pages.BasePage.clickButtonHeader;
import static utils.ContactFactory.*;

public class AddNewContactTests extends AppManager {
    HomePage homePage;
    LoginPage loginPage;
    ContactPage contactPage;
    AddPage addPage;

    @BeforeMethod
    public void login() {
        homePage = new HomePage(getDriver());
        loginPage = clickButtonHeader(HeaderMenuItem.LOGIN);
        loginPage.typeLoginRegistrationForm
                ("sveta548@smd.com", "Password123!");
        loginPage.clickBtnLoginForm();
        contactPage = new ContactPage(getDriver());
        addPage = clickButtonHeader(HeaderMenuItem.ADD);
    }

    @Test
    public void addNewContactPositiveTest() {
        addPage.typeContactForm(positiveContact());

    }

    @Test
    public void checkIfContactExists() {
        Contact testContact = positiveContact();
        addPage.typeContactForm(testContact);
        System.out.println(testContact.getPhone());
        Assert.assertTrue(contactPage.isPhonePresent(testContact.getPhone()));
    }



}
