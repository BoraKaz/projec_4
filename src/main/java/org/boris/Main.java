package org.boris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {
    public static void main(String[] args) {
        //
        String URL2 = "https://www.aliexpress.us/";
        String URL = "https://www.ebay.com";
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit(URL);

        WebElement advSearchButton = driver.findElement(By.id("gh-as-a"));
        advSearchButton.click();
        WebElement searchFieald1 =driver.findElement(By.className("textbox__control"));
        searchFieald1.click();
        String searchItem = "PALWORLD ULTIMATE PACK ALL PALS AND ITEMS 100% SAFE STEAM/XBOX";
        searchFieald1.sendKeys(searchItem);
        WebElement keyWords = driver.findElement(By.id("s0-1-17-4[0]-7[1]-_in_kw"));
        Select dropDown = new Select(keyWords);
        dropDown.selectByValue("2");
        WebElement category = driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat"));
        Select dropDown2 = new Select(category);
        dropDown2.selectByIndex(33);
        WebElement searchInclude = driver.findElement(By.id("s0-1-17-5[1]-[0]-LH_TitleDesc"));
        searchInclude.click();
        WebElement buyingFormat = driver.findElement(By.id("s0-1-17-6[3]-[2]-LH_BIN"));
        buyingFormat.click();
        WebElement conditions = driver.findElement(By.id("s0-1-17-6[4]-[0]-LH_ItemCondition"));
        conditions.click();
        WebElement sortBy = driver.findElement(By.id("s0-1-17-8[9]-1[0]-_sop"));
        Select dropDown3 = new Select(sortBy);
        dropDown3.selectByValue("12");
        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn--primary']"));
        searchButton.click();
        WebElement item = driver.findElement(By.partialLinkText("PALWORLD"));
        item.click();
        /*WebElement titleText = driver.findElements(By.className("ux-textspans.ux-textspans--BOLD"));
        titleText.getText();
        System.out.println(titleCopy);*/
        //driver.get(URL2);


    }
}