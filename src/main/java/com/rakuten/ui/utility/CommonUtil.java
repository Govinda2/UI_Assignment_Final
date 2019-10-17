package com.rakuten.ui.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtil {
    public static void waitTillElementFound(WebElement ElementTobeFound,
                                            int seconds, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(ElementTobeFound));
    }
}
