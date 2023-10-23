package tests;

import core.BaseTest;
import core.ExcelUtils;
import pages.AddSalesPage;
import pages.DashboardPage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC07 extends BaseTest {
    @Test(dataProvider = "loginData")
    public void testMethod(String username, String password){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username display");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyDashboardPage(), "verify dashboard page");
        dashboardPage.moveToAddSale();
        AddSalesPage addSalesPage = new AddSalesPage(getDriver());
        softAssert.assertTrue(addSalesPage.verifyAddSalesPage(), "verify add sale page");
        addSalesPage.chooseWarehouse();
        addSalesPage.chooseCustomer();
        addSalesPage.addOrderItem("Kiwi");
        addSalesPage.choosePaymentStatus();
        addSalesPage.submitAddSale();
        softAssert.assertTrue(addSalesPage.verifyAddSaleSuccess(), "verify add sale success");
        softAssert.assertAll();
    }
    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "Login", 0, 2);
    }
}
