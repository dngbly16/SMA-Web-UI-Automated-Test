package tests;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.ListProductsPage;
import pages.LoginPage;
import pages.ProductDetailModal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC04 extends BaseTest {
    @Test(dataProvider = "modalElementsData")
    public void testMethod(String type, String name, String code, String category, String unit, String cost, String price, String taxRate, String taxMethod, String alertQuantity){
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage();
        softAssert.assertTrue(loginPage.verifyUserNameTextBoxDisplayed(), "verify username displayed");
        loginPage.login("admin@tecdiary.com", "12345678");
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        softAssert.assertTrue(dashboardPage.verifyMessageWithTextDisplayed(), "verify login success");
        dashboardPage.moveToListProductsPage();
        ListProductsPage listProductsPage = new ListProductsPage(getDriver());
        softAssert.assertTrue(listProductsPage.verifyListProductPage(), "verify list product page");
        listProductsPage.openLemonProductDetail();
        ProductDetailModal productDetailModal = new ProductDetailModal(getDriver());
        softAssert.assertTrue(productDetailModal.verifyProductDetailModal(), "verify product detail modal");
        softAssert.assertTrue(productDetailModal.verifyProductImage(), "verify product image");
        softAssert.assertTrue(productDetailModal.verifyBarAndQRCode(), "verify bar&qr code");
        softAssert.assertTrue(productDetailModal.verifyProductDetail(), "verify product detail area");
        softAssert.assertTrue(productDetailModal.verifyProductType(type), "verify product type");
        softAssert.assertTrue(productDetailModal.verifyProductName(name), "verify product name");
        softAssert.assertTrue(productDetailModal.verifyProductCode(code), "verify product code");
        softAssert.assertTrue(productDetailModal.verifyProductCategory(category), "verify product category");
        softAssert.assertTrue(productDetailModal.verifyProductUnit(unit), "verify product unit");
        softAssert.assertTrue(productDetailModal.verifyProductCost(cost), "verify product cost");
        softAssert.assertTrue(productDetailModal.verifyProductPrice(price), "verify product price");
        softAssert.assertTrue(productDetailModal.verifyProductTaxRate(taxRate), "verify product tax rate");
        softAssert.assertTrue(productDetailModal.verifyTaxMethod(taxMethod), "verify product tax method");
        softAssert.assertTrue(productDetailModal.verifyAlertQuantity(alertQuantity), "verify product alert quantity");
    }
    @DataProvider(name = "modalElementsData")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("./src/main/resources/TestData.xlsx", "TC04", 3, 10);
    }
}
