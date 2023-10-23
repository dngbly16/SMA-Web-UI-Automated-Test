package tests;

import core.BaseTest;
import core.ExcelUtils;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PrintBarcodePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC06 extends BaseTest {

    @Test(dataProvider = "printData")
    public void testMethod(String product, String style, String site, String name, String price,
                           String unit, String category) {
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "Verify username display");
        loginPage.login("admin@tecdiary.com", "12345678");
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyMessageWithTextDisplayed(), "Verify success message");
        dashboardPage.moveToPrintBarcodePage();
        PrintBarcodePage printBarcodePage = new PrintBarcodePage(getDriver());
        softAssert.assertTrue(printBarcodePage.verifyPrintBarcodePage(), "Verify print barcode page");
        printBarcodePage.inputProduct(product);
        printBarcodePage.chooseStyle(style);
        printBarcodePage.checkAllPrintCheckboxes();
        printBarcodePage.clickUpdate();
        softAssert.assertTrue(printBarcodePage.verifyBarcodeProductImage(), "Verify product image");
        softAssert.assertTrue(printBarcodePage.verifyBarcodeSite(), "Verify barcode site");
        softAssert.assertEquals(printBarcodePage.getPrintBarcodeSiteText(), site, "Verify barcode site text");
        softAssert.assertTrue(printBarcodePage.verifyBarcodeName(), "Verify barcode name");
        softAssert.assertEquals(printBarcodePage.getPrintBarcodeNameText(), name, "Verify barcode name text");
        softAssert.assertTrue(printBarcodePage.verifyBarcodePrice(), "Verify barcode price");
        softAssert.assertEquals(printBarcodePage.getPrintBarcodePriceText(), price, "Verify barcode price text");
        softAssert.assertTrue(printBarcodePage.verifyBarcodeUnit(), "Verify barcode unit");
        softAssert.assertEquals(printBarcodePage.getPrintBarcodeUnitText(), unit, "Verify barcode unit text");
        softAssert.assertTrue(printBarcodePage.verifyBarcodeCategory(), "Verify barcode category");
        softAssert.assertEquals(printBarcodePage.getPrintBarcodeCategoryText(), category, "Assert barcode category text");
        softAssert.assertTrue(printBarcodePage.verifyBarcodeImage(), "Verify barcode image");
        softAssert.assertAll();
    }

    @DataProvider(name = "printData")
    public Object[][] getPrintData() {
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "TC06", 0, 7);
    }
}
