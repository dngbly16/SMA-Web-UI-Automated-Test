package tests;

import core.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01 extends BaseTest {
    @Test
    public void testMethod(){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed());
        softAssert.assertTrue(loginPage.verifyPasswordTextBoxDisplayed());
        softAssert.assertTrue(loginPage.verifyLoginButtonDisplayed());
        softAssert.assertTrue(loginPage.verifyRememberMeCheckboxDisplayed());
        softAssert.assertAll();
    }
}
