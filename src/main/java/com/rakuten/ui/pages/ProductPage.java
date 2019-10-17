package com.rakuten.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private static WebElement element = null;
    public static WebElement lnk_product_Lg4k(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(@href,'produkt/lg-4k-ultra-hd-oled-fernseher-oled')]"));
        return element;
    }

    public static WebElement btn_add_cart(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(text(),'In Den Warenkorb') and contains(@class,'button add-cart -red')]"));
        return element;
    }
    public static WebElement btn_back(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(@href,'shopcart') and contains(@class,'button -back')]"));
        return element;
    }
}
