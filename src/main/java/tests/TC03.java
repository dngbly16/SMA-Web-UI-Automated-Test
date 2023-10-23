package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.ListProductsPage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC03 extends BaseTest {
    @Test(dataProvider = "tableColumnData")
    public void testMethod(String... parameters){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username displayed");
        loginPage.login("admin@tecdiary.com", "12345678");
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyMessageWithTextDisplayed(), "verify login success");
        dashboardPage.moveToListProductsPage();
        ListProductsPage listProductsPage = new ListProductsPage(getDriver());
        softAssert.assertTrue(listProductsPage.verifyListProductPage(), "verify move to list product");
        for (String parameter : parameters)
            softAssert.assertTrue(listProductsPage.verifyTableColumnWithGivenName(parameter), "verify " + parameter + "displayed");
        softAssert.assertAll();
    }
    @DataProvider(name = "tableColumnData")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "TC03", 1, 11);
    }
}
