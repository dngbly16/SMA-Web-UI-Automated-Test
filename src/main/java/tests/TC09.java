package tests;

import core.BaseTest;
import core.ExcelUtils;
import pages.AddPurchasePage;
import pages.DashboardPage;
import pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC09 extends BaseTest {
    @Test(dataProvider = "testData")
    public void testMethod(String username, String password, String warehouse, String status, String supplier, String product){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username display");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyDashboardPage(), "verify dashboard page");
        dashboardPage.moveToAddPurchase();
        AddPurchasePage addPurchasePage = new AddPurchasePage(getDriver());
        softAssert.assertTrue(addPurchasePage.verifyAddPurchasePage(), "verify add purchase page");
        addPurchasePage.chooseWarehouse(warehouse);
        addPurchasePage.chooseStatus(status);
        addPurchasePage.chooseSupplier(supplier);
        addPurchasePage.inputProductToOrder(product);
        addPurchasePage.clickSubmit();
        softAssert.assertTrue(addPurchasePage.verifyAddPurchaseSuccess(), "verify add purchase success");
        softAssert.assertAll();
    }
    @DataProvider(name = "testData")
    public Object[][] getTestData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "TC09", 0, 6);
    }
}
