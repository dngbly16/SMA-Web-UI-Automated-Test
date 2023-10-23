package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PrintBarcodePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC05 extends BaseTest {
    @Test(dataProvider = "loginData")
    public void testMethod(String username, String password){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username displayed");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyDashboardPage(), "verify dashboard page");
        dashboardPage.moveToPrintBarcodePage();
        PrintBarcodePage printBarcodePage = new PrintBarcodePage(getDriver());
        softAssert.assertTrue(printBarcodePage.verifyAddProductDisplayed(), "verify add product textbox");
        softAssert.assertTrue(printBarcodePage.verifyStyleDisplayed(), "verify style");
        softAssert.assertTrue(printBarcodePage.verifyPrintCheckboxesDisplayed(), "verify checkboxes");
        softAssert.assertAll();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "Login", 0, 2);
    }
}
