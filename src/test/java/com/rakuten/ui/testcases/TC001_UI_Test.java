package com.rakuten.ui.testcases;

import com.rakuten.ui.base.TestBase;
import com.rakuten.ui.pages.CheckOutPage;
import com.rakuten.ui.pages.HomePage;
import com.rakuten.ui.pages.ProductPage;
import com.rakuten.ui.pages.SearchPage;
import com.rakuten.ui.utility.CommonUtil;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_UI_Test extends TestBase {
    private String homeTitle = "Rakuten.de | Handys, PCs, Software, Möbel, neueste Mode und mehr günstig online shoppen | Rakuten";
    private String kleiderschrankTitle = "Suche nach mobiler kleiderschrank | Rakuten";
    private String LG4kCHDTitle = "Suche nach LG 4K Ultra HD OLED-Fernseher OLED55C9 | Rakuten";

    @Description("Verify title of the page")
    @Test
    void checkTitle() {
        logger.info("************  Strated checkTitle test case  ****************");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, homeTitle);
    }

    @Description("Search product and verify page title")
    @Test
    void searchProductandVerifyPageTitle() {
        logger.info("************  Started Search Mobile  TC ****************");
        HomePage.enterSearchText(driver, "mobile", true);
        logger.debug("Entering search Text: mobile");
        CommonUtil.waitTillElementFound(HomePage.div_eac_container_search_input(driver), 5, driver);
        HomePage.div_eac_container_search_input(driver).click();
        HomePage.btn_SearchIcon(driver).click();
        CommonUtil.waitTillElementFound(SearchPage.h1_searchTtile(driver), 10, driver);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, kleiderschrankTitle);
    }
    @Description("Select product and go to the checkout page")
    @Test
        void selectProductCheckout ()  {
        logger.info("************  Started select produt checkout  TC ****************");
//        HomePage.txtbx_SearchBar(driver).sendKeys("LG 4K Ultra HD OLED-Fernseher OLED55C9");
        HomePage.enterSearchText(driver,"LG 4K Ultra HD OLED-Fernseher OLED55C9",true);
        HomePage.btn_SearchIcon(driver).click();
        CommonUtil.waitTillElementFound(ProductPage.lnk_product_Lg4k(driver),10,driver);
        ProductPage.lnk_product_Lg4k(driver).click();
        CommonUtil.waitTillElementFound(ProductPage.btn_add_cart(driver),10,driver);
        ProductPage.btn_add_cart(driver).click();
        CommonUtil.waitTillElementFound(ProductPage.btn_back(driver),10,driver);
         ProductPage.btn_back(driver).click();
        CommonUtil.waitTillElementFound(CheckOutPage.btn_go_to_checkout(driver),10,driver);
        CheckOutPage.btn_go_to_checkout(driver).click();
        CommonUtil.waitTillElementFound(CheckOutPage.btn_go_to_next_step(driver),10,driver);
        String nextsteptext  = CheckOutPage.btn_go_to_next_step(driver).getText();
        Assert.assertEquals(nextsteptext," ZUM NÄCHSTEN SCHRITT");
    }

}
