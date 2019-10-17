package com.rakuten.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private static WebElement element = null;
    public static WebElement h1_searchTtile(WebDriver driver){
        element = driver.findElement(By.id("//h1[contains(@class,'search-title')]"));
        return element;
    }


}
