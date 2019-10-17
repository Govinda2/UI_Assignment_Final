package com.rakuten.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static WebElement element = null;

    public static WebElement lnk_LogIn(WebDriver driver){
        element = driver.findElement(By.xpath("//a[text()='Einloggen']"));
        return element;
    }
    public static WebElement lnk_user_name(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(@class, 'points -user') ]//div[contains(@class, 'name') ]"));
        return element;
    }

    public static WebElement txtbx_SearchBar(WebDriver driver){
        element = driver.findElement(By.id("search-input"));
        return element;
    }

    public static WebElement btn_SearchIcon(WebDriver driver){
        element = driver.findElement(By.xpath("//button[contains(@class,'button-search')]"));
        return element;
    }

    public static WebElement div_eac_container_search_input(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='eac-container-search-input']//div[contains(string(), 'kleiderschrank')]"));
        return element;
    }

    public static void enterSearchText(WebDriver driver, String searchText,boolean clrbfrEnt){
        WebElement textBox = txtbx_SearchBar(driver);
        if(clrbfrEnt){
            textBox.clear();
        }
        textBox.sendKeys(searchText);
    }
}
