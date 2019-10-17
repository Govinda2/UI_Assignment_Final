package com.rakuten.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
    private static WebElement element = null;
    public static WebElement btn_go_to_checkout(WebDriver driver){
        element = driver.findElement(By.id("go_to_checkout"));
        return element;
    }
    public static WebElement btn_go_to_next_step(WebDriver driver){
        element = driver.findElement(By.id("go_to_next_step"));
        return element;
    }
}
