package com.rakuten.ui.testcases;

import com.rakuten.ui.base.TestBase;
import com.rakuten.ui.pages.HomePage;
import com.rakuten.ui.pages.LoginPage;
import com.rakuten.ui.utility.CommonUtil;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC_002_UI_Login extends TestBase {

    private String ERROR_DIESE_EMAIL_KOMB = "Bitte überprüfen Sie Ihre Eingaben.";
    private String ERROR_BIITE_SIE_THRE = "Diese E-Mail-Passwort-Kombination ist uns nicht bekannt. Bitte korrigieren Sie Ihre Eingabe.";

    @Description("Verify user cannot login with a valid username and an invalid password.")
    @Parameters({"username"})
    @Test
    void loginInvalidPassword(String username)  {

        HomePage.lnk_LogIn(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.txtbx_loginEmail(driver), 5, driver);
        LoginPage.txtbx_loginEmail(driver).sendKeys(username);
        LoginPage.txtbx_loginPassword(driver).sendKeys("test~!@#$%^&*()_+");
        LoginPage.btn_submit(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.lbl_message_error(driver), 5, driver);
        String ActualErrorName = LoginPage.lbl_message_error(driver).getText();
        LoginPage.lbl_message_error(driver).getText();
        Assert.assertEquals( ActualErrorName,ERROR_BIITE_SIE_THRE);
    }

    @Description("Verify user cannot login with a invalid username and an valid password.")
    @Test
    @Parameters({"password"})
    void loginInvalidUserName(String password)  {
        HomePage.lnk_LogIn(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.txtbx_loginEmail(driver), 5, driver);
        LoginPage.txtbx_loginEmail(driver).sendKeys("test!@#$^&^**)(()<>");
        LoginPage.txtbx_loginPassword(driver).sendKeys(password);
        LoginPage.btn_submit(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.lbl_message_error(driver), 5, driver);
        String ActualErrorName = LoginPage.lbl_message_error(driver).getText();
        LoginPage.lbl_message_error(driver).getText();
        Assert.assertEquals(ActualErrorName,ERROR_DIESE_EMAIL_KOMB);
    }

    @Description("Verify if use is able to login with a valid username and valid password.")
    @Test(priority = 1)
    @Parameters({"username", "password"})
    void loginHappyScenario(String username, String password) {
        logger.info("TC LoginHappyScenario");
        HomePage.lnk_LogIn(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.txtbx_loginEmail(driver), 5, driver);
        LoginPage.txtbx_loginEmail(driver).sendKeys(username);
        LoginPage.txtbx_loginPassword(driver).sendKeys(password);
        LoginPage.btn_submit(driver).click();
        CommonUtil.waitTillElementFound(LoginPage.lbl_message_error(driver), 5, driver);
        LoginPage.lbl_message_error(driver).getText();
        String loginname = HomePage.lnk_user_name(driver).getText();
        Assert.assertEquals(loginname, "solanki.govinda@gmail.com");
    }

}
