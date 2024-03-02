package org.boris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Main {
    public static void main(String[] args) {
        // Initialize SeleniumBase and open the AliExpress URL
        String aliexpressURL = "https://www.aliexpress.us/";
        String ebayURL = "https://www.ebay.com";
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit(aliexpressURL);
        // Close the pop-up window
        WebElement closePopUpWindow = driver.findElement(By.className("pop-close-btn"));
        closePopUpWindow.click();
        // Enter search term "samsung galaxy s10" and click the search button
        WebElement aliexpressSearch = driver.findElement(By.id("search-words"));
        aliexpressSearch.click();
        String aliSearchItem = "samsung galaxy s10";
        aliexpressSearch.sendKeys(aliSearchItem);
        WebElement aliSearchButton = driver.findElement(By.className("search--submit--2VTbd-T"));
        aliSearchButton.click();
        // Extract and process price information
        WebElement priceElement = driver.findElement(By.className("multi--price-sale--U-S0jtj"));
        String priceText = priceElement.getText();
        priceText = priceText.replaceAll("[^\\d.]", "");// Remove non-numeric characters
        double aliexpressPriceNumber = Double.parseDouble(priceText);
        System.out.println(aliexpressPriceNumber);
        // Get the title of the product
        WebElement titleOfProduct = driver.findElement(By.className("multi--titleText--nXeOvyr"));
        String productName = titleOfProduct.getText();
        

        driver.get(ebayURL);
        // Click the "Advanced Search" button
        WebElement advSearchButton = driver.findElement(By.id("gh-as-a"));
        advSearchButton.click();
        // Enter the product name in the search field
        WebElement searchFieald1 = driver.findElement(By.className("textbox__control"));
        searchFieald1.click();
        searchFieald1.sendKeys(productName);
        // Select search options (keywords, category, etc.)
        WebElement keyWords = driver.findElement(By.id("s0-1-17-4[0]-7[1]-_in_kw"));
        Select dropDown = new Select(keyWords);
        dropDown.selectByValue("1");
        // Choose a category (index 6 corresponds to a specific category)
        WebElement category = driver.findElement(By.id("s0-1-17-4[0]-7[3]-_sacat"));
        Select dropDown2 = new Select(category);
        dropDown2.selectByIndex(6);
        // Include search terms in title and description
        WebElement searchInclude = driver.findElement(By.id("s0-1-17-5[1]-[0]-LH_TitleDesc"));
        searchInclude.click();
        // Select buying format (e.g., Buy It Now)
        WebElement buyingFormat = driver.findElement(By.id("s0-1-17-6[3]-[2]-LH_BIN"));
        buyingFormat.click();
        // Choose item condition (e.g., New)
        WebElement conditions = driver.findElement(By.id("s0-1-17-6[4]-[0]-LH_ItemCondition"));
        conditions.click();
        // Sort results by a specific criterion (e.g., price ascending)
        WebElement sortBy = driver.findElement(By.id("s0-1-17-8[9]-1[0]-_sop"));
        Select dropDown3 = new Select(sortBy);
        dropDown3.selectByValue("16");
        // Click the search button
        WebElement searchButton = driver.findElement(By.cssSelector("button[class='btn btn--primary']"));
        searchButton.click();
        // Locate the eBay price element
        WebElement eBayPriceElement = driver.findElement(By.cssSelector("#item44d049027f > div > div.s-item__info.clearfix > div.s-item__details.clearfix > div:nth-child(1) > span"));
        String eBayPriceText = eBayPriceElement.getText();
        // Remove non-numeric characters from the eBay price text
        eBayPriceText = eBayPriceText.replaceAll("[^\\d.]", "");
        // Convert the cleaned eBay price text to a double
        double eBayPriceNumber = Double.parseDouble(eBayPriceText);
        System.out.println(eBayPriceNumber);
        // Compare AliExpress and eBay prices
        if (aliexpressPriceNumber <= eBayPriceNumber){
            System.out.println("The AliExpress search equivalent item is lower price: " +aliexpressPriceNumber);
        }else System.out.println("The eBay search equivalent item is lower price: " +eBayPriceNumber);

        driver.close();
    }
}