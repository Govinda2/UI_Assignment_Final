package com.rakuten.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static WebElement element = null;

    public static WebElement txtbx_loginEmail(WebDriver driver){
        element = driver.findElement(By.name("loginEmail"));
        return element;
    }
    public static WebElement txtbx_loginPassword(WebDriver driver){
        element = driver.findElement(By.name("loginPassword"));
        return element;
    }
    public static WebElement btn_submit(WebDriver driver){
        element = driver.findElement(By.id("recaptcha-submit"));
        return element;
    }
    public static WebElement lbl_message_error(WebDriver driver){
        element = driver.findElement(By.xpath("//div[contains(@class,'message-error')]"));
        return element;
    }
}
