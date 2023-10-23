package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC02 extends BaseTest {
    @Test(dataProvider = "loginData")
    public void testMethod(String username, String password){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed());
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyDashboardPage());
        softAssert.assertAll();
    }
    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "Login", 0, 2);
    }
}
